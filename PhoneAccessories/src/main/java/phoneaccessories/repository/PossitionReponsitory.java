package phoneaccessories.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import phoneaccessories.entity.Position;

public interface PossitionReponsitory extends JpaRepository<Position, String>{
	Position findOneByName(String name);
}
