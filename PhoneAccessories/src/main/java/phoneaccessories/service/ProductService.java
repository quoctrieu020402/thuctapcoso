package phoneaccessories.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import phoneaccessories.entity.Product;

public interface ProductService {
	void save(Product product);
	Product update(Product product,String id);
	List<Product> getListProduct();
	Product getProductById(String id);
	void updateProduct(Product product);
	List<Product> getRelatedProducts(Product product);
	List<Product> searchByName(String keyword);
	List<Product> getProductByCategoryId(String id);
	List<Product> filterByPriceRange(double price1, double price2);
	List<Product> filterByPrice(double price);
	List<Product> getProductsOrderByPriceAsc();
	List<Product> getProductsOrderByPriceDesc();
	List<Product> getProductsOrderByNameAsc();
	List<Product> getProductsOrderByNameDesc();
	Page<Product> findAll(Pageable pageable);
	List<Product> findAllByCategory_Id(String idc);
}
