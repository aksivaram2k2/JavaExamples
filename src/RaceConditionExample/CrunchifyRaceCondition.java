package RaceConditionExample;

import RaceConditionExample.CrunchifyTransaction.TransactionType;
//http://crunchify.com/have-you-noticed-race-condition-in-java-multithreading-concurrency-example-how-to-deal-with-it/

public class CrunchifyRaceCondition
{
	public static void main(String args[])
	{
		CrunchifyBankAccount CAccount = new CrunchifyBankAccount("SSAccountNmber");
		
		//Deposit Money
		for(int i = 0 ; i < 600; i ++)
		{
			CrunchifyTransaction cTrans = new CrunchifyTransaction(CAccount, TransactionType.DEPOSIT_MONEY, 100);
			cTrans.start();
		}
		
		//Total Withdrawal
		for(int i = 0; i < 500; i++)
		{
			CrunchifyTransaction cTrans = new CrunchifyTransaction(CAccount, TransactionType.WITHDRAW_MONEY, 50);
			cTrans.start();
		}
		
		try
		{
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		
		System.out.println("Final Balance is " + CAccount.getAccountBalance());
	}
}

