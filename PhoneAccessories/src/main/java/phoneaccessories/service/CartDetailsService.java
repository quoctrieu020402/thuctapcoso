package phoneaccessories.service;

import java.util.List;

import phoneaccessories.entity.CardDetail;

public interface CartDetailsService {

	List<CardDetail> getCartDetailsByIdCart(String id);
	
	void removeAll(List<CardDetail> list);
	
	void removeDetailsCart(String idCart, String idProduct);
	
	CardDetail getCartDetailsById(String idCart,String idProduct);
	
	void updateCartDetails(CardDetail cardDetail);
}
