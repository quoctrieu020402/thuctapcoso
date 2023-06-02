package phoneaccessories.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phoneaccessories.entity.MachineSeries;
import phoneaccessories.repository.MachineSeriesRepository;
import phoneaccessories.service.MachineSeriesService;
@Service
public class MachineSeriesServiceImpl implements MachineSeriesService {
	
	@Autowired
	private MachineSeriesRepository machineSeriesRepository;
	
	@Override
	public List<MachineSeries> findAllByStatus(boolean b) {
		
		return machineSeriesRepository.findAllByStatus(b);
	}

	@Override
	public void save(MachineSeries machineSeries) {
		machineSeries.setStatus(true);
		machineSeriesRepository.save(machineSeries);
		
	}

	@Override
	public MachineSeries findOneById(String id) {
		return machineSeriesRepository.findOne(id);
	}

}
