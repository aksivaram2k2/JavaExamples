//http://examplesofjava.com/arraylist/arraylist-example.html
package JavaExamples;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
public class ArrayListExample
{
	public static void main(String args[])
	{
		List list = new ArrayList();
		list.add("ListItemOne");
		list.add("ListItemTwo");
		list.add("ListItemThree");
		list.add("ListItemFour");
		
		Iterator itr = list.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}
}