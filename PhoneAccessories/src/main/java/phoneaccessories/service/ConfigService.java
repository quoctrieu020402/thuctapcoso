package phoneaccessories.service;

import phoneaccessories.entity.Config;

public interface ConfigService {
	Config findOneByListProduct_Id(String id);
	void save(Config config);
}
