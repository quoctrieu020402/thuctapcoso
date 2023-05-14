package phoneaccessories.service;

import java.util.List;

import phoneaccessories.entity.Category;

public interface CategoryService {
	void addCategory(Category category);
	List<Category> getListCategory();
	List<Category> getListCategoryByStatus(boolean b);
	Category findOneById (String id);
	
	Category update (Category category,String id);
	
	void deleteCategoty(String id);
}
