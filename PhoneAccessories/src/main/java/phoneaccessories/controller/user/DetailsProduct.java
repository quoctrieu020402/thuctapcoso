package phoneaccessories.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import phoneaccessories.entity.Product;
import phoneaccessories.service.ProductService;

@Controller
@RequestMapping("/user/")
public class DetailsProduct {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("{idP}/compare/{idP2}")
	public ModelAndView showProductDetail(@PathVariable(name = "idP") String idP, @PathVariable(name = "idP2") String idP2) {
	    ModelAndView mav = new ModelAndView("user/compare");
		Product product = productService.getProductById(idP);
	    Product product2 = productService.getProductById(idP2);
	    mav.addObject("product1", product);
	    mav.addObject("product2", product2);
	    return mav;
	}
	
}

