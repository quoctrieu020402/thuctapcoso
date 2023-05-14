package phoneaccessories.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phoneaccessories.entity.Category;
import phoneaccessories.repository.CategoryRepository;
import phoneaccessories.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryrepository;

	@Override
	public void addCategory(Category category) {
		category.setStatus(true);
		categoryrepository.save(category);
	}
	
	@Override
	public List<Category> getListCategoryByStatus(boolean b) {
		
		return categoryrepository.findByStatus(b);
	}

	@Override
	public List<Category> getListCategory() {
		
		return categoryrepository.findAll();
	}

	@Override
	public Category findOneById(String id) {
		return categoryrepository.findOne(id);
	}

	@Override
	public Category update(Category categorynew,String id) {
		Category categoryold = categoryrepository.findOne(id);
		
		categoryold.setId(categorynew.getId());
		categoryold.setName(categorynew.getName());
		
		
		return categoryrepository.save(categoryold);
	}

	@Override
	public void deleteCategoty(String id) {
		Category category = categoryrepository.findOne(id);
		category.setStatus(false);
		categoryrepository.save(category);
	}

	

}
