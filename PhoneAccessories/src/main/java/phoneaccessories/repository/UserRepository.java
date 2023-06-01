package phoneaccessories.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import phoneaccessories.entity.Account;
import phoneaccessories.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

	User findByAccount(String account);
	
}
