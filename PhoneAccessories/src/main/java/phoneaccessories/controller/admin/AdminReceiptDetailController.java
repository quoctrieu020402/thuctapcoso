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
import phoneaccessories.entity.Product;
import phoneaccessories.entity.Receipt;
import phoneaccessories.entity.ReceiptDetail;
import phoneaccessories.service.ProductService;
import phoneaccessories.service.ReceiptService;

@Controller
@RequestMapping("/admin/")
public class AdminReceiptDetailController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ReceiptService receiptService;
	
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
				System.out.println(i);
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
		System.out.println(receipt.getListReceiptDetail());
		receiptService.save(receipt);
		
		return mav;
	}
	@ModelAttribute("products")
	public List<Product> getlistProduct(){
		List<Product> listProduct = productService.getListProduct();
		return listProduct;
	}
}
