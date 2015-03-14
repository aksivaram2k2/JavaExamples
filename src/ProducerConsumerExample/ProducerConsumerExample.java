package ProducerConsumerExample;
//http://crunchify.com/java-producer-consumer-example-handle-concurrent-read-write/
import java.util.Vector;
import java.util.Iterator;

public class ProducerConsumerExample
{
	private static Vector<Object> data = new Vector<Object>();
	
	public static void main(String args[])
	{
		new  Producer().start();
		new  Consumer().start();
	}
	
	public static class Producer extends Thread
	{
		Producer()
		{
			super("Producer");
		}
		
		@Override
		public void run()
		{
			for(;;)
			{
				try
				{
					Thread.sleep(1);
				}
				catch(Exception Ex)
				{
					
				}
				
				data.add(new Object());
				if(data.size() > 1000)
				{
					data.remove(data.size()-1);
					
				}
			}
		}
	}
	
	public static class Consumer extends Thread
	{
		Consumer()
		{
			super("Consumer");
		}
		
		@Override
		public void run()
		{
			for(;;)
			{
				try
				{
					Thread.sleep(1);
				}
				catch(Exception Ex)
				{
					
				}
				
				//@SuppressWarnings("rawtypes")
				synchronized(data)
				{
					Iterator it = data.iterator();
					while(it.hasNext())
					{
						it.next();
					}
				}
			}
		}
	}
}
