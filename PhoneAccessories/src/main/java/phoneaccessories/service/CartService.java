package phoneaccessories.service;

import phoneaccessories.entity.Cart;

public interface CartService {
	Cart getCartById(String idCart);
	Cart save(Cart cart);
}
