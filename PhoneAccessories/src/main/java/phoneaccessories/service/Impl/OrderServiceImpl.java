package phoneaccessories.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phoneaccessories.entity.Order;
import phoneaccessories.repository.OrderRepository;
import phoneaccessories.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order save(Order order) {
		
		return orderRepository.save(order);
	}

}
