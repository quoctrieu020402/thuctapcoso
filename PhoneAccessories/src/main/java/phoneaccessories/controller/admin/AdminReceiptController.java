package phoneaccessories.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import phoneaccessories.Utils.SecurityUtils;
import phoneaccessories.entity.Account;
import phoneaccessories.entity.Product;
import phoneaccessories.entity.Receipt;
import phoneaccessories.entity.ReceiptDetail;
import phoneaccessories.entity.Staffs;
import phoneaccessories.entity.Supplier;
import phoneaccessories.repository.ProductPepository;
import phoneaccessories.repository.ReceiptRepository;
import phoneaccessories.service.AccountService;
import phoneaccessories.service.ProductService;
import phoneaccessories.service.ReceiptService;
import phoneaccessories.service.StaffService;
import phoneaccessories.service.SupplierService;

@Controller
@RequestMapping("/admin/")
public class AdminReceiptController {
	@Autowired
	private SupplierService supplierServicel;
	
	@Autowired
	private ReceiptService receiptService;
	
	@Autowired
	private ReceiptRepository receiptRepository;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired 
	private ProductPepository pepository;
	
	@RequestMapping("receipt/list")
	public ModelAndView listReceipt() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/receipt/list-receipt");
		List<Receipt> listRc = receiptService.getListReceipt();
		
		mav.addObject("listReceipt", listRc);
		return mav;
	}
	
	@GetMapping("receipt/add")
	public ModelAndView viewAddReceipt() {
		ModelAndView mav = new ModelAndView("admin/receipt/add-receipt");
		Receipt receipt = new Receipt();
		mav.addObject("addreceipt", receipt);
		return mav;
				
	}
	
	@PostMapping("receipt/add")
	public ModelAndView addReceipt(@ModelAttribute("addreceipt") Receipt receipt) {
		ModelAndView mav = new ModelAndView("admin/receipt/add-receipt");
		Account account = accountService.findByUsername(SecurityUtils.getPrincipal().getUsername());
		Staffs staffs = staffService.findOneByAccount(account);
		receipt.setStaff(staffs);
		receipt.setStatus(0); // status = 0 vừa lập phiếu
		receiptService.save(receipt);
		return mav;
				
	}
	
	@GetMapping("receipt/success")
	public ModelAndView successReceipt(@RequestParam("idr") String idr) {
		ModelAndView mav = new ModelAndView();
		Receipt receipt = receiptService.findById(idr);
		receipt.setStatus(3); // 3 đã hoàn thành phiếu nhập
		
		List<ReceiptDetail> receiptDetails = receipt.getListReceiptDetail();
		
		for (ReceiptDetail receiptDetail : receiptDetails) {
			Product product = productService.getProductById(receiptDetail.getProduct().getId());
			product.setNumber(receiptDetail.getQuantity()+receiptDetail.getProduct().getNumber());
			pepository.save(product);
		}
		receiptRepository.save(receipt);
		mav.setViewName("redirect:/admin/receipt/list");
		return mav;
	}
	
	@GetMapping("receipt/delete")
	public ModelAndView deleteReceipt(@RequestParam("idr") String idr) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/admin/receipt/list");
		Receipt receipt = receiptService.findById(idr);
		receiptService.delete(receipt);
		return mav;
}
	
	@ModelAttribute("suppliers")
	public List<Supplier> listSupplier(){
		List<Supplier> list = new ArrayList<Supplier>() ;
		list.addAll(supplierServicel.getListSupplier());
		return list;
	}
	
	@Autowired
	private StaffService staffService;
	
	
	@ModelAttribute("staff")
	public Staffs getStaff() {
		Account account = accountService.findByUsername(SecurityUtils.getPrincipal().getUsername());
		Staffs staff = staffService.findOneByAccount(account);
		return staff;
	}
}
