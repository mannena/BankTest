package Kata;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PersonalAccount {
	private double amount;
	private double balance;
	private List<Operation> operations;
	
	public PersonalAccount() {
		this.operations = new ArrayList<Operation>();
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public void makeDeposit(double amountToAdd) {
		if (amountToAdd < 0) {
			throw new IllegalArgumentException("The amount of deposit must be positive");
		} else {
			Operation operation = new Operation();
			operation.setDate(LocalDateTime.now());
			operation.setType(OperationType.DEOPOSIT);
			operation.setAmount(amountToAdd);
			this.balance += amountToAdd;// update account
			this.operations.add(operation);
		}
	}

	public void makeWithdrawal(double amountToSubstruct) {
		if (amountToSubstruct < 0) {
			throw new IllegalArgumentException("The amount of Withdrawal must be positive");
		} else {
			Operation operation = new Operation();
			operation.setDate(LocalDateTime.now());
			operation.setType(OperationType.WITHDRWAL);
			operation.setAmount(amountToSubstruct);
			this.balance -= amountToSubstruct;// update account
			this.operations.add(operation);
		}
	}
}
