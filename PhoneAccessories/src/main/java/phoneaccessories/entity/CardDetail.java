package phoneaccessories.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "CHITIETGIOHANG")
public class CardDetail {
	@EmbeddedId
	private CardDetailPk id;
	
	@ManyToOne
	@MapsId("product")
	@JoinColumn(name ="MASANPHAM")
	private Product product;
	
	@ManyToOne
	@MapsId("cart")
	@JoinColumn(name = "MAGIOHANG")
	private Cart cart;
	
	@Column(name = "SOLUONG")
	private int quantity;
	
	public CardDetail() {
		// TODO Auto-generated constructor stub
	}

	public CardDetailPk getId() {
		return id;
	}

	public void setId(CardDetailPk id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Cart getCard() {
		return cart;
	}

	public void setCard(Cart cart) {
		this.cart = cart;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
