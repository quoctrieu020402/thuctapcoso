package phoneaccessories.controller.user;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import phoneaccessories.Utils.SecurityUtils;
import phoneaccessories.entity.Account;
import phoneaccessories.entity.CardDetail;
import phoneaccessories.entity.Cart;
import phoneaccessories.entity.Order;
import phoneaccessories.entity.Pays;
import phoneaccessories.entity.Product;
import phoneaccessories.service.AccountService;
import phoneaccessories.service.CartDetailsService;
import phoneaccessories.service.CartService;
import phoneaccessories.service.OrderService;
import phoneaccessories.service.PayService;
import phoneaccessories.service.ProductService;
import phoneaccessories.service.UserService;

@Controller
@RequestMapping("/user/")
public class OrderController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private CartService cartService;

	@Autowired
	private CartDetailsService cartDetailsService;

	@Autowired
	private UserService userService;

	@Autowired
	private PayService payService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;

	@GetMapping("order")
	public ModelAndView showOrder() {

		ModelAndView mav = new ModelAndView("user/OrderSlip");

		Account account = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());

		int possitionCart = account.getUser().getListCart().size() - 1;

		String idCartOfUser = account.getUser().getListCart().get(possitionCart).getId();

		Cart cart = cartService.getCartById(idCartOfUser);

		List<CardDetail> listcart = cartDetailsService.getCartDetailsByIdCart(cart.getId());

		double sumMoney = 0;

		for (CardDetail cardDetail : listcart) {
			sumMoney += cardDetail.getQuantity() * cardDetail.getProduct().getPrice();
		}

		mav.addObject("date", java.time.LocalDate.now());

		mav.addObject("list", listcart);

		mav.addObject("sumMoney", String.format("%.3f", sumMoney));

		return mav;
	}

	@PostMapping("order/confirm")
	public ModelAndView confirmOrder(@RequestParam("ht") String fullName, @RequestParam("sdt") String phone,
			@RequestParam("dc") String address, @RequestParam("nd") String note, @RequestParam("httt") int idPay) {
		ModelAndView mav = new ModelAndView("user/ThankYou");
		
		Account account = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		
		int possitionCart = account.getUser().getListCart().size() - 1;
		
		String idCart = account.getUser().getListCart().get(possitionCart).getId();
		
		Cart cart = cartService.getCartById(idCart);
		
		Order order = new Order();
		order.setCart(cart);
		order.setDate(new Date());
		order.setFullName(fullName);
		order.setAddress(address);
		order.setPhone(phone);
		order.setNote(note);
		Pays pay = payService.getPayById(idPay);
		order.setPay(pay);
		order.setUser(account.getUser());
		orderService.save(order);
		
//		account.getUser().getListOther().add(order);
		
		Cart newCart = new Cart();
		
		newCart.setUser(account.getUser());
		
		newCart =cartService.save(newCart);
//		
//		account.getUser().getListCart().add(newCart);
//		
//		userService.update(account.getUser());
		

	
		List<CardDetail> listcart = cartDetailsService.getCartDetailsByIdCart(cart.getId());
		
		for (CardDetail cardDetail : listcart) {
			Product product = productService.getProductById(cardDetail.getProduct().getId());
			
			int quantity = product.getNumber() - cardDetail.getQuantity();
			
			product.setNumber(quantity);
			
			productService.updateProduct(product);
		}
		
		return mav;
	}

}
