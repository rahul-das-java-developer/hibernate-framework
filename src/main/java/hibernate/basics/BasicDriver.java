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
		std.setId(103);
		std.setName("Girish Pujar");
		std.setAge(25);
		
		transaction.begin();
		manager.persist(std);
		transaction.commit();
		
		int id=22;
		Student std1=manager.find(Student.class, id);
		
		if(std1!=null) {
			
			transaction.begin();
			manager.remove(std1);
			transaction.commit();
			System.out.println("Record saved!");
		}
		else {
			System.out.println("Invalid Id!!!");
		}
		
		
		
		
		
	}

	
}
