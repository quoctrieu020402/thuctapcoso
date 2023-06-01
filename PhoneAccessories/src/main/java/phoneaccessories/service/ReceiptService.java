package phoneaccessories.service;

import java.util.List;

import phoneaccessories.entity.Receipt;

public interface ReceiptService {
	void save(Receipt receipt);
	List<Receipt> getListReceipt();
	Receipt findById(String id);
	void delete(Receipt receipt);
}
