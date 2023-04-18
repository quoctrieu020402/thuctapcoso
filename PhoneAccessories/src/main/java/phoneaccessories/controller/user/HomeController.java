package phoneaccessories.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/user/")
public class HomeController {
	
	@GetMapping("home")
	public ModelAndView home(ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("admin/home-admin");
		return mav;
	}
}
