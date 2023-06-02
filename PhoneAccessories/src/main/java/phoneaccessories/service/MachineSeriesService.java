package phoneaccessories.service;

import java.util.List;

import phoneaccessories.entity.MachineSeries;

public interface MachineSeriesService {
	List<MachineSeries> findAllByStatus(boolean b);
	void save(MachineSeries machineSeries);
	MachineSeries findOneById(String id);
}
