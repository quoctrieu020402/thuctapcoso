package phoneaccessories.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "HOADON")
public class Bill {

	@Id
	@Column(name = "SOHD")
	private String soHD;

	@OneToOne
	@JoinColumn(name="MAPD")
	private Order order;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name = "NGAYIN")
	private Date ngayIn;

	public String getSoHD() {
		return soHD;
	}

	public void setSoHD(String soHD) {
		this.soHD = soHD;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Date getNgayIn() {
		return ngayIn;
	}

	public void setNgayIn(Date ngayIn) {
		this.ngayIn = ngayIn;
	}

	

}
