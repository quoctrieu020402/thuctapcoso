package phoneaccessories.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import phoneaccessories.entity.Account;
import phoneaccessories.entity.Staffs;


public interface StaffService {
	
	Staffs findOneByAccount(Account account);
	
	void save(Staffs staffs);
	
	void delete(String  idStaffs);
	List<Staffs> findAll();
	List<Staffs> findAllByStatus(boolean status);
}
