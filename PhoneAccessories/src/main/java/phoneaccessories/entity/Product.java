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
import javax.persistence.Table;

@Entity
@Table(name="SANPHAM")
public class Product {
	@Id
	@Column(name = "MASANPHAM",length = 10)
	private String id;
	@Column(name = "TENSANPHAM",length = 10)
	private String name;
	@Column(name = "MOTA",length = 5000)
	private String description;
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", image="
				+ image + ", status=" + status + ", number=" + number + ", category=" + category + "]";
	}

	@Column(name = "GIA")
	private double price;
	@Column(name = "HINHANH",length = 200)
	private String image;
	@Column(name = "TRANGTHAI")
	private boolean status;
	@Column(name = "SOLUONGTON")
	private int number;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "MADANHMUC")
	private Category category;
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<ReceiptDetail> listReceiptDetail;
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<CardDetail> listCardDetail;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<ReceiptDetail> getListReceiptDetail() {
		return listReceiptDetail;
	}
	

	public void setListReceiptDetail(List<ReceiptDetail> listReceiptDetail) {
		this.listReceiptDetail = listReceiptDetail;
	}
	
	

	public List<CardDetail> getListCardDetail() {
		return listCardDetail;
	}


	public void setListCardDetail(List<CardDetail> listCardDetail) {
		this.listCardDetail = listCardDetail;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
