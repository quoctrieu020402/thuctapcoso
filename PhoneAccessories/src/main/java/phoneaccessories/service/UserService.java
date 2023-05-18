package phoneaccessories.service;

import phoneaccessories.entity.Account;
import phoneaccessories.entity.User;

public interface UserService {
	
	void save(Account account);
	
	void update(User user);
	
	
}
