package JavaExamples;

interface InterfaceEx {
	public String hello = "Hello";

	public void DisplayMessage();
}

public class InterfaceExample implements InterfaceEx {
	public void DisplayMessage() {
		System.out.println("In Class A Display");
	}

	public static void main(String args[]) {
		InterfaceExample a = new InterfaceExample();
		a.DisplayMessage();
	}
}
