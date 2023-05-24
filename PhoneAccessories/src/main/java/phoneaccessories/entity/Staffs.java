package phoneaccessories.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "NHANVIEN")
public class Staffs {
	@Id
	@Column(name = "MANV", length = 10)
	private String id;

	@Column(name = "HO", length = 30)
	private String surname;

	@Column(name = "TEN", length = 30)
	private String name;

	@Column(name = "CMND", length = 12)
	private String cmnd;

	@Column(name = "DIACHI", length = 30)
	private String address;

	@Column(name = "GIOITINH", length = 10)
	private String gender;

	@Column(name = "SDT", length = 11)
	private String sdt;

	@Column(name = "ANH", length = 50)
	private String image;

	@Column(name = "NGAYSINH", length = 30)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dateOfBirth;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TENTAIKHOANG")
	private Account account;

	@OneToMany(mappedBy = "staff")
	private List<Receipt> listReceipt;

	@OneToMany(mappedBy = "staff")
	private List<Order> listOrder;

	@OneToMany(mappedBy = "nvTra")
	private List<Warranty> listNVTra;

	@OneToMany(mappedBy = "nvNhan")
	private List<Warranty> listNVNhan;
	
	@OneToMany(mappedBy = "staff")
	private List<paySlip> listPaySlip;

	public Staffs() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Receipt> getListReceipt() {
		return listReceipt;
	}

	public void setListReceipt(List<Receipt> listReceipt) {
		this.listReceipt = listReceipt;
	}

	public List<Order> getListOrder() {
		return listOrder;
	}

	public void setListOrder(List<Order> listOrder) {
		this.listOrder = listOrder;
	}

}
