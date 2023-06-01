package phoneaccessories.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import phoneaccessories.entity.Account;
import phoneaccessories.entity.Position;
import phoneaccessories.repository.AccountRepository;
import phoneaccessories.repository.PossitionReponsitory;
import phoneaccessories.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private AccountRepository accountRpst;
	
	@Autowired
	private PossitionReponsitory reponsitory;
	
	@Override
	public Account findByUsername(String username) {
		
		return accountRpst.findByUsername(username);
	}

	@Override
	public void save(Account account) {
		
		account.setStatus(true);
		
		account.setPasword(bCryptPasswordEncoder.encode(account.getPasword()));
		
		Position position = reponsitory.findOne("user");
		
		if(position == null) {
			position = new Position();
			position.setId("user");
			position.setName("USER");
			reponsitory.save(position);
			
		}
		
		
		
		
		account.setPosition(position);
		
		accountRpst.save(account);
		
		
	}

	@Override
	public void delete(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> gellListUnameAccount() {
		return accountRpst.findUsernames();
	}

	@Override
	public Account getAccountById(String username) {
		
		return accountRpst.findOne(username);
	}
	
}
