package phoneaccessories.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import phoneaccessories.entity.MachineSeries;

public interface MachineSeriesRepository extends JpaRepository<MachineSeries, String>{
	List<MachineSeries> findAllByStatus(boolean b);
}
