// FAILED TEST EXAMPLE
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BankAccountTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMakeLodgement() {
		BankAccount account = new BankAccount(1000,123,2);
		account.makeLodgement(20);
		double actual = account.getBalance();
		assertEquals(1020,actual,0.0);
	}

	@Test
	public void testMakeWithdrawal() {
		BankAccount account = new BankAccount(1000,123,2);
		double actual = account.makeWithdrawal(40);
		assertEquals(960,actual,0.0);
	}

	@Test
	public void testGetBalance() {
		BankAccount account = new BankAccount(1000,123,2);
		double actual = account.getBalance();
		assertEquals(1000,actual,0.0);
	}

	@Test
	public void testAddInterest() {
		BankAccount account = new BankAccount(1000,123,2);
		account.addInterest();
		double actual = account.getBalance();
		assertEquals(1020,actual,0.0);
	}
}
