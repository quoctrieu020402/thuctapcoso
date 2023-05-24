package phoneaccessories.service;

import java.util.List;

import phoneaccessories.entity.Product;

public interface ProductService {
	void save(Product product);
	Product update(Product product,String id);
	List<Product> getListProduct();
	Product getProductById(String id);
	void updateProduct(Product product);
	List<Product> getRelatedProducts(Product product);
	List<Product> searchByName(String keyword);

}
