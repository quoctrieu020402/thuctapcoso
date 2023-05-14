package phoneaccessories.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "NHACUNGCAP")
public class Supplier {
	@Id
	@Column(name = "MANHACUNGCAP" ,length = 10)
	private String id;
	
	@Column(name = "TENNHACUNGCAP" ,length = 50)
	private String name;
	
	@Column(name = "SDT" ,length = 11)
	private String sdt;
	
	@Column(name = "DIACHI" ,length = 100)
	private String address;
	
	@Column(name = "TRANGTHAI" ,length = 50)
	private boolean status;
	
	@OneToMany(mappedBy = "supplier",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Receipt> receipt;
	
	public Supplier() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Receipt> getReceipt() {
		return receipt;
	}

	public void setReceipt(List<Receipt> receipt) {
		this.receipt = receipt;
	}
	
	
}
