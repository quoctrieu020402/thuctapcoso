package phoneaccessories.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import phoneaccessories.entity.Receipt;
import phoneaccessories.entity.Supplier;
import phoneaccessories.service.ReceiptService;
import phoneaccessories.service.SupplierService;

@Controller
@RequestMapping("/admin/")
public class AdminReceiptController {
	@Autowired
	private SupplierService supplierServicel;
	
	@Autowired
	private ReceiptService receiptService;
	
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
		receiptService.save(receipt);
		return mav;
				
	}
	@ModelAttribute("suppliers")
	public List<Supplier> listSupplier(){
		List<Supplier> list = new ArrayList<Supplier>() ;
		list.addAll(supplierServicel.getListSupplier());
		return list;
	}
}
