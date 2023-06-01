package phoneaccessories.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import phoneaccessories.entity.Account;
import phoneaccessories.entity.User;
import phoneaccessories.service.UserService;

@Controller
@RequestMapping("/user")
public class ProfileCustomerController {

	@Autowired
	private UserService userService;

	@GetMapping("/profile/{account}")
	public ModelAndView showProfile(@PathVariable String account) {
		ModelAndView mav = new ModelAndView("user/profileCustomer");
		User user = userService.getUserByAccount(account);
		mav.addObject("user", user);

		return mav;
	}

	@PostMapping("/customer/{account}/update")
	public String saveProfile(@PathVariable String account, @ModelAttribute("updateUser") User user) {
	    userService.update(user);
	    return "redirect:/user/profile/" + account;
	}
}
