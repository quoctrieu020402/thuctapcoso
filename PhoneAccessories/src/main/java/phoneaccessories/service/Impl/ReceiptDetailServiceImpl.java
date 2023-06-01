package phoneaccessories.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phoneaccessories.entity.ReceiptDetail;
import phoneaccessories.repository.ReceiptDetailRepository;
import phoneaccessories.service.ReceiptDetailService;

@Service
public class ReceiptDetailServiceImpl implements ReceiptDetailService{
	
	@Autowired
	private ReceiptDetailRepository receiptDetailRepository;
	
	@Override
	public List<ReceiptDetail> findAllById_Receipt(String idr) {
		
		return receiptDetailRepository.findAllById_Receipt(idr);
	}

}
