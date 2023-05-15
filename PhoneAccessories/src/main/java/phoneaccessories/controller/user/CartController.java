package phoneaccessories.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import phoneaccessories.Utils.SecurityUtils;
import phoneaccessories.entity.Account;
import phoneaccessories.entity.CardDetail;
import phoneaccessories.entity.Cart;
import phoneaccessories.repository.AccountRepository;
import phoneaccessories.service.AccountService;
import phoneaccessories.service.CartDetailsService;
import phoneaccessories.service.CartService;
import phoneaccessories.service.UserService;

@Controller
@RequestMapping("/user/")
public class CartController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartDetailsService cartDetailsService;
	
	@Autowired
	private UserService userService;


	@GetMapping("cart")
	public ModelAndView showCart() throws IOException {
		
		ModelAndView mav = new ModelAndView("user/cart");
		
		Account account = null;;
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getName().equals("anonymousUser") ) {
			mav.setViewName("redirect:/login");
			return mav;

		} else {
			account = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		}
		
		if (account.getUser() == null) {
			userService.save(account);
		}

		int possitionCart = account.getUser().getListCart().size() - 1;
		
		String idCart = account.getUser().getListCart().get(possitionCart).getId();
		
		Cart cart = cartService.getCartById(idCart);

		List<CardDetail> listcart = cartDetailsService.getCartDetailsByIdCart(cart.getId());
		
		mav.addObject("ListProduct", listcart);
		
		return mav;
	}
	
	@GetMapping("cart/{idCart}/remove/product/{idProduct}")
	public ModelAndView removeAllInCart(@PathVariable(name = "idCart") String idCart,@PathVariable(name = "idProduct") String idProduct) {
		
		ModelAndView mav = new ModelAndView("user/cart");

		Account account = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());

		int possitionCart = account.getUser().getListCart().size() - 1;
		
		String idCartOfUser = account.getUser().getListCart().get(possitionCart).getId();
		
		Cart cart = cartService.getCartById(idCartOfUser);
		
		cartDetailsService.removeDetailsCart(idCart, idProduct);

		List<CardDetail> listcart = cartDetailsService.getCartDetailsByIdCart(cart.getId());
		
		mav.addObject("ListProduct", listcart);
		
		return mav;
	}
	
	@GetMapping("cart/remove/all")
	public ModelAndView removeAllInCart() {
		
		ModelAndView mav = new ModelAndView("user/cart");

		Account account = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());

		int possitionCart = account.getUser().getListCart().size() - 1;
		
		String idCart = account.getUser().getListCart().get(possitionCart).getId();
		
		Cart cart = cartService.getCartById(idCart);

		List<CardDetail> listcart = cartDetailsService.getCartDetailsByIdCart(cart.getId());
		
		cartDetailsService.removeAll(listcart);
		
		mav.addObject("ListProduct", null);
		
		return mav;
	}
	
	@GetMapping(path = {"/cart/{idCart}/product/{idProduct}/except","/cart/{idCart}/product/{idProduct}/add"})
	public ModelAndView changeQuantityOfProductInDetailsProduct(HttpServletRequest request,@PathVariable(name = "idCart") String idCart,@PathVariable(name = "idProduct") String idProduct) {
		ModelAndView mav = new ModelAndView("user/cart");
		
		String url = request.getRequestURL().toString();
		
		Account account = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		
		int possitionCart = account.getUser().getListCart().size() - 1;
		
		String idCartOfUser = account.getUser().getListCart().get(possitionCart).getId();
		
		Cart cart = cartService.getCartById(idCartOfUser);
		
		CardDetail cardDetail = cartDetailsService.getCartDetailsById(idCart, idProduct);
		
		if (url.contains("add")){
			
			if (cardDetail.getProduct().getNumber() > cardDetail.getQuantity()) {
				
				cardDetail.setQuantity(cardDetail.getQuantity() + 1);
			}
			
		} else {
			
			if (0 < cardDetail.getQuantity()) {
				
				cardDetail.setQuantity(cardDetail.getQuantity() - 1);
				
			}
			
		}
		
		cartDetailsService.updateCartDetails(cardDetail);
		
		List<CardDetail> listcart = cartDetailsService.getCartDetailsByIdCart(cart.getId());
		
		mav.addObject("ListProduct", listcart);
		
		return mav;
	}
	
	@GetMapping("cart/confirm")
	public ModelAndView confirmBuyProducts() {
		
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
		
		mav.addObject("date",java.time.LocalDate.now());
		
		mav.addObject("list", listcart);
		
		mav.addObject("sumMoney", String.format("%.3f", sumMoney));
		
		return mav;
	}
}
