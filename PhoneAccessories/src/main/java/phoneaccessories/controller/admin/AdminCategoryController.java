package phoneaccessories.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import phoneaccessories.entity.Category;
import phoneaccessories.service.Impl.CategoryServiceImpl;

@Controller
@RequestMapping("/admin/")
public class AdminCategoryController {

	@Autowired
	private CategoryServiceImpl categoryImpl;

	@RequestMapping("category/list")
	public ModelAndView listCategory() {
		ModelAndView mav = new ModelAndView("admin/category/list-category");

		List<Category> listCategory = new ArrayList<>();

		listCategory = categoryImpl.getListCategoryByStatus(true);

		mav.addObject("listCategory", listCategory);

		return mav;
	}

	@GetMapping("category/add")
	public ModelAndView viewAddCategory() {
		ModelAndView mav = new ModelAndView("admin/category/add");
		Category categoty = new Category();
		mav.addObject("addcategory", categoty);
		return mav;
	}

	@PostMapping("category/add")
	public ModelAndView addCategory(@ModelAttribute("addcategory") Category category) {
		ModelAndView mav = new ModelAndView("admin/category/add");
		categoryImpl.addCategory(category);
		return mav;
	}

	@GetMapping("category/edit")
	public ModelAndView viewEditCategory(@RequestParam("idc") String idcategory) {
		ModelAndView mav = new ModelAndView("admin/category/edit");
		Category categoty = categoryImpl.findOneById(idcategory);
		mav.addObject("editcategory", categoty);
		return mav;
	}

	@PostMapping("category/edit")
	public ModelAndView editCategory(@ModelAttribute("editcategory") Category category,
			@RequestParam("idc") String idcategory) {
		ModelAndView mav = new ModelAndView("admin/category/edit");

		categoryImpl.update(category, idcategory);

		Category categotyold = categoryImpl.findOneById(idcategory);

		if (categotyold.getId().equals(category.getId())) {

		} else {
			categoryImpl.deleteCategoty(categotyold.getId());
		}

		return mav;
	}

	@GetMapping("category/delete")
	public ModelAndView removeCategory(@RequestParam("idc") String idcategory) {
		ModelAndView mav = new ModelAndView("admin/category/list-category");
		categoryImpl.deleteCategoty(idcategory);
		List<Category> listCategory = new ArrayList<>();

		listCategory = categoryImpl.getListCategoryByStatus(true);

		mav.addObject("listCategory", listCategory);

		return mav;
	}
}
