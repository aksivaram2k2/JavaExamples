//http://tutorials.jenkov.com/java-concurrency/synchronized.html
//Only one thread at a time will be able to call the add method 

package JavaExamples;
class Counter
{
	long count = 0;
	public synchronized void add(long value)
	{
		this.count +=value;
		System.out.println("Counter value is " + Long.toString(value));
	}
}

class CounterThread extends Thread
{
	protected Counter counter = null;
	public CounterThread (Counter counter)
	{
		this.counter = counter;
	}
	
	public void run()
	{
		for(int i = 0; i < 10; i++)
		{
			counter.add(i);
		}
	}
}

public class ThreadsExample
{
	public static void main(String args[])
	{
		Counter counter = new Counter();
		Thread threadA = new CounterThread(counter);
		Thread threadB = new CounterThread(counter);
		threadA.start();
		threadB.start();
		
	}
}