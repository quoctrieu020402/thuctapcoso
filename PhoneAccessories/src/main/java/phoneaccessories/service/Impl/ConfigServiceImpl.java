package phoneaccessories.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phoneaccessories.entity.Config;
import phoneaccessories.repository.ConfigRepository;
import phoneaccessories.service.ConfigService;

@Service

public class ConfigServiceImpl implements ConfigService {
	
	@Autowired
	private ConfigRepository configRepository;

	@Override
	public Config findOneByListProduct_Id(String id) {
		// TODO Auto-generated method stub
		return configRepository.findOneByListProduct_Id(id);
	}

	@Override
	public void save(Config config) {
		configRepository.save(config);
		
	}

}
