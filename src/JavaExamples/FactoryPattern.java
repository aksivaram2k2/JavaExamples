package JavaExamples;

interface IClientProperty {
	public String SetRegion();
}

class APACProperty implements IClientProperty {
	String regionLocation;

	public String SetRegion() {
		regionLocation = "APAC";
		System.out.println(regionLocation);
		return regionLocation;
	}
}

class USProperty implements IClientProperty {
	String regionLocation;

	public String SetRegion() {
		regionLocation = "US";
		System.out.println(regionLocation);
		return regionLocation;
	}
}

public class FactoryPattern {
	public static void main(String args[]) {
		FactoryPattern program = new FactoryPattern();
		IClientProperty objBase = program.GetObject("US");

		FactoryPattern program2 = new FactoryPattern();
		IClientProperty objBase2 = program2.GetObject("APAC");

		System.out.println("Result One is :" + objBase.SetRegion());
		System.out.println("\nResult Two is :" + objBase2.SetRegion());

	}

	public IClientProperty GetObject(String Region) {

		IClientProperty objBase = null;

		if (Region.equals("US")) {
			objBase = new USProperty();
		} else if (Region.equals("APAC")) {
			objBase = new APACProperty();
		}
		return objBase;
	}
}