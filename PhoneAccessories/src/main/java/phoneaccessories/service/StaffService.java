package phoneaccessories.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import phoneaccessories.entity.Staffs;


public interface StaffService {
	int getQuantityOfStaff(boolean b);
	
	List<Staffs> getStaffsAccountStatus(boolean b, Pageable pageable);
	
	List<Staffs> getCustomersByAccountStatusAndNameContaining(String id, boolean b, Pageable pageable);
	
	int getQuantityCustomersByAccountStatusAndNameContaining(String id, boolean b);
}
