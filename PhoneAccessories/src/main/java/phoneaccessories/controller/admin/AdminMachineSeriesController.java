package phoneaccessories.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import phoneaccessories.entity.MachineSeries;
import phoneaccessories.service.MachineSeriesService;

@Controller

@RequestMapping("/admin")
public class AdminMachineSeriesController {
	
	@Autowired
	private MachineSeriesService machineSeriesService;
	
	@RequestMapping("/machineseries/list")
	public ModelAndView listMachineSeries() {
		ModelAndView mav = new ModelAndView();
		List<MachineSeries> listMachineSeries = machineSeriesService.findAllByStatus(true);
		mav.addObject("listMachineSeries", listMachineSeries);
		mav.setViewName("admin/machineseries/list-machineseries");
		
		
		return mav;
	}
	
	@GetMapping("/machineseries/add")
	public ModelAndView addMachineSeries() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/machineseries/add-machineseries");
		MachineSeries machineSeries = new MachineSeries();
		mav.addObject("machineSeries", machineSeries);
		
		return mav;
	}
	
	@PostMapping("/machineseries/add")
	public ModelAndView postAddMachineSeries(@ModelAttribute("machineSeries") MachineSeries machineSeries) {
		ModelAndView mav = new ModelAndView();
		if (machineSeries.getId().isEmpty()) {
			mav.addObject("idnull", "Id thư mục trống");
			return mav;
		}
		
		if (machineSeries.getName().isEmpty()) {
			mav.addObject("namenull", "Tên thư mục trống");
			return mav;
		}
		mav.addObject("success", "Thêm thư mục thành công");
		machineSeriesService.save(machineSeries);
		mav.setViewName("admin/machineseries/add-machineseries");
		return mav;
	}
	
	@GetMapping("/machineseries/edit")
	public ModelAndView viewEditmachineseries(@RequestParam("idm") String idmachineseries) {
		ModelAndView mav = new ModelAndView("admin/machineseries/edit-machineseries");
		MachineSeries machineSeries = machineSeriesService.findOneById(idmachineseries);
		mav.addObject("editmachineseries", machineSeries);
		return mav;
	}

	@PostMapping("machineseries/edit")
	public ModelAndView editMachineseries(@ModelAttribute("editmachineseries") MachineSeries machineSeries,
			@RequestParam("idm") String idmachineseries) {
		ModelAndView mav = new ModelAndView("admin/machineseries/edit-machineseries");
		machineSeries.setId(idmachineseries);
		machineSeriesService.save(machineSeries);
		
		return mav;
	}
}
