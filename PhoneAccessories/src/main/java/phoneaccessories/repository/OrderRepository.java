package phoneaccessories.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import phoneaccessories.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
