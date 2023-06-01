package phoneaccessories.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DANHMUC")
public class Category {
	@Id
	@Column(name ="MADANHMUC" , length = 10)
	private String id;
	
	@Column(name ="TENDANHMUC" , length = 50)
	private String name;
	
	@Column(name ="TRANGTHAI")
	private boolean status;
	
	@Column(name ="HINHANH")
	private String image;
	
	@OneToMany(mappedBy = "category")
	private List<Product> listProduct;

	
	public Category() {
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return listProduct;
	}

	
}
