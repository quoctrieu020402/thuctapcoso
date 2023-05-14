package phoneaccessories.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import phoneaccessories.entity.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, String>{

}
