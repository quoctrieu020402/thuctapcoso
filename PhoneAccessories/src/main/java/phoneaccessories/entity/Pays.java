package phoneaccessories.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="HINHTHUCTHANHTOAN")
public class Pays {
	@Id
	@Column(name ="MATHANHTOAN")
	private int id;
	
	@Column(name = "KIEUTHANHTOAN", length = 100)
	private String typePay;
	
	@OneToOne(mappedBy = "pay", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Order order;
	
	public Pays() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypePay() {
		return typePay;
	}

	public void setTypePay(String typePay) {
		this.typePay = typePay;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	
}
