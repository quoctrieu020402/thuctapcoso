package phoneaccessories.service;

import java.util.List;

import phoneaccessories.entity.ReceiptDetail;

public interface ReceiptDetailService {
	List<ReceiptDetail> findAllById_Receipt(String idr);
}
