package phoneaccessories.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import phoneaccessories.entity.Product;
import phoneaccessories.service.ProductService;

@Controller
@RequestMapping("/")
public class DetailsProduct {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/product/{id}")
	public ModelAndView showProductDetail(@PathVariable String id) {
	    Product product = productService.getProductById(id);
	    List<Product> suggestedProducts = productService.getRelatedProducts(product);
	    ModelAndView mav = new ModelAndView("user/DetailsProduct");
	    mav.addObject("product", product);
	    mav.addObject("suggestedProducts", suggestedProducts);
	    return mav;
	}

}

