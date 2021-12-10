
public class EmployArray {

	public static void main(String[] args) {
		Employ[] arrEmploy = new Employ[] {
			new Employ(1, "Vamshi", 99952),
			new Employ(2, "Dinesh", 48585),
			new Employ(3, "Kavyasree", 99924),
			new Employ(4, "Praveen", 88422)
		};
		
		for (Employ employ : arrEmploy) {
			System.out.println(employ);
		}
	}
}
