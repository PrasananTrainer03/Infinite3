
public class BoxRun {
	
	public void show(Object ob) {
		String type = ob.getClass().getSimpleName();
		//System.out.println(type);
		if (type.equals("Integer")) {
			System.out.println("Integer Casting  ");
			int x = (Integer)ob;
			System.out.println(x);
		}
		if (type.equals("Double")) {
			System.out.println("Double Casting  ");
			double x = (Double)ob;
			System.out.println(x);
		}
		
		if (type.equals("String")) {
			System.out.println("String Casting...");
			String x = (String)ob;
			System.out.println(x);
		}
	}
	
	public static void main(String[] args) {
		int a=12;
		double b=12.5;
		String name="Basin";
		BoxRun obj = new BoxRun();
		obj.show(a);
		obj.show(b);
		obj.show(name);
	}
}
