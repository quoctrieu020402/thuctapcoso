package phoneaccessories.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "CHITIETPHIEUNHAP")
public class ReceiptDetail {
	@EmbeddedId
	private ReceiptDetailPk id;
	
	@ManyToOne
	@MapsId("receipt")
	@JoinColumn(name = "MAPHIEUNHAP")
	private Receipt receipt;
	
	@ManyToOne
	@MapsId("product")
	@JoinColumn(name = "MASANPHAM")
	private Product product;
	
	@Column(name = "SOLUONG")
	private int quantity;
	
	@Column(name = "GIANHAP")
	private double price;
	
	public ReceiptDetail() {
		// TODO Auto-generated constructor stub
	}

	public ReceiptDetailPk getId() {
		return id;
	}

	public void setId(ReceiptDetailPk id) {
		this.id = id;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ReceiptDetail [id=" + id + ", receipt=" + receipt + ", product=" + product + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
	
	
}
