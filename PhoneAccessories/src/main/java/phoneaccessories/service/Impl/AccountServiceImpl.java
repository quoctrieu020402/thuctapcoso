package phoneaccessories.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phoneaccessories.entity.Account;
import phoneaccessories.repository.AccountRepository;
import phoneaccessories.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountRpst;
	
	@Override
	public Account findByUsername(String username) {
		
		return accountRpst.findByUsername(username);
	}

	@Override
	public void save(Account account) {
		
		account.setStatus(true);
		
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
	
}
