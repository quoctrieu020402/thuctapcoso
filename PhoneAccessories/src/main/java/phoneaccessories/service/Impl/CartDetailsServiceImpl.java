package phoneaccessories.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phoneaccessories.entity.CardDetail;
import phoneaccessories.entity.CardDetailPk;
import phoneaccessories.entity.Cart;
import phoneaccessories.entity.Product;
import phoneaccessories.repository.CartDetailsRepository;
import phoneaccessories.repository.CartReponsitory;
import phoneaccessories.repository.ProductPepository;
import phoneaccessories.service.CartDetailsService;

@Service
public class CartDetailsServiceImpl implements CartDetailsService{

	@Autowired
	private CartDetailsRepository cartDetailsRepository;
	
	@Autowired
	private CartReponsitory cartReponsitory;
	
	@Autowired
	private ProductPepository productPepository;
	
	@Override
	public List<CardDetail> getCartDetailsByIdCart(String id) {
		
		return cartDetailsRepository.findByCartId(id);
	}

	@Override
	public void removeAll(List<CardDetail> list) {
		for (CardDetail cardDetail : list) {
			cartDetailsRepository.delete(cardDetail.getId());
		}
	}

	@Override
	public void removeDetailsCart(String idCart, String idProduct) {
	
		CardDetailPk pk = new CardDetailPk(idProduct, idCart);
			
		cartDetailsRepository.delete(pk);
	}

	@Override
	public CardDetail getCartDetailsById(String idCart, String idProduct) {
		CardDetailPk pk = new CardDetailPk(idProduct, idCart);
		
		return cartDetailsRepository.findOne(pk);
	}

	@Override
	public void updateCartDetails(CardDetail cardDetail) {
		
		cartDetailsRepository.save(cardDetail);
	}

}
