package phoneaccessories.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import phoneaccessories.Utils.SecurityUtils;
import phoneaccessories.entity.Account;
import phoneaccessories.entity.CardDetail;
import phoneaccessories.entity.Order;
import phoneaccessories.entity.Staffs;
import phoneaccessories.service.AccountService;
import phoneaccessories.service.OrderDetailService;
import phoneaccessories.service.OrderService;
import phoneaccessories.service.StaffService;

@Controller

@RequestMapping("/admin")


public class AdminOrderController {
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private StaffService staffService ;
	
	@RequestMapping("order/list")
	public ModelAndView listOrder() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/order/list-order");
		List<Order> listOrder = orderService.getListOrder();
		mav.addObject("listOrder", listOrder);
		return mav;
	}
	
	@RequestMapping("order/detail")
	public ModelAndView orderDetail(@RequestParam("idc") String idc) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/order/detail-order");
		
		List<CardDetail> listOrderDetail = orderDetailService.findAllByCardId(idc);
		mav.addObject("listOrderDetail", listOrderDetail);
		
		Order order = orderService.findOneByCart_Id(idc);
		mav.addObject("order", order);
		return mav;
	}
	
	@RequestMapping("order/confirm")
	public ModelAndView confirmDetail(@RequestParam("ido") String ido ,@RequestParam(value = "status",required = false) String status) {
		Account account = accountService.findByUsername(SecurityUtils.getPrincipal().getUsername());
		
		Staffs staff = staffService.findOneByAccount(account);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/admin/order/list");
		Long number = Long.valueOf(ido);
		Order order = orderService.findOneById(number);
		
		if (status!=null) {
			order.setStatus("Đã Bị Hủy");
		}
		else
		{
			order.setStatus("Đã Xác Nhận");
		}
		
		order.setStaff(staff);
		orderService.save(order);
		return mav;
	}
	
	@RequestMapping("order/ship")
	public ModelAndView orrderShip(@RequestParam("ido") String ido) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/admin/order/list");
		Long number = Long.valueOf(ido);
		Order order = orderService.findOneById(number);
		
		order.setStatus("Đã Giao Cho Đơn Vị Vận Chuyển");
		
		orderService.save(order);
		return mav;
	}
	
	
	
	@ModelAttribute("staff")
	public Staffs getStaff() {
		Account account = accountService.findByUsername(SecurityUtils.getPrincipal().getUsername());
		Staffs staff = staffService.findOneByAccount(account);
		return staff;
	}
}
