package hibernate.basics;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate.basics.entity.Students2;
import hibernate.basics.entity.Subjects2;

public class ManyToManyBiDirection {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("rahul");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		// INSERT
		Students2 std = new Students2();
		std.setId(101);
		std.setName("Girish Puajar");
		std.setAge(21);
		
		Subjects2 sub1 = new Subjects2();
		sub1.setId(201);
		sub1.setName("JAVA");
		sub1.setDays(66);
		
		Subjects2 sub2 = new Subjects2();
		sub2.setId(202);
		sub2.setName("SQL");
		sub2.setDays(44);
		
		std.addSubject(sub1);
		std.addSubject(sub2);
		
		transaction.begin();
		manager.persist(std);
		transaction.commit();
		System.out.println("DATA saved!");
		
		// FETCH 
		Students2 std2 = manager.find(Students2.class, 101);
		if(std2!=null) {
			Set<Subjects2> sub = std2.getSubjects2();
			for (Subjects2 s : sub) {
				System.out.println(std2.getName()+" is studying "+s.getName());
			}
		}
		
		// FETCH 
		Subjects2 s1 = manager.find(Subjects2.class, 201);
		if(s1!=null) {
			Set<Students2> sub = s1.getStudents2();
			for (Students2 s : sub) {
				System.out.println(s1.getName()+" is taken by: "+s.getName());
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
