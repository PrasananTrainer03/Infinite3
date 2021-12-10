
public class ConEx {

	int a,b;
	
	ConEx() {
		a=5;
		b=8;
	}
	
	ConEx(int a, int b) {
		this.a=a;
		this.b=b;
	}
	
	@Override
	public String toString() {
		return "ConEx [a=" + a + ", b=" + b + "]";
	}

	public static void main(String[] args) {
		ConEx obj1 = new ConEx();
		System.out.println(obj1);
		
		ConEx obj2 = new ConEx(45, 42);
		System.out.println(obj2);
	}
}
