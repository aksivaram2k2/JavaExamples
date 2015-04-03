package RaceConditionExample;
//http://crunchify.com/have-you-noticed-race-condition-in-java-multithreading-concurrency-example-how-to-deal-with-it/

public class CrunchifyBankAccount
{
	private String AccountNumber;
	private double AccountBalance;
	
	public String getAccountNumber()
	{
		return AccountNumber;
	}
	
	public double getAccountBalance()
	{
		return AccountBalance;
	}
	
	public CrunchifyBankAccount(String AccountNumber)
	{
		this.AccountNumber = AccountNumber;
	}
	
	//Single usage lock using synchronized
	//
	public synchronized boolean  depositAmount(double amount)
	{
		if(amount < 0)
			return false;
		else
			AccountBalance += amount;
			return true;
	}
	
	//Single usage lock using synchronized
	//synchronized
	public synchronized boolean  withdrawAmount(double amount)
	{
		if(amount > AccountBalance)
			return false;
		else
			AccountBalance = AccountBalance - amount;
			return true;
	}
}

