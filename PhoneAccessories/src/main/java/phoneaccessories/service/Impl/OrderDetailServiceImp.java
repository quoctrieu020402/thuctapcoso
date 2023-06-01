package phoneaccessories.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phoneaccessories.entity.CardDetail;
import phoneaccessories.repository.OrderDetailRepository;
import phoneaccessories.service.OrderDetailService;
@Service
public class OrderDetailServiceImp implements OrderDetailService{
	
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Override
	public List<CardDetail> findAllByCardId(String idc) {
		return orderDetailRepository.findAllById_Cart(idc);
	}

}
