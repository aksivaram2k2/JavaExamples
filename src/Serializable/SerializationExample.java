//http://www.programcreek.com/2014/01/java-serialization/
package Serializable;
import java.io.Serializable;
public class SerializationExample implements Serializable
{
	public static final long serialVersionUID  = -5742822984616863149L;
	
	private String name;
	private String color;
	private transient int weight;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getColor()
	{
		 return color;
	}
	
	public void setColor(String color)
	{
		this.color = color;
	}
	
	public int getweight()
	{
		 return weight;
	}
	
	public void setweight(int weight)
	{
		this.weight = weight;
	}
}