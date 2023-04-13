package phoneaccessories.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReceiptDetailPk implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column(name = "MAPHIEUNHAP",length = 10)
    private String receipt;

    @Column(name = "MASANPHAM",length = 10)
    private String product;
    
	public ReceiptDetailPk() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ReceiptDetailPk(String receipt, String product) {
		super();
		this.receipt = receipt;
		this.product = product;
	}


	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(product, receipt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReceiptDetailPk other = (ReceiptDetailPk) obj;
		return Objects.equals(product, other.product) && Objects.equals(receipt, other.receipt);
	}
	
	
}
