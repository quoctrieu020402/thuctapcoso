package phoneaccessories.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import phoneaccessories.entity.Cart;

public interface CartReponsitory extends JpaRepository<Cart, String>{

}
