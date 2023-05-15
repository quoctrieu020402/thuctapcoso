package phoneaccessories.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import phoneaccessories.dto.MyUser;
import phoneaccessories.entity.Account;
import phoneaccessories.repository.AccountRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private AccountRepository accountRepository; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Account user = accountRepository.findByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("User name not fond");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		authorities.add(new SimpleGrantedAuthority(user.getPosition().getName()));
		
		MyUser myUser = new MyUser(user.getUsername(), user.getPasword(), true, true, true, true, authorities);

		return myUser;
	}
	

}
