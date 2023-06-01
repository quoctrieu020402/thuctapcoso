package phoneaccessories.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name ="PHIEUDAT")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="MAPHIEUDAT")
	private Long id;
	
	@Column(name ="NGAYLAP")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date date;
	
	@Column(name = "HOVATEN", length = 200)
	private String fullName;
	
	@Column(name = "SODIENTHOAIKHACHHANG", length = 11)
	private String phone;
	
	@Column(name = "GHICHU", length = 5000)
	private String note;
	
	@Column(name = "DIACHI", length = 500)
	private String address;
	

	@Column(name = "TRANGTHAI", length = 500)
	private String status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MANV")
	private Staffs staff;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="MAKHACHHANG")
	private User user;
	
	
	@OneToOne
	@JoinColumn(name = "MATHANHTOAN")
	private Pays pay;
	
	@OneToOne
	@JoinColumn(name = "MAGIOHANG")
	private Cart cart;
	
	public Order() {
		super();
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Staffs getStaff() {
		return staff;
	}

	public void setStaff(Staffs staff) {
		this.staff = staff;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Pays getPay() {
		return pay;
	}

	public void setPay(Pays pay) {
		this.pay = pay;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
