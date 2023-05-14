package phoneaccessories.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="GIOHANG")
public class Cart {
	@Id
	@Column(name ="MAGIOHANG",length = 10)
	private String id;
	
	@ManyToOne
	@JoinColumn(name ="MAKHACHHANG")
	private User user;
	
	@OneToOne(mappedBy = "cart",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Order oder;
	
	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<CardDetail> listCardDetail;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Order getOder() {
		return oder;
	}

	public void setOder(Order oder) {
		this.oder = oder;
	}
	
	
}
