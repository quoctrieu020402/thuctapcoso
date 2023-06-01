package phoneaccessories.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import phoneaccessories.entity.Account;
import phoneaccessories.entity.Staffs;

public interface StaffRepository extends JpaRepository<Staffs, String> {
	Staffs findOneByAccount(Account account);
	List<Staffs> findAllByAccountStatus(boolean status);
	
	
}
