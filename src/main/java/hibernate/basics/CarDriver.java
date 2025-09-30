package hibernate.basics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate.basics.entity.Car;
import hibernate.basics.entity.Engine;

public class CarDriver {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("rahul");

		EntityManager manager = factory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();

		// INSERT
		Car car = new Car();
		car.setId(102);
		car.setName("Porsche");
		car.setPrice(98568999);

		Engine engine = new Engine();
		engine.setId(202);
		engine.setFuelType("Diesel");
		engine.setCc(2300);

		car.setEngine(engine);

		manager.persist(car);
		manager.persist(engine);
		transaction.commit();

		// FETCH
		Car car1 = manager.find(Car.class, 101);
		if (car1 != null) {
			System.out.println(car1);
			Engine engine1 = car1.getEngine();
			if (engine1 != null) {
				System.out.println(engine1);
			}

		}

		// DELETE
		Car car2 = manager.find(Car.class, 102);
		
		if (car2 != null) {
			car2.setEngine(null);
			Engine engine2 = manager.find(Engine.class, 202);
			manager.remove(engine2);
			transaction.commit();

		}
		
		// UPDATE
		Car car3 = manager.find(Car.class, 101);
		
		if (car3 != null) {
			car3.setPrice(898989999);
			car3.getEngine().setFuelType("Petrol + CNG");
			manager.merge(car3);
			manager.merge(car3.getEngine());
			transaction.commit();
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
