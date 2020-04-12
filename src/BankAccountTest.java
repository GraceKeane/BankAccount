// Failed test example
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
		BankAccount account1 = new BankAccount(1000.0, 123, 2);
		double expectedBalance = 1000;
		double actualBalance = account1.makeLodgement(40);
		
		assertEquals(expectedBalance, actualBalance, 0.0);
	}

	@Test
	public void testMakeWithdrawal() {
		BankAccount account1 = new BankAccount(1000.0, 123, 2);
		double expectedBalance = 980;
		double actualBalance = account1.makeWithdrawal(20);
		
		assertEquals(expectedBalance, actualBalance, 0.0);	}

	@Test
	public void testGetBalance() {
		BankAccount account1 = new BankAccount(1000.0, 123, 2);

		assertEquals(1000.0, account1.getBalance(), 0.0);
	}

	@Test
	public void testAddInterest() {
		BankAccount account1 = new BankAccount(1000.0, 123, 2);
		
		double expected = 1020;
		
		account1.addInterest();
		
		assertEquals(expected, account1.getBalance(), 0.0);
	}

}
