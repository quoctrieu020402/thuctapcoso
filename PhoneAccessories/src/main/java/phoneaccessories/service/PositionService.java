package phoneaccessories.service;

import phoneaccessories.entity.Position;

public interface PositionService {
	Position findOneByName(String name);
	
	void save(Position position);
}
