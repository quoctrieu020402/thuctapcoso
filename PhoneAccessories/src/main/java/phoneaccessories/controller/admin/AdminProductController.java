package phoneaccessories.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import phoneaccessories.Utils.SecurityUtils;
import phoneaccessories.entity.Account;
import phoneaccessories.entity.Category;
import phoneaccessories.entity.MachineSeries;
import phoneaccessories.entity.Product;
import phoneaccessories.entity.Staffs;
import phoneaccessories.repository.AccountRepository;
import phoneaccessories.repository.ProductPepository;
import phoneaccessories.service.AccountService;
import phoneaccessories.service.CategoryService;
import phoneaccessories.service.MachineSeriesService;
import phoneaccessories.service.ProductService;
import phoneaccessories.service.StaffService;
import phoneaccessories.service.Impl.ProductServiceImpt;

@Controller
@RequestMapping("/admin/")
public class AdminProductController {
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductPepository pepository;
	
	@Autowired
	private MachineSeriesService machineSeriesService;
	@RequestMapping("product/list")
	public ModelAndView listProduct() {
		ModelAndView mav = new ModelAndView("admin/product/listproduct");
		List<Product> listProduct = pepository.findAllByStatus(true);
		mav.addObject("listProduct", listProduct);
		return mav;
	}
	
	
	
	@GetMapping("product/add")
	public ModelAndView showPageAddProdcut() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/product/add-product");
		Product product = new Product();
		mav.addObject("addProdcut", product);
		return mav;
	}
	@PostMapping("product/add")
	public ModelAndView addProdcut(@ModelAttribute("addProdcut") Product product,
			@RequestParam("avatar") MultipartFile avatar) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/product/add-product");
		String message = "";
		
		if (avatar.isEmpty()) {
			mav.addObject("imgnull", "Hình ảnh trống");
			return mav;
		}
		
		if (product.getId().isEmpty()) {
			mav.addObject("idnull", "Mã sản phẩm trống");
			return mav;
		}
		
		if (product.getName().isEmpty()) {
			mav.addObject("namenull", "Tên sản phẩm trống");
			return mav;
		}
		
		product.setImage(avatar.getOriginalFilename());
		mav.addObject("success", "Thêm sản phẩm thành công");
		productService.save(product);

		try {
			MultipartFile multipartFile = avatar;
			String fileName = multipartFile.getOriginalFilename();
			File file = new File("D:\\ProjectLTweb\\PhoneAccessories\\src\\main\\webapp\\templates\\images\\",
					fileName);
			multipartFile.transferTo(file);
			message = "Thêm sản phẩm thành công";
			mav.addObject("message", message);
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("message", "Lưu file ảnh thất bại");
		}
		return mav;
		
		
	}
	
	@GetMapping("product/edit")
	public ModelAndView viewEdit (@RequestParam("idp") String idProduct) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/product/edit-product");
		Product product = productService.getProductById(idProduct);
		mav.addObject("product", product);
		return mav;
	}
	
	@PostMapping("product/edit")
	public ModelAndView editProduct(@ModelAttribute("product") Product product
			,@RequestParam("avatar") MultipartFile avatar,@RequestParam("idp") String idp) {
		ModelAndView mav = new ModelAndView();
		String message ="";
		mav.setViewName("admin/product/edit-product");
		
		product.setImage(avatar.getOriginalFilename());
		productService.update(product,idp);
		
		try {
			String filename = avatar.getOriginalFilename();
			File file = new File("D:\\ProjectLTweb\\PhoneAccessories\\src\\main\\webapp\\templates\\images\\"+filename);
			avatar.transferTo(file);
			message ="Cập Nhật sản phẩm thành công";
			mav.addObject("message", message);
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("message", "Lưu file ảnh thất bại");
		}
		
		return mav;
	}
	
	@GetMapping("product/delete")
	public ModelAndView deteleProduct(@RequestParam("idp") String idProduct) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/admin/product/list");
		
		Product product = productService.getProductById(idProduct);
		product.setStatus(false);
		pepository.save(product);
		return mav;
	}
	@ModelAttribute("categorys")
	public List<Category> getCategories() {
		List<Category> list = new ArrayList<Category>();
		list.addAll(categoryService.getListCategory());
		return list;
	}
	
	@ModelAttribute("machineseries")
	public List<MachineSeries> getMachineseries() {
		List<MachineSeries> list = new ArrayList<MachineSeries>();
		list.addAll(machineSeriesService.findAllByStatus(true));
		return list;
	}
	
	@ModelAttribute("staff")
	public Staffs getStaff() {
		Account account = accountService.findByUsername(SecurityUtils.getPrincipal().getUsername());
		Staffs staff = staffService.findOneByAccount(account);
		return staff;
	}
//	public ModelAndView addProduct(@ModelAttribute("AddProduct") Product product,
//			@RequestParam("avata") MultipartFile avatar )  {
//		ModelAndView mav = new ModelAndView("admin/product/add-product");
//		product.setImage(avatar.getOriginalFilename());
//		
//		productImpl.save(product);
//		
//		try {
//			MultipartFile multipartFile = avatar;
//			String fileName = multipartFile.getOriginalFilename();
//			File file = new File("D:\\ProjectLTweb\\PhoneAccessories\\src\\main\\webapp\\templates\\images\\",
//					fileName);
//			multipartFile.transferTo(file);
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//			mav.addObject("message", "Lưu file ảnh thất bại");
//		}
//		return mav;
//	}
	
	
}
