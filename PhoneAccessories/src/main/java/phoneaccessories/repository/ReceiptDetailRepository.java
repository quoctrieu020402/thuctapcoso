package phoneaccessories.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import phoneaccessories.entity.ReceiptDetail;
import phoneaccessories.entity.ReceiptDetailPk;

public interface ReceiptDetailRepository extends JpaRepository<ReceiptDetail, ReceiptDetailPk> {
	List<ReceiptDetail> findAllById_Receipt(String idr);
	void deleteById_Receipt(String idr);
}
