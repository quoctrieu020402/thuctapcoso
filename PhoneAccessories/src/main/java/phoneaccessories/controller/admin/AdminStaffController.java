package phoneaccessories.controller.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import phoneaccessories.Utils.RandomStringGenerator;
import phoneaccessories.Utils.SecurityUtils;
import phoneaccessories.entity.Account;
import phoneaccessories.entity.Position;
import phoneaccessories.entity.Staffs;
import phoneaccessories.service.AccountService;
import phoneaccessories.service.PositionService;
import phoneaccessories.service.StaffService;

@Controller
@RequestMapping("/admin")
public class AdminStaffController {
	
	@Autowired 
	PositionService positionService;
	
	@Autowired 
	AccountService accountService;
	
	@Autowired
	StaffService staffService;
	
	
	@RequestMapping("/staff/list")
	public ModelAndView listStaff() {
		ModelAndView mav = new ModelAndView();
		Account account = accountService.findByUsername(SecurityUtils.getPrincipal().getUsername());
		
		mav.setViewName("/admin/staff/list_staff");
		List<Staffs> staffs = staffService.findAllByStatus(true);
		List<Staffs> staffs2 = new ArrayList<>();
		for (Staffs staff : staffs) {
			if (!staff.getAccount().getUsername().equals(account.getUsername())) {
				staffs2.add(staff);
			}
		}
		mav.addObject("listStaff", staffs2);
		
		return mav;
	}
	
	@RequestMapping(value = "/staff/register",method = RequestMethod.GET)
	public ModelAndView singin() {
		ModelAndView mav = new ModelAndView("/admin/staff/add-staff");
		Account account = new Account();
		mav.addObject("account",account );
		return mav;
		
	}
	@SuppressWarnings("null")
	@PostMapping("/staff/signup")
	public ModelAndView creatAccount(@ModelAttribute("account") Account account , @RequestParam("passwordConfirm") String paswordCf,BindingResult bindingResult,
			@RequestParam("role") String role ) {
		ModelAndView mav = new ModelAndView("/admin/staff/add-staff");
		mav.addObject("check", false);
		String message ="";
		
		if (account.getUsername() == "") {
			message = "Tài khoản không được để trống";
			mav.addObject("checktk", true);
			mav.addObject("errorun", message);
			return mav;
		}
		mav.addObject("checktk", false);
		if (account.getEmail() == "") {
			message = "Email không được để trống";
			mav.addObject("checkemail", true);
			mav.addObject("errorem", message);
			return mav;
		}
		mav.addObject("checkemail", false);
		if (account.getPasword()== "") {
			message = "Mật khẩu không được để trống";
			mav.addObject("checkmk", true);
			mav.addObject("errorpw", message);
			return mav;
		}
		mav.addObject("checkmk", false);
		if (bindingResult.hasErrors()) {
	        message = "Đăng kí thất bại";
	        mav.addObject("message", message);

	        return mav;
	    }
		if ( !paswordCf.equals(account.getPasword())) {
			mav.addObject("checkPassword", true);
			mav.addObject("error", "Xác thực mật khẩu thất bại");
			return mav;
		}
		
		
		if (role.equals("ADMIN")) {
			Position position = positionService.findOneByName(role);
			if (position == null) {
				position = new Position();
				position.setId("admin");
				position.setName(role);
				positionService.save(position);
			}
			
			
			account.setPosition(position);
		}
		
		if (role.equals("EMPLOYEE")) {
			Position position = positionService.findOneByName(role);
			if (position == null) {
				position = new Position();
				position.setId("employee");
				position.setName(role);
				positionService.save(position);
			}
			
			account.setPosition(position);
		}
		 message = "Đăng kí thành công";
		 mav.addObject("message", message);
		 mav.addObject("check", true);
		accountService.saveStaff(account);
		
		Staffs staffs = new Staffs();
		staffs.setAccount(account);
		staffs.setId(RandomStringGenerator.generateRandomString(10));
		staffService.save(staffs);
		return mav;
		
				
	}
	
	
	@RequestMapping("/profile")
	public ModelAndView proFile() {
		ModelAndView mav = new ModelAndView();
		
		Account account = accountService.findByUsername(SecurityUtils.getPrincipal().getUsername());
		Staffs staff = staffService.findOneByAccount(account);
		
		mav.addObject("staff", staff);
	
		
		
		mav.setViewName("/admin/staff/profile");
		return mav;
	}
	
	@PostMapping("/profile/edit")
	public ModelAndView editProfile(@ModelAttribute("staff") Staffs staff ,@RequestParam("avatar") MultipartFile avatar,
			@RequestParam("ids") String ids) {
		ModelAndView mav = new ModelAndView();
		
		Account account = accountService.findByUsername(SecurityUtils.getPrincipal().getUsername());
		
		staff.setImage(avatar.getOriginalFilename());
		staff.setId(ids);
		staff.setAccount(account);
		System.out.println(staff.getSurname());
		System.out.println(staff.getName());
		staffService.save(staff);
		
		String message = "";
		mav.setViewName("/admin/staff/profile");
		try {
			MultipartFile multipartFile = avatar;
			String fileName = multipartFile.getOriginalFilename();
			File file = new File("D:\\ProjectLTweb\\PhoneAccessories\\src\\main\\webapp\\templates\\images\\",
					fileName);
			multipartFile.transferTo(file);
			message = "Thêm sản phẩm thành công";
			mav.addObject("message", message);
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("message", "Lưu file ảnh thất bại");
		}
		mav.setViewName("/admin/staff/profile");
		return mav;
	}
	
	@RequestMapping("/staff/delete")
	public ModelAndView deleteStaff(@RequestParam("usernameac") String username) {
		ModelAndView mav = new ModelAndView();
		staffService.delete(username);
		mav.setViewName("redirect:/admin/staff/list");
		return mav;
	}
	
	
	@ModelAttribute("staff")
	public Staffs getStaff() {
		Account account = accountService.findByUsername(SecurityUtils.getPrincipal().getUsername());
		Staffs staff = staffService.findOneByAccount(account);
		return staff;
	}
}
