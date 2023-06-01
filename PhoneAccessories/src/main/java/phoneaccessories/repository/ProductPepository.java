package phoneaccessories.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import phoneaccessories.entity.Category;
import phoneaccessories.entity.Product;

public interface ProductPepository extends JpaRepository<Product, String> {
	
	//THÊM
	List<Product> findByNameContaining(String name);
	List<Product> findByPriceLessThan(double price);
	 
    List<Product> findByPriceBetween(double price1, double price2);
 
    List<Product> findByPriceGreaterThan(double price);
 
    List<Product> findAllByOrderByNameAsc();
    
    List<Product> findAllByOrderByNameDesc();
    
    List<Product> findAllByOrderByPriceAsc();
    
    List<Product> findAllByOrderByPriceDesc();
    
    Page<Product> findAll(Pageable pageable);
	List<Product> findByCategory(Category category);
	List<Product> findAllByCategory_Id(String idc);
	List<Product> findAllByStatus(boolean b);

}
