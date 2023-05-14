package phoneaccessories.service;

import java.util.List;

import phoneaccessories.entity.Supplier;

public interface SupplierService {
	void save(Supplier supplier);
	List<Supplier> getListSupplier();
	List<Supplier> getListSupplierByStatus(boolean b);
}
