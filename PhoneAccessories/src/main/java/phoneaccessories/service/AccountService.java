package phoneaccessories.service;

import java.util.List;

import phoneaccessories.entity.Account;

public interface AccountService {
	public Account findByUsername(String username);
	
	public void save(Account account);
	
	public void delete(Account account); 
	
	public List<String> gellListUnameAccount();

	public Account getAccountById(String username);
	

}
