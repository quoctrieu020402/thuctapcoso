package phoneaccessories.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="TRANGTHAIPHIEUTDAT")
public class StatusOrder {
	@Id
	@Column(name = "MATRANGTHAI")
	private int id;
	
	@Column(name = "TENTRANGTHAI")
	private int NAME;
	
	@ManyToOne
	@JoinColumn(name = "MAPHIEUDAT")
	private Order order;
	
	public StatusOrder() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNAME() {
		return NAME;
	}

	public void setNAME(int nAME) {
		NAME = nAME;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
