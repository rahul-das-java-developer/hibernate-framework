package hibernate.basics.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Subjects2 {
	
	@Id
	private int id;
	private String name;
	private int days;
	
	@ManyToMany
	private Set<Students2> students2 = new HashSet<Students2>();

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

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public Set<Students2> getStudents2() {
		return students2;
	}

	public void setStudents2(Set<Students2> students2) {
		this.students2 = students2;
	}
	
	
	

}
