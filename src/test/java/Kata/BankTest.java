package Kata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class BankTest {
	/*
	 * US 1: In order to save money As a bank client I want to make a deposit in my
	 * account
	 */
	@Test
	public void testDepepositPositiveAmount() {
		PersonalAccount account = new PersonalAccount();
		account.makeDeposit(100);
		assertEquals(100, account.getBalance(), 0);// tolerance 0
	}

	@Test
	public void testDepepositNegativeAmount() {
		try {
			PersonalAccount account = new PersonalAccount();
			account.makeDeposit(-100);
			assertEquals(-100, account.getBalance(), 0);// tolerance 0
			fail("Should throw exception when making a deposit of a negative number");

		} catch (IllegalArgumentException exp) {
			assert (exp.getMessage().contains("The amount of deposit must be positive"));
		}
	}
	@Test
	public void testDepepositMultiple() {
		PersonalAccount account = new PersonalAccount();
		account.setBalance(-100);
		account.makeDeposit(100);
		account.makeDeposit(200);
		account.makeDeposit(300);
		assertEquals(500, account.getBalance(), 0);// tolerance 0
		assertEquals(3, account.getOperations().size());
	}

	/*
	 * US 2: In order to retrieve some or all of my savings As a bank client I want
	 * to make a withdrawal from my account
	 * 
	 */
	@Test
	public void testWithdrawalPositiveAmount() {
		PersonalAccount account = new PersonalAccount();
		account.setBalance(1000);
		account.makeWithdrawal(100);
		assertEquals(900, account.getBalance(), 0);// tolerance 0
	}

	@Test
	public void testWithdrawalNegativeAmount() {
		try {
			PersonalAccount account = new PersonalAccount();
			account.setBalance(1000);
			account.makeWithdrawal(-100);
			assertEquals(-100, account.getBalance(), 0);// tolerance 0
			fail("Should throw exception when making a Withdrawal of a negative number");

		} catch (IllegalArgumentException exp) {
			assert (exp.getMessage().contains("The amount of Withdrawal must be positive"));
		}
	}
}
