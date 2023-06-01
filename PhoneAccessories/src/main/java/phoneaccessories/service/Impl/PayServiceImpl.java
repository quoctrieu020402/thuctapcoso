package phoneaccessories.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phoneaccessories.entity.Pays;
import phoneaccessories.repository.PayReponsitory;
import phoneaccessories.service.PayService;

@Service
public class PayServiceImpl implements PayService{
	
	@Autowired
	private PayReponsitory payReponsitory;
	
	@Override
	public Pays getPayById(int id) {
		
		return  payReponsitory.findOne(id);
	}

}
