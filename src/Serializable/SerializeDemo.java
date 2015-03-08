package Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeDemo
{
	public static void main(String args[])
	{
		SerializationExample Example = new SerializationExample();
		Example.setColor("Black");
		Example.setName("Bull Dog");
		Example.setweight(100);
		try
		{
			FileOutputStream fileOut = new FileOutputStream("./out.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(Example);
			out.close();
			fileOut.close();
		}
		catch(IOException i)
		{
			i.printStackTrace();
		}
		
		Example = null;
		
		try
		{
			FileInputStream filein = new FileInputStream("./out.ser");
			ObjectInputStream in = new ObjectInputStream(filein);
			Example = (SerializationExample) in.readObject();
			in.close();
			filein.close();
		}
		catch(IOException i)
		{
			i.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("Class not found");
			e.printStackTrace();
		}
		
		System.out.println("Output");
		System.out.println("Name" +Example.getName());
		System.out.println("Color" + Example.getColor());
		System.out.println("Weight" + Example.getweight());
	}
}