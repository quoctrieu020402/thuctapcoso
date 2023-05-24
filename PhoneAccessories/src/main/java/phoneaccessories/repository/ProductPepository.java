package phoneaccessories.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import phoneaccessories.entity.Category;
import phoneaccessories.entity.Product;

public interface ProductPepository extends JpaRepository<Product, String> {

	List<Product> findByCategory(Category category);

	List<Product> findByNameContaining(String keyword);
}

