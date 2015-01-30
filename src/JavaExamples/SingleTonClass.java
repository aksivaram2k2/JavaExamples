//http://examplesofjava.com/statickeyword/singleton-example.html
package JavaExamples;
public class SingleTonClass
{
	static SingleTonClass singleton = null;
	
	private SingleTonClass()
	{
	
	}
	
	public static SingleTonClass getInstance()
	{
		if(singleton == null)
		{
			singleton = new SingleTonClass();
			return singleton;
		}
		return singleton;
	}
	
	public static class SingleTonExample
	{
		public static void main(String args[])
		{
			SingleTonClass S1 = SingleTonClass.getInstance();
			SingleTonClass S2 = SingleTonClass.getInstance();
			
			if(S1 == S2)
			{
				System.out.println("Equal Objects");
			}
		}
	}
}