//http://www.tutorialspoint.com/java/java_thread_synchronization.htm
package JavaExamples;
class printDemo
{
	public void printCount()
	{
		try
		{
			for(int i = 5; i> 0; i--)
			{
				System.out.println("Counter -- " + i);
			}
		}
		catch(Exception Ex)
		{
			System.out.println("Thread interrupted..");
		}
	}
}

class ThreadDemo extends Thread
{
	private Thread t;
	private String threadName;
	printDemo pd;
	
	ThreadDemo(String name, printDemo PD)
	{
		threadName = name;
		pd = PD;
	}
	
	public void run()
	{
		synchronized(pd)
		{
			pd.printCount();
		}
		System.out.println("Thread exiting.." + threadName);
	}
	
	public void start()
	{
		System.out.println("Starting Thread.." + threadName);
		if(t == null)
		{
			t = new Thread(this, threadName);
			t.start();
		}
	}
}

public class ThreadSyncExample
{
	public static void main(String args[])
	{
		printDemo pd = new printDemo();
		ThreadDemo td1 = new ThreadDemo("1", pd);
		ThreadDemo td2 = new ThreadDemo("2", pd);
		td1.start();
		td2.start();
		
		try
		{
			td1.join();
			td2.join();
		}
		catch(Exception ex)
		{
			System.out.println("exception.." + ex.toString());
		}
	}
	
}