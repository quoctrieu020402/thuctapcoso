package phoneaccessories.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="TAIKHOANG")
public class Account {
	@Id
	@Column(name = "TENTAIKHOANG",length= 50)
	private String username;
	
	@Column(name = "MATKHAU",length= 50)
	private String pasword;
	
	@Column(name = "TRANGTHAI")
	private boolean status ;
	
	@Column(name = "EMAIL",length= 50)
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "MACHUCVU")
	private Position position;
	
	@OneToOne(mappedBy = "account",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Staffs staff;
	
	@OneToOne(mappedBy = "account",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private User user;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
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
	
	
}
