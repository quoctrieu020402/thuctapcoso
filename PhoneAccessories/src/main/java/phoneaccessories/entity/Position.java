package phoneaccessories.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="CHUCVU")
public class Position {
	@Id
	@Column(name = "MACHUCVU",length = 10)
	private String id;
	
	@Column(name = "TENCHUCVU",length = 50)
	private String name;
	
	@OneToMany (mappedBy = "position")
	private List<Account> listAccount;
	
	public Position() {
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

	public List<Account> getListAccount() {
		return listAccount;
	}

	public void setListAccount(List<Account> listAccount) {
		this.listAccount = listAccount;
	}
	
	
}
