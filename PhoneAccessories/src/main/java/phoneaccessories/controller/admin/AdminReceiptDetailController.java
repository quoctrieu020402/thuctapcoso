package phoneaccessories.controller.admin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import aj.org.objectweb.asm.Type;
import phoneaccessories.Utils.SecurityUtils;
import phoneaccessories.entity.Account;
import phoneaccessories.entity.Product;
import phoneaccessories.entity.Receipt;
import phoneaccessories.entity.ReceiptDetail;
import phoneaccessories.entity.Staffs;
import phoneaccessories.repository.ReceiptDetailRepository;
import phoneaccessories.repository.ReceiptRepository;
import phoneaccessories.service.AccountService;
import phoneaccessories.service.ProductService;
import phoneaccessories.service.ReceiptService;
import phoneaccessories.service.StaffService;

@Controller
@RequestMapping("/admin/")
public class AdminReceiptDetailController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ReceiptService receiptService;
	
	@Autowired
	private ReceiptDetailRepository receiptDetailRepository;
	
	@Autowired
	private ReceiptRepository receiptRepository;
	
	@GetMapping("receipt-detail/list")
	public ModelAndView getListReceiptDetail(@RequestParam("idr") String idr) {
		
		ModelAndView mav = new ModelAndView();
		List<ReceiptDetail> listReceiptDetail = receiptDetailRepository.findAllById_Receipt(idr);
		mav.addObject("listReceiptDetail", listReceiptDetail);
		float sum = 0;
		for (ReceiptDetail receiptDetail : listReceiptDetail) {
			sum += receiptDetail.getQuantity() * receiptDetail.getPrice();
		}
		mav.addObject("sum", sum);
		Receipt receipt = receiptService.findById(idr);
		mav.addObject("receipt", receipt);
		mav.setViewName("admin/receipt/receipt-detail/list-receiptdetail");
		return mav;
		
	}
	
	@GetMapping("receipt-detail/confirmz")
	public ModelAndView confirmReceiptDetail(@RequestParam("idr") String idr , @RequestParam(value = "status",required = false) String status) {
		ModelAndView mav = new ModelAndView();
		
		Receipt receipt = receiptService.findById(idr);
		if (status == null) {
			receipt.setStatus(1);// 1 đã xác nhận
		}
		else
		{
			receipt.setStatus(2);// 2 đã hủy
		}
		
		receiptRepository.save(receipt);
		
		mav.setViewName("redirect:/admin/receipt/list");
		return mav;
	}
	
	@GetMapping("receipt-detail/quantity")
	public ModelAndView getQuantityRcDl(@RequestParam("idr") String idr) {
		ModelAndView mav = new ModelAndView("/admin/receipt/quantityRcDl");
		mav.addObject("idr", idr);
		return mav;
	}
	
	@PostMapping("receipt-detail/quantity")
	public ModelAndView setUpQuantityRcDl(@RequestParam("idr") String idr,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/admin/receipt/quantityRcDl");
		String quantityRcDl = request.getParameter("quantityRcDl");
		mav.addObject("idr", idr);
		int quantity = Integer.valueOf(quantityRcDl);
		if (quantity < 0) {
			mav.setViewName("/admin/receipt/quantityRcDl");
		}else {
			Receipt receipt = new Receipt();
			List<ReceiptDetail> listReceiptDetail = new ArrayList<>();
			mav.setViewName("/admin/receipt/receipt-detail/create-receiptdetail");
			for (int i = 0; i<quantity ; i++) {
				ReceiptDetail receiptDetail = new ReceiptDetail();
				receiptDetail.setPrice(0);
				receiptDetail.setQuantity(0);
				listReceiptDetail.add(receiptDetail);
			}
			
			receipt.setListReceiptDetail(listReceiptDetail);
			receipt.setId(idr);
			mav.addObject("chiTietPhieuNhap", receipt);
			
		}
		return mav;
		
	}
	
	@PostMapping("receipt-detail/create")
	public ModelAndView viewCreateReceiptDetail(@ModelAttribute("chiTietPhieuNhap") Receipt receipt ,@RequestParam("idr") 
	String idr) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/receipt/receipt-detail/create-receiptdetail");
		receipt.setId(idr);
		receiptService.save(receipt);
		
		List<ReceiptDetail> receiptDetails = receipt.getListReceiptDetail();
		
		float sum = 0;
		for (ReceiptDetail receiptDetail : receiptDetails) {
			sum += receiptDetail.getQuantity() * receiptDetail.getPrice();
		}
		mav.addObject("sum", sum);
		return mav;
	}
	@ModelAttribute("products")
	public List<Product> getlistProduct(){
		List<Product> listProduct = productService.getListProduct();
		return listProduct;
	}
	
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private AccountService accountService;
	
	@ModelAttribute("staff")
	public Staffs getStaff() {
		Account account = accountService.findByUsername(SecurityUtils.getPrincipal().getUsername());
		Staffs staff = staffService.findOneByAccount(account);
		return staff;
	}
}
