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
		System.out.println(manager + " created!!");

		// Commit
		EntityTransaction transaction = manager.getTransaction();

		// INSERT
		Student std = new Student();
		
		transaction.begin();
		std.setId(105);
		std.setName("Chinmaya Sahu");
		std.setAge(20);
		manager.persist(std);
		transaction.commit();
		System.out.println("Record saved!!!!!!!!!!!!!");
		

		// DELETE
		int id1 = 104; // for time being we take statically
		Student std1 = manager.find(Student.class, id1);

		if (std1 != null) {

			transaction.begin();
			manager.remove(std1);
			transaction.commit();
			System.out.println("Record removed!!!!!!!!!!!");
		} else {
			System.out.println("Invalid Id!!!");
		}
		
		
		//UPDATE
		int id2 = 103;
		Student std2 = manager.find(Student.class, id2);
		if (std2 != null) {

			transaction.begin();
			std2.setName("Prajwal Patil");
			manager.merge(std2);
			transaction.commit();
			System.out.println("Record updated!!!!!!!!!!!");
		} else {
			System.out.println("Invalid Id!!!");
		}
		
		//FETCH
		int id3 = 101;
		Student std3 = manager.find(Student.class, id3);
		if (std3 != null) {
			
			System.out.println("Name: "+std3.getName()+", Age: "+std3.getAge());
			System.out.println("Record fetched!!!!!!!!!!");
		} else {
			System.out.println("Invalid Id!!!");
		}

	}

}
