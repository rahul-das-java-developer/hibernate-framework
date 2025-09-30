package hibernate.basics;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate.basics.entity.Accounts;
import hibernate.basics.entity.Bank;

public class BankDriver {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("rahul");

		EntityManager manager = factory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();

		Bank bank = new Bank();
		bank.setId(103);
		bank.setName("Axis");

		Accounts acc1 = new Accounts();
		acc1.setId(205);
		acc1.setAccHolder("Girish Pujar");
		acc1.setBalance(780000);

		Accounts acc2 = new Accounts();
		acc2.setId(206);
		acc2.setAccHolder("Sachin Tendulkar");
		acc2.setBalance(89645900);

		List<Accounts> accList = new ArrayList<Accounts>();
		accList.add(acc1);
		accList.add(acc2);

		bank.setAccount(accList);

		transaction.begin();
		manager.persist(bank);
		manager.persist(acc1);
		manager.persist(acc2);
		transaction.commit();
		
		
		Bank bank1 = manager.find(Bank.class, 103);
		if(bank1!=null) {
			System.out.println("-----------------------------------------------");
			System.out.println("Bank Id: "+bank1.getId()+", Bank Name: "+bank1.getName());
			
			List<Accounts> accList1 = bank1.getAccount();
			
			if(accList1!=null) {
				for (Accounts acc : accList1) {
					System.out.println("-----------------------------------------------");
					System.out.println(acc);
				}
				System.out.println("-----------------------------------------------");
			}
		}

	}

}
