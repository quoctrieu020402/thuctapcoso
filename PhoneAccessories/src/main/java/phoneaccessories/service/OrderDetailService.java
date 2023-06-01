package phoneaccessories.service;

import java.util.List;

import phoneaccessories.entity.CardDetail;

public interface OrderDetailService {
	List<CardDetail> findAllByCardId(String idc);
}
