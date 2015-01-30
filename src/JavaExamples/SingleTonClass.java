//http://examplesofjava.com/statickeyword/singleton-example.html
package JavaExamples;
public class SingletonClass
{
	static SingletonClass singleton = null;
	
	private SingletonClass()
	{
	
	}
	
	public static SingletonClass getInstance()
	{
		if(singleton == null)
		{
			singleton = new SingletonClass();
			return singleton;
		}
		return singleton;
	}
	
	public static class SingleTonExample
	{
		public static void main(String args[])
		{
			SingletonClass S1 = SingletonClass.getInstance();
			SingletonClass S2 = SingletonClass.getInstance();
			
			if(S1 == S2)
			{
				System.out.println("Equal Objects");
			}
		}
	}
}