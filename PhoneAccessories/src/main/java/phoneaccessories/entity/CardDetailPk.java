package phoneaccessories.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CardDetailPk implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "MASANPHAM",length = 10)
	private String product;
	@Column(name ="MAGIOHANG",length = 10)
	private String cart;
	
	public CardDetailPk() {
		// TODO Auto-generated constructor stub
	}

	
	public CardDetailPk(String product, String cart) {
		super();
		this.product = product;
		this.cart = cart;
	}

	
	
	public String getProduct() {
		return product;
	}


	public void setProduct(String product) {
		this.product = product;
	}


	public String getCard() {
		return cart;
	}


	public void setCard(String cart) {
		this.cart = cart;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cart, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardDetailPk other = (CardDetailPk) obj;
		return Objects.equals(cart, other.cart) && Objects.equals(product, other.product);
	}
	
	
}
