//http://examplesofjava.com/string/string-split-example.html
package JavaExamples;
public class StringExample
{
	public static void main(String args[])
	{
		String str = "One,Two,Three,Four,Five";
		String[] splitstr = str.split(",");
		for(String st : splitstr)
		{
			System.out.println(st);
		}
	}
}