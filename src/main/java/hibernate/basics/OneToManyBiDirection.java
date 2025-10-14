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
//		transaction.commit();xj

//		// FETCH both using bank
//		Bank2 bank1 = manager.find(Bank2.class, 102);
//		if(bank1!=null) {
//			System.out.println("-----------------------------------------------");
//			System.out.println("Bank Id: "+bank1.getId()+", Bank Name: "+bank1.getName());
//			
//			List<Accounts2> accList1 = bank1.getAccount2();
//			
//			if(accList1!=null) {
//				for (Accounts2 acc : accList1) {
//					System.out.println("-----------------------------------------------");
//					System.out.println(acc);
//				}
//				System.out.println("-----------------------------------------------");
//			}
//		}

//		// FETCH both using accounts
//		Accounts2 acc = manager.find(Accounts2.class, 202);
//		if(acc!=null) {
//			System.out.println(acc.getAccHolder()+" has his account on "+ acc.getBank().getName()+" bank!!");
//		}

//		
//		// UPDATE ALL
//		transaction.begin();
//		Bank2 bank2 = manager.find(Bank2.class, 101);
//		if (bank2 != null) {
//			bank2.setName("ICICI");
//			List<Accounts2> accList2 = bank2.getAccount2();
//			for (Accounts2 acc : accList2) {
//				acc.setBalance(acc.getBalance() + 100);
//			}
//			 bank2.setAccount2(accList2); ????
//			manager.merge(bank2);
//			transaction.commit();
//		}
//
//		// UPDATE Individual Account
//		Accounts2 accUpdate = null;
//		Bank2 bank3 = manager.find(Bank2.class, 101);
//		if(bank3!=null) {
//			List<Accounts2> accList3 = bank3.getAccount2();
//			for (Accounts2 acc : accList3) {
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
		// DELETE both using CascadeType.ALL
		transaction.begin();
		Bank2 bank4=manager.find(Bank2.class,101);
		if(bank4!=null) {
			manager.remove(bank4);	// Delete Bank as well as Accounts also
			transaction.commit();
		}
	

	}

}
