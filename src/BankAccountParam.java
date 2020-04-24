import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BankAccountParam{

	private int accNo;
	private double balance;
	private int interest;
	private float lodgeValue;
	private double balanceAfterLodge;
	private float withValue;
	private double balanceAfterWith;
	private double balanceAfterInterest;
	
	
	public BankAccountParam(int accNo, double balance, int interest, float lodgeValue, double balanceAfterLodge,
			float withValue, double balanceAfterWith, double balanceAfterInterest) {
		super();
		this.accNo = accNo;
		this.balance = balance;
		this.interest = interest;
		this.lodgeValue = lodgeValue;
		this.balanceAfterLodge = balanceAfterLodge;
		this.withValue = withValue;
		this.balanceAfterWith = balanceAfterWith;
		this.balanceAfterInterest = balanceAfterInterest;
	}
	
	@Parameters
	public static Collection<Object[]> getData()
	{
		Object[][] data = new Object[2][8];
		
		data[0][0]=123;
		data[0][1]=(double)100;
		data[0][2]=2;
		data[0][3]=(float)120;
		data[0][4]=(double)220;
		data[0][5]=(float)20;
		data[0][6]=(double)80;
		data[0][7]=(double)102;
		
		data[1][0]=321;
		data[1][1]=(double)200;
		data[1][2]=4;
		data[1][3]=(float)120;
		data[1][4]=(double)320;
		data[1][5]=(float)20;
		data[1][6]=(double)180;
		data[1][7]=(double)204;
		
		return Arrays.asList(data);
	}

	@Test
	public void testMakeLodgement() {
		BankAccount account = new BankAccount(balance, this.accNo,this.interest);
		account.makeLodgement(this.lodgeValue);
		double actual = account.getBalance();
		assertEquals(this.balanceAfterLodge,actual,0.0);
	}

	@Test
	public void testMakeWithdrawal() {
		BankAccount account = new BankAccount(balance, this.accNo,this.interest);
		double actual = account.makeWithdrawal(this.withValue);
		assertEquals(this.balanceAfterWith,actual,0.0);
	}

	@Test
	public void testGetBalance() {
		BankAccount account = new BankAccount(balance, this.accNo,this.interest);
		double actual = account.getBalance();
		assertEquals(this.balance,actual,0.0);
	}

	@Test
	public void testAddInterest() {
		BankAccount account = new BankAccount(balance, this.accNo,this.interest);
		account.addInterest();
		double actual = account.getBalance();
		assertEquals(this.balanceAfterInterest,actual,0.0);
	}

}