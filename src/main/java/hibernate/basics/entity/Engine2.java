package hibernate.basics.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Engine2 {
	@Id
	private int id;
	private String fuelType;
	private int cc;
	
	@OneToOne
	private Car2 car2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public Car2 getCar2() {
		return car2;
	}

	public void setCar2(Car2 car2) {
		this.car2 = car2;
	}

	@Override
	public String toString() {
		return "Engine2 [id=" + id + ", fuelType=" + fuelType + ", cc=" + cc + "]";
	}
	
	
	

}
