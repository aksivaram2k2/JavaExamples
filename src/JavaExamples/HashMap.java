package JavaExamples;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
public class HashMap
{
	public static void main(String[] args)
	{
		HashMap<String, Integer> cache = new HashMap<String, Integer>();
		cache.put("Two", 2);
		cache.put("Three", 3);
		System.out.println(cache.containsKey("Two"));
		System.out.println(cache.size());
		Set<String> setOfKeys = cache.keySet();
		Iterator iterator = setOfKeys.iterator();
		while(iterator.hasNext())
		{
			String key = (String) iterator.next();
			Integer value = (Integer)cache.get(key);
			System.out.println("Key: "+ key+", Value: "+ value);
		}
	}
}