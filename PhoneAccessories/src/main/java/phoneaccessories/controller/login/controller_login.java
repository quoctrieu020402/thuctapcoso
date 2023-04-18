package phoneaccessories.controller.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import phoneaccessories.entity.Account;
import phoneaccessories.service.Impl.AccountServiceImpl;

@Controller
public class controller_login {
	
	
	
	@Autowired
	private AccountServiceImpl accountImpl;
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login/login");
		Account account = new Account();
		mav.addObject("account",account );
		return mav;
	}
	
	@PostMapping("/login")
	public ModelAndView checklogin(@ModelAttribute("account") Account account) {
		ModelAndView mav = new ModelAndView("login/login");
		String message ="";
		List<String> namelist =  accountImpl.gellListUnameAccount();
		if(namelist.contains(account.getUsername()) ) {
			System.out.println(account.getPasword());
			
			System.out.println(accountImpl.findByUsername(account.getUsername()).getPasword());
			if (account.getPasword().equals(accountImpl.findByUsername(account.getUsername()).getPasword())) {
				mav.setViewName("/admin/home-admin");
				
			}
			else {
				message = "Sai mật khẩu";
				mav.addObject("error", message);
				return mav;
			}
		}
		else {
			message = "Tên đăng nhập không tồn tại";
			mav.addObject("error", message);
			return mav;
		}
		return mav;
	}
	
	@RequestMapping(value = "/signin",method = RequestMethod.GET)
	public ModelAndView singin() {
		ModelAndView mav = new ModelAndView("login/signin");
		Account account = new Account();
		mav.addObject("account",account );
		return mav;
		
	}
	@PostMapping("/signup")
	public ModelAndView creatAccount(@ModelAttribute("account") Account account , @RequestParam("passwordConfirm") String paswordCf,BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView("login/signin");
		mav.addObject("check", true);
		String message ="";
		
		if (account.getUsername() == "") {
			message = "Tài khoản không được để trống";
			mav.addObject("errorun", message);
			return mav;
		}
		
		if (account.getEmail() == "") {
			message = "Email không được để trống";
			mav.addObject("errorem", message);
			return mav;
		}
		
		if (account.getPasword()== "") {
			message = "Mật khẩu không được để trống";
			mav.addObject("errorpw", message);
			return mav;
		}
		if (bindingResult.hasErrors()) {
	        message = "Đăng kí thất bại";
	        mav.addObject("message", message);

	        return mav;
	    }
		if ( !paswordCf.equals(account.getPasword())) {
			mav.addObject("checkPassword", true);
			mav.addObject("error", "Xác thực mật khẩu thất bại");
			message = "Đăng kí thất bại";
			mav.addObject("message", message);
			return mav;
		}
		 message = "Đăng kí thành công";
		 mav.addObject("message", message);
		accountImpl.save(account);
		
		return mav;
		
				
	}
	
}
