package phoneaccessories.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import phoneaccessories.entity.Product;
import phoneaccessories.repository.OrderRepository;
import phoneaccessories.repository.UserRepository;
import phoneaccessories.service.AccountService;
import phoneaccessories.service.CartService;
import phoneaccessories.service.ProductService;
import phoneaccessories.service.UserService;
import phoneaccessories.service.Impl.AccountServiceImpl;

@Controller
@RequestMapping("/user")
public class UserHomeController {

	@Autowired
	private ProductService productService;

	@Autowired
	AccountServiceImpl accountServiceImpl;

	@Autowired
	AccountService accountService;

	@Autowired
	CartService cartservice;

	@Autowired
	UserService userSV;

	@Autowired
	OrderRepository orderRpstr;

	@Autowired
	UserRepository userRpstr;

	@RequestMapping("/product")
	public ModelAndView getProductListByCategoryId(@RequestParam(value = "categoryId", required = false) String id) {
		List<Product> productList = new ArrayList<>();
		if (id == null) {
			productList = productService.getListProduct();
			System.out.println("AAa");

		} else {
			productList = productService.getProductByCategoryId(id);
			System.out.println("DĐ");
		}
		ModelAndView mav = new ModelAndView("user/product");
		mav.addObject("listProduct", productList);
		return mav;
	}

	@GetMapping("/findbycenterprice")
	public ModelAndView filterByPriceRange(@RequestParam("price1") double price1,
			@RequestParam("price2") double price2) {
		List<Product> productList = productService.filterByPriceRange(price1, price2);
		ModelAndView mav = new ModelAndView("user/product");
		mav.addObject("listProduct", productList);
		return mav;
	}

	@GetMapping("/findprice")
	public ModelAndView filterByPrice(@RequestParam("price") double price) {
		List<Product> productList = productService.filterByPrice(price);
		ModelAndView mav = new ModelAndView("user/product");
		mav.addObject("listProduct", productList);
		return mav;
	}

	@GetMapping("/price")
	public ModelAndView getProductsBySortType(@RequestParam("sortType") String sortType) {
		List<Product> products = new ArrayList<>();
		if (sortType.equals("price-asc")) {
			products = productService.getProductsOrderByPriceAsc();
		} else if (sortType.equals("price-desc")) {
			products = productService.getProductsOrderByPriceDesc();
		} else if (sortType.equals("name-asc")) {
			products = productService.getProductsOrderByNameAsc();
		} else if (sortType.equals("name-desc")) {
			products = productService.getProductsOrderByNameDesc();
		}
		ModelAndView mv = new ModelAndView("user/product");
		mv.addObject("listProduct", products);
		return mv;
	}

	@GetMapping("/search")
	public String search(@RequestParam("keyword") String keyword, Model model) {
		List<Product> searchResults = productService.searchByName(keyword);
		model.addAttribute("searchResults", searchResults);

		return "user/product";
	}

	@RequestMapping(value = "/product_detail")
	public ModelAndView product_detail(@RequestParam(value = "id", required = false) String id) {
		ModelAndView mv = new ModelAndView("user/DetailsProduct");
		List<Product> listProduct = new ArrayList<>();
		listProduct = productService.getListProduct();
		mv.addObject("listProduct", listProduct);

		Product product = productService.getProductById(id);
		List<Product> suggestedProducts = productService.getRelatedProducts(product);
		mv.addObject("product", product);
		mv.addObject("suggestedProducts", suggestedProducts);
		return mv;
	}

	
}