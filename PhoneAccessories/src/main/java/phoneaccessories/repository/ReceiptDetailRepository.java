package phoneaccessories.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import phoneaccessories.entity.ReceiptDetail;
import phoneaccessories.entity.ReceiptDetailPk;

public interface ReceiptDetailRepository extends JpaRepository<ReceiptDetail, ReceiptDetailPk> {

}
