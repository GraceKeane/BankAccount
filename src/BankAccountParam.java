import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class BankAccountParam {
	
	// Values
	private double initialBalance;
	private int accNo;
	private int interest;
	private double BalanceAfterLodge;
	private float Lodge;
	private double BalanceAfterWith;
	private float with;
	private double expectedAfterInterest;
	
	// Generated constructor
	public BankAccountParam(double initialBalance, int accNo, int interest, double balanceAfterLodge, float lodge,
			double balanceAfterWith, float with, double expectedAfterInterest) {
		super();
		this.initialBalance = initialBalance;
		this.accNo = accNo;
		this.interest = interest;
		BalanceAfterLodge = balanceAfterLodge;
		Lodge = lodge;
		BalanceAfterWith = balanceAfterWith;
		this.with = with;
		this.expectedAfterInterest = expectedAfterInterest;
	}
	
	@Parameters
	public static Collection<Object[]> getData()
	{
		Object[][] data = new Object[2][8];
		
		// Data
		data[0][0] = 1000.0;
		data[0][1] = 123;
		data[0][2] = 2;
		data[0][3] = 1050.0;
		data[0][4] = (float)50.0;
		data[0][5] = 940.0;
		data[0][6] = (float)60.0;
		data[0][7] = 1020.0;
		
		data[1][0] = 1000.0;
		data[1][1] = 123;
		data[1][2] = 2;
		data[1][3] = 1050.0;
		data[1][4] = (float)50.0;
		data[1][5] = 940.0;
		data[1][6] = (float)60.0;
		data[1][7] = 1020.0;
		
		return Arrays.asList(data);
	}
	
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
		BankAccount account1 = new BankAccount(this.initialBalance, this.accNo, this.interest);
		double expectedBalance = this.BalanceAfterLodge;
		double actualBalance = account1.makeLodgement(this.Lodge);
		
		assertEquals(expectedBalance, actualBalance, 0.0);
	}

	@Test
	public void testMakeWithdrawal() {
		BankAccount account1 = new BankAccount(this.initialBalance, this.accNo, this.interest);

		double expectedBalance = this.BalanceAfterWith;
		double actualBalance = account1.makeWithdrawal(this.with);
		
		assertEquals(expectedBalance, actualBalance, 0.0);	}

	@Test
	public void testGetBalance() {
		BankAccount account1 = new BankAccount(this.initialBalance, this.accNo, this.interest);

		assertEquals(this.initialBalance, account1.getBalance(), 0.0);
	}

	@Test
	public void testAddInterest() {
		BankAccount account1 = new BankAccount(1000.0, 123, 2);
		
		double expected = this.expectedAfterInterest;
		
		account1.addInterest();
		
		assertEquals(expected, account1.getBalance(), 0.0);
	}

}