package phoneaccessories.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phoneaccessories.entity.Cart;
import phoneaccessories.repository.CartReponsitory;
import phoneaccessories.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartReponsitory cartReponsitory;
	
	@Override
	public Cart getCartById(String idCart) {
		
		return cartReponsitory.findOne(idCart);
	}

}
