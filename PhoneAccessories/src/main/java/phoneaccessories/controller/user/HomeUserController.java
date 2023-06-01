package phoneaccessories.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import phoneaccessories.entity.Product;
import phoneaccessories.service.ProductService;

@Controller
public class HomeUserController {
	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public ModelAndView home(Model model) {
		List<Product> productList = productService.getListProduct();
		ModelAndView mav = new ModelAndView("user/home");
		mav.addObject("products", productList);
		return mav;
	}
	@GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        // Tìm kiếm sản phẩm theo tên
        List<Product> searchResults = productService.searchByName(keyword);
        model.addAttribute("searchResults", searchResults);

        return "user/home";
    }

}
