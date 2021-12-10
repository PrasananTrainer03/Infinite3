
public class Details {

	int empno;
	String name;
	double basic;
	
	

	@Override
	public String toString() {
		return "Details [empno=" + empno + ", name=" + name + ", basic=" + basic + "]";
	}



	public static void main(String[] args) {
		Details obj1 = new Details();
		obj1.empno=1;
		obj1.name="Shahida";
		obj1.basic=84822;
		
		System.out.println(obj1);
		
		Details obj2 = new Details();
		obj2.empno=3;
		obj2.name="Sumanth";
		obj2.basic=88422;
		
		System.out.println(obj2);
	}
}
