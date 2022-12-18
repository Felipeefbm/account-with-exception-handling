package model.entities;

import model.exceptions.BusinessException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
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
	
	public void deposit (Double amount) {
		balance += amount;
	}
	
	public void withdraw(Double amount) {  // se voltar alguma mensagem de erro o metodo withdraw é "cortado" na validação
		validateWithdraw(amount);
		balance-= amount;
	}
	
	private void validateWithdraw(Double amount) { 
		if (amount > getBalance()) {
			throw new BusinessException("Erro: not enough balance");
		}
		if(amount > getWithdrawLimit()) {
			throw new BusinessException("Erro: the amount exceeds withdraw limit");
		}
		
	}
		
	
}
