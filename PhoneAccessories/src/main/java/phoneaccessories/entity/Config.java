package phoneaccessories.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CAUHINH")
public class Config {
	@Id
	@Column(name ="MACAUHINH")
	private String id;
	
	@Column(name = "KICHTHUOCMANHINH")
	private String screenSize;
	
	@Column(name="HEDIEUHANH")
	private String system;
	
	@Column(name = "PIN")
	private String pin;
	
	@Column(name = "RAM")
	private String ram;
	
	@Column(name = "ROM")
	private String rom;
	
	@Column(name = "RESOLUTION")
	private String resolution;
	
	@Column(name = "CARDDOHOA")
	private String cardGraphic;
	
	@OneToMany(mappedBy = "config")
	private List<Product> listProduct;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getRom() {
		return rom;
	}

	public void setRom(String rom) {
		this.rom = rom;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getCardGraphic() {
		return cardGraphic;
	}

	public void setCardGraphic(String cardGraphic) {
		this.cardGraphic = cardGraphic;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}
	
	
}
