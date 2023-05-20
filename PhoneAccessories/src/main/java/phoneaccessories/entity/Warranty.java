package phoneaccessories.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PHIEUBAOHANH")
public class Warranty {

	@Id
	@Column(name = "SOPHIEUBH")
	private String soPhieuBH;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name = "NGAYBH")
	private Date ngayBH;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name = "NGAYKT")
	private Date ngayKT;
	
	@OneToOne
	@JoinColumn(name="MASP")
	private Product product;

	@ManyToOne
	@JoinColumn(name="MANVTRA")
	private Staffs nvTra;

	@ManyToOne
	@JoinColumn(name="MANVNHAN")
	private Staffs nvNhan;

	public String getSoPhieuBH() {
		return soPhieuBH;
	}

	public void setSoPhieuBH(String soPhieuBH) {
		this.soPhieuBH = soPhieuBH;
	}

	public Date getNgayBH() {
		return ngayBH;
	}

	public void setNgayBH(Date ngayBH) {
		this.ngayBH = ngayBH;
	}

	public Date getNgayKT() {
		return ngayKT;
	}

	public void setNgayKT(Date ngayKT) {
		this.ngayKT = ngayKT;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Staffs getNvTra() {
		return nvTra;
	}

	public void setNvTra(Staffs nvTra) {
		this.nvTra = nvTra;
	}

	public Staffs getNvNhan() {
		return nvNhan;
	}

	public void setNvNhan(Staffs nvNhan) {
		this.nvNhan = nvNhan;
	}
	
	
}
