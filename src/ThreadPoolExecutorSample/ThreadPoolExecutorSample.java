//http://www.coderpanda.com/threadpoolexecutor-in-java/
package ThreadPoolExecutorSample;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorSample
{
	public ThreadPoolExecutorSample()
	{
		
	}
	
	public static void main(String args[])
	{
		Runnable firstTask = new Runnable() 
		{
			int number = 0;
			public void run() 
			{
				while(number < 50)
				{
					System.out.println("Thread :" + Thread.currentThread().getName() + " Number" + number);
					number = number+10;
				}
				try
				{
					Thread.sleep(5000);
				}
				catch(Exception Ex)
				{
					
				}
			}
		};
		
		Runnable secondTask = new Runnable() {
			int number = 50;
			public void run() 
			{
				while(number < 100)
				{
					System.out.println("Thread is :" + Thread.currentThread().getName() + " , Number" + number);
					number = number+10;
					
				}
				try
				{
					Thread.sleep(5000);
				}
				catch(Exception Ex)
				{
					
				}
				
			}
		};
		
		Runnable thirdTask = new Runnable() {
			int number = 100;
			public void run() {
				while(number < 150)
				{
					System.out.println("Thread Name " + Thread.currentThread().getName() + " Number = " + number);
					number = number + 10;
					try
					{
						Thread.sleep(5000);
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
				}
				
			}
		};
		
		Runnable fourthTask = new Runnable() {
			int number = 200;
			public void run() {
				while(number < 250)
				{
					System.out.println("Thread Name " + Thread.currentThread().getName() + " Number = " + number);
					number = number + 10;
					try
					{
						Thread.sleep(5000);
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
				}
				
			}
		};
		
		LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
		//Run 1
		System.out.println("Run 1"); 
		ThreadPoolExecutor executorService = new ThreadPoolExecutor(2, 2, 10, TimeUnit.SECONDS, queue);
		executorService.execute(firstTask);
		executorService.execute(secondTask);
		executorService.execute(thirdTask);
		executorService.execute(fourthTask);

		
	}
}