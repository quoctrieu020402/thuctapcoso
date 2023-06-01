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

import phoneaccessories.Utils.SecurityUtils;
import phoneaccessories.entity.Account;
import phoneaccessories.entity.Category;
import phoneaccessories.entity.Product;
import phoneaccessories.entity.Staffs;
import phoneaccessories.service.AccountService;
import phoneaccessories.service.ProductService;
import phoneaccessories.service.StaffService;
import phoneaccessories.service.Impl.CategoryServiceImpl;

@Controller
@RequestMapping("/admin/")
public class AdminCategoryController {
	
	@Autowired
	private ProductService productService;
	
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
		if (category.getId().isEmpty()) {
			mav.addObject("idnull", "Id thư mục trống");
			return mav;
		}
		
		if (category.getName().isEmpty()) {
			mav.addObject("namenull", "Tên thư mục trống");
			return mav;
		}
		mav.addObject("success", "Thêm thư mục thành công");
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
		
		List<Product> productds = productService.findAllByCategory_Id(idcategory);
		
		if (productds.isEmpty()) {
			
			categoryImpl.deleteCategoty(idcategory);
		}
		else {
			mav.addObject("idc", idcategory);
			mav.addObject("message", "Sản phẩm tồn tại không thể xóa");
		}
		
		
		List<Category> listCategory = new ArrayList<>();
		
		listCategory = categoryImpl.getListCategoryByStatus(true);
		
		mav.addObject("listCategory", listCategory);

		return mav;
	}
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private AccountService accountService;
	
	@ModelAttribute("staff")
	public Staffs getStaff() {
		Account account = accountService.findByUsername(SecurityUtils.getPrincipal().getUsername());
		Staffs staff = staffService.findOneByAccount(account);
		return staff;
	}
}
