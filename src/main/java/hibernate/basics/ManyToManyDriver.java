package hibernate.basics;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate.basics.entity.Student;
import hibernate.basics.entity.Students;
import hibernate.basics.entity.Subjects;

public class ManyToManyDriver {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("rahul");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		
		
		// INSERT both
//		Students std =new Students();
//		std.setId(101);
//		std.setName("Rahul Das");
//		std.setAge(21);
//		
//		Subjects sub1=new Subjects();
//		sub1.setId(201);
//		sub1.setName("Java");
//		sub1.setDays(65);
//		
//		Subjects sub2=new Subjects();
//		sub2.setId(202);
//		sub2.setName("SQL");
//		sub2.setDays(42);
//		
//		List<Subjects> subList=new ArrayList<Subjects>();
//		subList.add(sub1);
//		subList.add(sub2);
//		std.setSubjects(subList);
//		
//		transaction.begin();
//		manager.persist(std);
//		manager.persist(sub1);
//		manager.persist(sub2);
//		transaction.commit();
//		System.out.println("Data inserted successfully!");
//		
//		
//		// INSER new Student in Existing Subjects
//		Students std =new Students();
//		std.setId(102);
//		std.setName("Roronoa Zoro");
//		std.setAge(28);
//		
//		Subjects s1=manager.find(Subjects.class, 201);
//		Subjects s2=manager.find(Subjects.class, 202);
//		if(s1!=null & s2!= null) {
//			List<Subjects> subList=new ArrayList<Subjects>();
//			subList.add(s1);
//			subList.add(s2);
//			std.setSubjects(subList);
//			
//			transaction.begin();
//			manager.persist(std);
//			transaction.commit();
//			System.out.println("Adding new Student in Existing Subjects done!!!!");
//		}
//		
//		
//		// INSERT new Student and new Subject
//		Students std1=new Students();
//		std1.setId(103);
//		std1.setName("Monkey D. Luffy");
//		std1.setAge(22);
//
//		Students std2=new Students();
//		std2.setId(104);
//		std2.setName("Uzumaki Naruto");
//		std2.setAge(32);
//		
//		Subjects s3=new Subjects();
//		s3.setId(203);
//		s3.setName("WEB");
//		s3.setDays(68);
//		
//		Subjects s1=manager.find(Subjects.class, 201);
//		Subjects s2=manager.find(Subjects.class, 202);
//		
//		if(s1!=null & s2!= null) {
//			List<Subjects> subList=new ArrayList<Subjects>();
//			subList.add(s1);
//			subList.add(s2);
//			subList.add(s3);
//			
//			std1.setSubjects(subList);
//			std2.setSubjects(subList);
//			transaction.begin();
//			manager.persist(std1);
//			manager.persist(std2);
//			manager.persist(s3);
//			transaction.commit();
//			System.out.println("Adding new Student & new Subject is done!!!!");
//		}
		
		
		// FETCH both using student
		Students std=manager.find(Students.class, 103);
		if(std!=null) {
			System.out.println(std);
			System.out.println("Courses taken by "+std.getName()+" is given below:");
			List<Subjects> list=std.getSubjects();
			for (Subjects s : list) {
				System.out.println(s);
			}
		}

		
//		// UPDATE both using students
//		Students std1 = manager.find(Students.class, 101);
//		Subjects sub1 = null;
//		
//		if(std1!=null) {
//			std1.setAge(20);
//			std1.setName("Rahul_Das");
//			List<Subjects> list = std1.getSubjects();
//			for (Subjects s : list) {
//				if(s.getId()==201) {
//					sub1=s;
//				}
//			}
//			sub1.setName("Python"); // but we can't do this in real time	
//			transaction.begin();
//			manager.merge(std1);
//			manager.merge(sub1);
//			transaction.commit();
//			System.out.println("Updated!!");
//		}.
		
//		// UPDATE subject only
//		Subjects sub = manager.find(Subjects.class, 201);
//		if(sub!=null) {
//			sub.setName("JAVA");
//			transaction.begin();
//			manager.merge(sub);
//			transaction.commit();
//			System.out.println("Updated!!");	
//		}
		
		
		
//		// DELETE student only
//		Students std2 = manager.find(Students.class, 102);
//		if(std2!=null) {			
//			transaction.begin();
//			manager.remove(std2);
//			transaction.commit();
//			System.out.println("Deleted!!");
//			
//		}

		
		

	}
}
