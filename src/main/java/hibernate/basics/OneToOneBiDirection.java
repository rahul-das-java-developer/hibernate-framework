package hibernate.basics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate.basics.entity.Car2;
import hibernate.basics.entity.Engine2;

public class OneToOneBiDirection {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("rahul");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

//		// INSERT both
//		Car2 car = new Car2();
//		car.setId(101);
//		car.setName("BMW");
//		car.setPrice(8564236);
//
//		Engine2 engine = new Engine2();
//		engine.setId(201);
//		engine.setFuelType("Prtrol");
//		engine.setCc(3200);
//
//		car.setEngine2(engine);
//		engine.setCar2(car);
//		
//		transaction.begin();
//		manager.persist(car);
//		manager.persist(engine);
//		transaction.commit();
//		System.out.println("Data inserted!!");
//
//
//		// FETCH both using car
//		Car2 car1 = manager.find(Car2.class, 101);
//		if (car1 != null) {
//			System.out.println(car1.getName()+" used "+car1.getEngine2().getFuelType());
//		}
//		
//
//		// FETCH both using engine
//		Engine2 engine1 = manager.find(Engine2.class, 201);
//		if (engine1 != null) {
//			System.out.println(engine1.getFuelType()+" is used in "+engine1.getCar2().getName());
//		}
//
//
//		 // DELETE both using car
//		transaction.begin();
//		Car2 car2 = manager.find(Car2.class, 102);
//		
//		if (car2 != null) {
//			manager.remove(car2);
//			transaction.commit();
//			System.out.println("Data deleted!!");
//		}
//	
//
		// DELETE both using engine ??not possible
		transaction.begin();
		Engine2 e2 = manager.find(Engine2.class, 201);
		System.out.println(e2);
		
		if (e2 != null) {
			System.out.println("inside");
			manager.remove(e2);
			transaction.commit();
			System.out.println("operation end");
			
		}
//
//		// UPDATE both using car
//		transaction.begin();
//		Car2 car3 = manager.find(Car2.class, 101);
//
//		if (car3 != null) {
//			car3.setPrice(999999);
//			car3.getEngine2().setFuelType("Petrol + CNG");
//			manager.merge(car3);	// Bcoz we're using cascadeType.ALL
//			transaction.commit();
//			System.out.println("Updated successfully!!!");
//
//		}
//		
//		
//		// UPDATE both using engine
//		transaction.begin();
//		Engine2 e2 = manager.find(Engine2.class, 201);
//		
//		if (e2 != null) {
//			e2.setFuelType("CNG");
//			e2.getCar2().setName("BENZ");
//			manager.merge(e2.getCar2());	// Bcoz we're using cascadeType.ALL
//			transaction.commit();
//			System.out.println("Updated successfully!!!");
//			
//		}

	}

}
