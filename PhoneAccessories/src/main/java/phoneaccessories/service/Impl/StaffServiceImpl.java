package phoneaccessories.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phoneaccessories.entity.Account;
import phoneaccessories.entity.Staffs;
import phoneaccessories.repository.AccountRepository;
import phoneaccessories.repository.StaffRepository;
import phoneaccessories.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService{
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	StaffRepository staffRepository;
	
	@Override
	public Staffs findOneByAccount(Account account) {
		Staffs staffs = staffRepository.findOneByAccount(account);
		return staffs;
	}

	@Override
	public void save(Staffs staffs) {
		staffRepository.save(staffs);
		
	}
	
	@Override
	public List<Staffs> findAll() {
		return staffRepository.findAll();
	}

	@Override
	public List<Staffs> findAllByStatus(boolean status) {
		return staffRepository.findAllByAccountStatus(true);
	}

	@Override
	public void delete(String usernameac) {
		
		Account account = accountRepository.findByUsername(usernameac);
		account.setStatus(false);
		accountRepository.save(account);
	}
	
}
