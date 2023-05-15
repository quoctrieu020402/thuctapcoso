package phoneaccessories.service.Impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phoneaccessories.entity.Product;
import phoneaccessories.entity.Receipt;
import phoneaccessories.entity.ReceiptDetail;
import phoneaccessories.entity.ReceiptDetailPk;
import phoneaccessories.repository.ProductPepository;
import phoneaccessories.repository.ReceiptDetailRepository;
import phoneaccessories.repository.ReceiptRepository;
import phoneaccessories.service.ReceiptService;

@Service
public class ReceiptServiceImpl implements ReceiptService{

	@Autowired
	private ReceiptRepository receiptRepository;
	
	@Autowired
	private ReceiptDetailRepository detailRepository;
	
	@Autowired
	private ProductPepository productPepository;
	
	@Override
	public void save(Receipt receipt) {
		if (receipt.getListReceiptDetail() == null) {
			receiptRepository.save(receipt);
		}
		else {
			Receipt receiptOld = receiptRepository.findOne(receipt.getId());
			for (ReceiptDetail rd : receipt.getListReceiptDetail()) {
				
				Product product = productPepository.findOne(rd.getProduct().getId()) ;
				ReceiptDetailPk receiptDetailPk = new ReceiptDetailPk();
				receiptDetailPk.setProduct(product.getId());
				receiptDetailPk.setReceipt(receipt.getId());
				ReceiptDetail receiptDetail = new ReceiptDetail();
				receiptDetail=rd;
				receiptDetail.setReceipt(receipt);
				receiptDetail.setId(receiptDetailPk);
				detailRepository.save(receiptDetail);
			}
			receiptRepository.save(receiptOld);
		}
		
	}

	@Override
	public List<Receipt> getListReceipt() {
		return receiptRepository.findAll();
	}

	@Override
	public Receipt findById(String id) {
		
		return receiptRepository.findOne(id);
	}

}
