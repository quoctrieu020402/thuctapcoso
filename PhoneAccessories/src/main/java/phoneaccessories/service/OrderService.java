package phoneaccessories.service;

import java.util.List;

import phoneaccessories.entity.Order;

public interface OrderService {
	Order save(Order order);
	List<Order> getListOrder();
	Order findOneByCart_Id(String idc);
	Order findOneById(Long ido);
}
