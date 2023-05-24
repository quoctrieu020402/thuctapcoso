package phoneaccessories.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phoneaccessories.entity.Category;
import phoneaccessories.entity.Product;
import phoneaccessories.repository.CategoryRepository;
import phoneaccessories.repository.ProductPepository;
import phoneaccessories.service.ProductService;

@Service
public class ProductServiceImpt implements ProductService{
	
	@Autowired
	private ProductPepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void save(Product product) {
		Category category = categoryRepository.findOne(product.getCategory().getId());
		
		product.setCategory(category);
		
		productRepository.save(product);
	}
	
	@Override
	public Product update(Product product,String id) {
		Product productold = productRepository.findOne(id);
		int num = productold.getNumber();
		productold = product;
		productold.setId(id);
		productold.setNumber(num);
		
		System.out.println(productold);
		return productRepository.save(productold);
		
		
		
	}
	@Override
	public List<Product> getListProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(String id) {
		return productRepository.findOne(id);
	}

	@Override
	public void updateProduct(Product product) {
		
		productRepository.save(product);
	}

	@Override
    public List<Product> getRelatedProducts(Product product) {
        // Triển khai logic để lấy danh sách sản phẩm gợi ý
        // Ví dụ: Lấy các sản phẩm có cùng danh mục với sản phẩm hiện tại
        return productRepository.findByCategory(product.getCategory());
    }

	@Override
	public List<Product> searchByName(String keyword) {
	    return productRepository.findByNameContaining(keyword);
	}


	
}
