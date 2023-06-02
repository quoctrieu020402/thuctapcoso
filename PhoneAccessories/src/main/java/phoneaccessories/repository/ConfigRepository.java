package phoneaccessories.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import phoneaccessories.entity.Config;

public interface ConfigRepository extends JpaRepository<Config, String>{
	Config findOneByListProduct_Id(String id);
}
