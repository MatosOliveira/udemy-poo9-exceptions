/**
 * 
 */
package model.entities;

import model.exceptions.DomainException;

/**
 * Classe que contem as informacoes de uma conta
 * 
 * @author Matos - 16.06.2023
 *
 */
public class Account {

	private Integer number;
	private String holder;
	protected Double balance;
	private Double withdrawLimit;
	
	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}
	
	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	//saque
	public void withdraw(double amount) {
		
		if(balance == 0.0) {
			throw new DomainException("Saldo insuficiente.");
		}
		
		if(amount > withdrawLimit) {
			throw new DomainException("O limite de saque da conta foi excedido.");
		}
		
		balance -= amount;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
}
