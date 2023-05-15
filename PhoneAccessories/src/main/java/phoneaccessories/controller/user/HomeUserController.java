package phoneaccessories.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user/")
public class HomeUserController {
	
	@GetMapping("home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("user/home");
		
		
		return mav;
	}
}