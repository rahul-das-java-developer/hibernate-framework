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
		transaction.begin();

		// INSERT
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

		manager.persist(bank);
		manager.persist(acc1);
		manager.persist(acc2);
		transaction.commit();
		
		
		// FETCH
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
		
		// UPDATE ALL
		Bank bank2 = manager.find(Bank.class, 101);
		if(bank2!=null)
		{
			List<Accounts> accList2 = bank2.getAccount();
			bank2.setName("ICICI");
			for (Accounts acc : accList2) {
				acc.setBalance(acc.getBalance()+10000);
				manager.merge(acc); // we are not using casecadeType we've to merge() both
			}
			manager.merge(bank2);
			transaction.commit();
		}

		// UPDATE Individual Account
		Accounts accUpdate = null;
		Bank bank3 = manager.find(Bank.class, 101);
		if(bank3!=null) {
			List<Accounts> accList3 = bank3.getAccount();
			for (Accounts acc : accList3) {
				if(acc.getId()==202) {
					accUpdate=acc;	// We should'nt update anything inside a running loop it might through RTE
				}	
			}
		}
		accUpdate.setAccHolder("Virat Kohli");
		manager.merge(accUpdate);
		manager.merge(bank3);
		transaction.commit();
		
		// DELETE using CascadeType.ALL
		Bank bank4=manager.find(Bank.class,103);
		if(bank4!=null) {
			manager.remove(bank4);	// Delete Bank as well as Accounts also
			transaction.commit();
		}
		
		// Add Account in an Existing Bank
		Bank bank5 = manager.find(Bank.class, 101);
		if(bank5!=null) {
			Accounts acc=new Accounts();
			acc.setId(206);
			acc.setAccHolder("Md. Siraj");
			acc.setBalance(56000);
			List<Accounts> accList4 = bank5.getAccount();
			accList4.add(acc);
			bank5.setAccount(accList4);
			manager.merge(bank5);
			transaction.commit();
		}
		
		// Deleting individual account
		Bank bank6 = manager.find(Bank.class, 101);
		if(bank6!=null) {
			Accounts acc=manager.find(Accounts.class, 206);
			if(acc!=null) {
				bank6.getAccount().remove(acc);
				manager.remove(acc);
			}
			manager.merge(bank6);
			transaction.commit();
		}
		
		
		
	}

}
