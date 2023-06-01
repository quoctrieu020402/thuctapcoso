package phoneaccessories.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "KHACHHANG")
public class User {
	@Id
	@Column(name = "MAKHACHHANG", length = 10)
	private String id;
	@Column(name = "HO", length = 20)
	private String surname;
	@Column(name = "TEN", length = 20)
	private String name;
	@Column(name = "NGAYSINH", length = 20)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dayOfBirth;
	@Column(name = "DIACHI", length = 20)
	private String address;
	@Column(name = "SDT", length = 20)
	private String sdt;
	@Column(name = "ANHDAIDIEN", length = 20)
	private String image;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TENTAIKHOANG")
	private Account account;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Order> listOther = new ArrayList<Order>();
	
	@OneToMany(mappedBy = "user")
	private List<Cart> listCart;
	
	public User() {
		
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

	public Date getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(Date dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Order> getListOther() {
		return listOther;
	}

	public void setListOther(List<Order> listOther) {
		this.listOther = listOther;
	}

	public List<Cart> getListCart() {
		return listCart;
	}

	public void setListCart(List<Cart> listCart) {
		this.listCart = listCart;
	}

	
	
}
