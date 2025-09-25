package hibernate.basics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate.basics.entity.Student;

public class BasicDriver {

	public static void main(String[] args) {
		
		// Establishing connection to DB
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("rahul");
		System.out.println(factory);
		
		// To perform CRUD operation
		EntityManager manager = factory.createEntityManager();
		System.out.println(manager+" created!!");
		
		//Commit
		EntityTransaction transaction = manager.getTransaction();
		
		Student std=new Student();
		std.setId(101);
		std.setName("Rahul Das");
		std.setAge(22);
		
		transaction.begin();
		manager.persist(std);
		transaction.commit();
		
		
		
	}

	
}
