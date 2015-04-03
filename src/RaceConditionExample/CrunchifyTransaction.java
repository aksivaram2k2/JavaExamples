package RaceConditionExample;
//http://crunchify.com/have-you-noticed-race-condition-in-java-multithreading-concurrency-example-how-to-deal-with-it/

public class CrunchifyTransaction extends Thread
{
	public static enum TransactionType
	{
		DEPOSIT_MONEY(1),
		WITHDRAW_MONEY(2);
		private TransactionType(int value){}
	};
	
	private TransactionType transactionType;
	private CrunchifyBankAccount bankAccount;
	private double Amount;
	
	public CrunchifyTransaction(CrunchifyBankAccount bankAccount, TransactionType transactionType, double Amount)
	{
		this.transactionType = transactionType;
		this.Amount = Amount;
		this.bankAccount = bankAccount;
	}
	
	public void run()
	{
		switch(this.transactionType)
		{
			case DEPOSIT_MONEY:
				depositAmount();
				printBalance();
				break;
			case WITHDRAW_MONEY:
				withdrawAmount();
				printBalance();
				break;
			default:
				System.out.println("Not a valid transaction");
		}
	}
	
	public void depositAmount()
	{
		this.bankAccount.depositAmount(this.Amount);
	}
	
	public void withdrawAmount()
	{
		this.bankAccount.withdrawAmount(Amount);
	}
	
	public void printBalance()
	{
		System.out.println("Thread name is " + Thread.currentThread().getName() + " : Transaction Type "  +this.transactionType + ", Anmount is "+ this.Amount);
		System.out.println("Account Number is " + this.bankAccount.getAccountNumber());
		System.out.println("Account Balance is " + this.bankAccount.getAccountBalance());
	}
}

