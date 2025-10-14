package hibernate.basics;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate.basics.entity.Accounts2;
import hibernate.basics.entity.Bank2;


public class OneToManyBiDirection {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("rahul");

		EntityManager manager = factory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();

//		// INSERT
//		Bank2 bank = new Bank2();
//		bank.setId(102);
//		bank.setName("SBI");
//
//		Accounts2 acc1 = new Accounts2();
//		acc1.setId(203);
//		acc1.setAccHolder("Rahul Das");
//		acc1.setBalance(780000);
//		acc1.setBank(bank);
//		
//		Accounts2 acc2 = new Accounts2();
//		acc2.setId(204);
//		acc2.setAccHolder("Virat Kohli");
//		acc2.setBalance(89645900);
//		acc2.setBank(bank);
//
//		List<Accounts2> accList = new ArrayList<Accounts2>();
//		accList.add(acc1);
//		accList.add(acc2);
//
//		bank.setAccount2(accList);
//
//		transaction.begin();
//		manager.persist(bank);
//		transaction.commit();
		
		
//		// FETCH both using bank
//		Bank bank1 = manager.find(Bank.class, 103);
//		if(bank1!=null) {
//			System.out.println("-----------------------------------------------");
//			System.out.println("Bank Id: "+bank1.getId()+", Bank Name: "+bank1.getName());
//			
//			List<Accounts> accList1 = bank1.getAccount();
//			
//			if(accList1!=null) {
//				for (Accounts acc : accList1) {
//					System.out.println("-----------------------------------------------");
//					System.out.println(acc);
//				}
//				System.out.println("-----------------------------------------------");
//			}
//		}
		
		// FETCH both using accounts
//		Accounts2
		
//		
//		// UPDATE ALL
//		Bank bank2 = manager.find(Bank.class, 101);
//		if(bank2!=null)
//		{
//			List<Accounts> accList2 = bank2.getAccount();
//			bank2.setName("ICICI");
//			for (Accounts acc : accList2) {
//				acc.setBalance(acc.getBalance()+10000);
//				manager.merge(acc); // we are not using casecadeType we've to merge() both
//			}
//			manager.merge(bank2);
//			transaction.commit();
//		}
//
//		// UPDATE Individual Account
//		Accounts accUpdate = null;
//		Bank bank3 = manager.find(Bank.class, 101);
//		if(bank3!=null) {
//			List<Accounts> accList3 = bank3.getAccount();
//			for (Accounts acc : accList3) {
//				if(acc.getId()==202) {
//					accUpdate=acc;	// We should'nt update anything inside a running loop it might through RTE
//				}	
//			}
//		}
//		accUpdate.setAccHolder("Virat Kohli");
//		manager.merge(accUpdate);
//		manager.merge(bank3);
//		transaction.commit();
//		
//		// DELETE both using CascadeType.ALL
//		Bank bank4=manager.find(Bank.class,103);
//		if(bank4!=null) {
//			manager.remove(bank4);	// Delete Bank as well as Accounts also
//			transaction.commit();
//		}
//			
//		// Deleting individual account
//		

	}

}
