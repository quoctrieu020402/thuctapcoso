package phoneaccessories.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phoneaccessories.entity.Account;
import phoneaccessories.entity.Cart;
import phoneaccessories.entity.User;
import phoneaccessories.repository.AccountRepository;
import phoneaccessories.repository.CartReponsitory;
import phoneaccessories.repository.UserRepository;
import phoneaccessories.service.UserService;

@Service
public class UserSeviceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CartReponsitory cartReponsitory;
	
	@Override
	public void save(Account account) {
		
		long count = userRepository.count() + 1;
		
		long countCart = cartReponsitory.count() + 1;
		
		String idUser = "MKH" + count;
		
		String idCart = "MGH" + countCart;
		
		User user = new User();
		
		Cart cart = new  Cart();
		
		cart.setId(idCart);
		
		user.setId(idUser);
		
		account.setUser(user);
		
		account.getUser().setAccount(account);
		
		accountRepository.save(account);
		
		cart.setUser(user);
		
		List<Cart> carts = new ArrayList<Cart>();
		
		carts.add(cart);
		
		user.setListCart(carts);
		
		cartReponsitory.save(cart);

	}

}
