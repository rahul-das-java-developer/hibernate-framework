package hibernate.basics.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate.basics.entity.Teacher;

public class TeacherService {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("rahul");
	private static EntityManager manager = factory.createEntityManager();
	private static EntityTransaction transaction = manager.getTransaction();
	private static Scanner scn=new Scanner(System.in);

	
	public void insertData(Teacher th) {
		
			transaction.begin();
			manager.persist(th);
			transaction.commit();
			System.out.println("Record saved!!");
		
	}
	public void deleteData(Teacher th) {
		th = manager.find(Teacher.class, th.getId());
		if(th!=null) {
			
			transaction.begin();
			manager.remove(th);
			transaction.commit();
			System.out.println("Record deleted!!");
		}else {
			System.out.println("Invalid Id!!");
		}
	}
	public void updateData(Teacher th) {
		th = manager.find(Teacher.class, th.getId());
		if(th!=null) {
			
			transaction.begin();
			System.out.println("Enter updated name: ");
			
			th.setName(scn.nextLine());
			manager.merge(th);
			transaction.commit();
			System.out.println("Record updated!!");
		}else {
			System.out.println("Invalid Id!!");
		}
	}
	
	public void fetchData() {
		Query query = manager.createQuery("from Teacher");
		List<Teacher> list = query.getResultList();
		
		for (Teacher teacher : list) {
			System.out.println(teacher);
		}
		
		
	}
	
	
	public void exitApp() {
		scn.close();
		manager.close();
	}
	
	
	
	

}
