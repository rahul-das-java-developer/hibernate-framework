package hibernate.basics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate.basics.entity.Product;
import hibernate.basics.entity.Reviews;

public class ReviewsDriver {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("rahul");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();

		// INSERT
		Product product1 = new Product();
		product1.setId(102);
		product1.setName("TV");
		product1.setPrice(32999);

		Reviews reviews1 = new Reviews();
		reviews1.setId(203);
		reviews1.setMsg("Not Good that much!!");
		reviews1.setProduct(product1);

		Reviews reviews2 = new Reviews();
		reviews2.setId(204);
		reviews2.setMsg("Not Bad");
		reviews2.setProduct(product1);

		manager.persist(product1);
		manager.persist(reviews1);
		manager.persist(reviews2);
		transaction.commit();

		// FETCH both Reviews & Product
		Reviews reviews3 = manager.find(Reviews.class, 201);
		if (reviews3 != null) {
			System.out.println(reviews3);
			Product product = manager.find(Product.class, 101);
			if (product != null) {
				System.out.println(product);
			}
		}

		// FETCH Product only
		Product product2 = manager.find(Product.class, 102);
		if (product2 != null) {
			System.out.println(product2);
		}
		
		// DELETE Reviews only
		Reviews reviews4 = manager.find(Reviews.class, 201);
		if (reviews4 != null) {
			manager.remove(reviews4);
			transaction.commit();
			
		}
		
		// UPDATE reviews 
		Reviews reviews5 = manager.find(Reviews.class, 201);
		if (reviews5 != null) {
			reviews5.setMsg("Awesome!");
			manager.merge(reviews5);
			transaction.commit();
			
		}
		
		// UPDATE Product
		Product product3 = manager.find(Product.class, 102);
		if (product3 != null) {
			product3.setPrice(59999);
			manager.merge(product3);
			transaction.commit();
			
		}
		
		
		
		
		

	}

}
