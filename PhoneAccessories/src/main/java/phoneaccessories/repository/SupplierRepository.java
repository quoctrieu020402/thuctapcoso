package phoneaccessories.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import phoneaccessories.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, String> {
	List<Supplier> findByStatus(boolean b);
	Supplier findById(String id);
}
