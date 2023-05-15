package phoneaccessories.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import phoneaccessories.entity.Product;

public interface ProductPepository extends JpaRepository<Product, String> {

}
