package phoneaccessories.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import phoneaccessories.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
	@Query("SELECT t.username FROM Account t")
	List<String> findUsernames();
	
	Account findByUsername (String username);
}
