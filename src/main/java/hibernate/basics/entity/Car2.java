package hibernate.basics.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Car2 {
	@Id
	private int id;
	private String name;
	private long price;
	
	@OneToOne(mappedBy = "car2",cascade = CascadeType.ALL)
	private Engine2 engine2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Engine2 getEngine2() {
		return engine2;
	}

	public void setEngine2(Engine2 engine2) {
		this.engine2 = engine2;
	}
	
	@Override
	public String toString() {
		return "Car2 [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

	

	


	
	
	

}
