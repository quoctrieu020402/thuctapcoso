package phoneaccessories.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import phoneaccessories.entity.CardDetail;
import phoneaccessories.entity.CardDetailPk;

public interface OrderDetailRepository extends JpaRepository<CardDetail, CardDetailPk>{
	List<CardDetail> findAllById_Cart(String idc);
}
