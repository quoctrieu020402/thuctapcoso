package phoneaccessories.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name ="PHIEUNHAP")
public class Receipt {
	@Id
	@Column(name = "MAPHIEUNHAP",length = 10)
	private String id;
	
	@Column(name = "NGAYLAP")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "MANV")
	private Staffs staff;
	
	@ManyToOne
	@JoinColumn(name ="MANHACUNGCAP")
	private Supplier supplier;
	
	@Column(name = "TRANGTHAI")
	private int status;
	
	@OneToMany(mappedBy = "receipt",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<ReceiptDetail> listReceiptDetail;
	
	public List<ReceiptDetail> getListReceiptDetail() {
		return listReceiptDetail;
	}

	public void setListReceiptDetail(List<ReceiptDetail> listReceiptDetail) {
		this.listReceiptDetail = listReceiptDetail;
	}

	public Receipt() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Staffs getStaff() {
		return staff;
	}

	public void setStaff(Staffs staff) {
		this.staff = staff;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	
	
}
