package hibernate.basics.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Students2 {

	@Id
	private int id;
	private String name;
	private int age;
	
	@ManyToMany(mappedBy = "students2",cascade = CascadeType.ALL)
	private Set<Subjects2> subjects2 = new HashSet<Subjects2>();

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<Subjects2> getSubjects2() {
		return subjects2;
	}

	public void setSubjects2(Set<Subjects2> subjects2) {
		this.subjects2 = subjects2;
	}

	public void addSubject(Subjects2 sub) {
		subjects2.add(sub);
		sub.getStudents2().add(this);
		
	}
	
	public void deleteSubject(Subjects2 sub) {
		subjects2.remove(sub);
		sub.getStudents2().remove(this);
		
	}
	
	
}
