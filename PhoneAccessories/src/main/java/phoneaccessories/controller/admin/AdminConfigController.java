package phoneaccessories.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import phoneaccessories.entity.Config;
import phoneaccessories.entity.Product;
import phoneaccessories.service.ConfigService;
import phoneaccessories.service.ProductService;

@Controller

@RequestMapping("/admin/")
public class AdminConfigController {
	
	@Autowired
	private ConfigService configService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("config/list")
	public ModelAndView viewConfig(@RequestParam("idp") String idp) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/config/list-config");
		Config config = configService.findOneByListProduct_Id(idp);
		mav.addObject("config", config);
		return mav;
	}
	
	
	@RequestMapping("config/add")
	public ModelAndView viewAddConfig() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/config/add-config");
		Config config = new Config();
		mav.addObject("addConfig", config);
		return mav;
	}
	
	@PostMapping("config/add")
	public ModelAndView addConfig(@RequestParam("idp") String idProduct, @ModelAttribute("addConfig") Config config ) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/config/add-config");
		
		config.setId("manv1");
		configService.save(config);
		Product product = productService.getProductById(idProduct);
		product.setConfig(config);
		productService.save(product);	
		return mav;
	}
}
