package hibernate.basics.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bank2 {
	@Id
	private int id;
	private String name;
	
	@OneToMany(mappedBy = "bank" ,cascade = CascadeType.ALL)
	private List<Accounts2> account2;

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

	public List<Accounts2> getAccount2() {
		return account2;
	}

	public void setAccount2(List<Accounts2> account2) {
		this.account2 = account2;
	}

	@Override
	public String toString() {
		return "Bank2 [id=" + id + ", name=" + name + ", account2=" + account2 + "]";
	}

		
	

}
