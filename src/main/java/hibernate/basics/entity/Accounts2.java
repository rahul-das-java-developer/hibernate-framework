package hibernate.basics.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Accounts2 {
	@Id
	private int id;
	private String accHolder;
	private int balance;
	
	@ManyToOne
	private Bank2 bank;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Bank2 getBank() {
		return bank;
	}
	public void setBank(Bank2 bank) {
		this.bank = bank;
	}
	public String getAccHolder() {
		return accHolder;
	}
	public void setAccHolder(String accHolder) {
		this.accHolder = accHolder;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Accounts [id=" + id + ", accHolder=" + accHolder + ", balance=" + balance + "]";
	}
	

}
