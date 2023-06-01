package phoneaccessories.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "COMPANY")
public class Company {
@Id
@Column(name = "MACONGTY")
private String id;

@Column(name ="TENCONGTY")
private String name;

@Column(name ="TRANGTHAI")
private boolean status;

@Column(name = "LOGO")
private String logo;
}

@OneToMany(mappedBy = "company")
private List<Product> listProduct;

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
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}
public String getLogo() {
	return logo;
}
public void setLogo(String logo) {
	this.logo = logo;
}
public List<Product> getListProduct() {
	return listProduct;
}
public void setListProduct(List<Product> listProduct) {
	this.listProduct = listProduct;
}

}

