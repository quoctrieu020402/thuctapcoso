package phoneaccessories.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phoneaccessories.entity.Supplier;
import phoneaccessories.repository.SupplierRepository;
import phoneaccessories.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	@Override
	public void save(Supplier supplier) {
		supplier.setStatus(true);
		supplierRepository.save(supplier);
	}
	
	@Override
	public void update(Supplier suppliernew, String id) {
		Supplier supplierold = supplierRepository.findById(id);
		supplierold = suppliernew;
		supplierold.setId(id);
		supplierold.setStatus(true);
		supplierRepository.save(supplierold);
		
	}
	
	@Override
	public List<Supplier> getListSupplier() {
		return supplierRepository.findAll();
	}

	@Override
	public List<Supplier> getListSupplierByStatus(boolean b) {
		
		return supplierRepository.findByStatus(b);
	}

	@Override
	public Supplier findById(String id) {
		return supplierRepository.findById(id);
	}

	

}
