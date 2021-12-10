
public class StrExamples {

	public void show() {
		String str="Welcome to Java Programming...";
		System.out.println("Length of String is   " +str.length());
		System.out.println("char at 5th position   " +str.charAt(5));
		System.out.println("Upper Case  " +str.toUpperCase());
		System.out.println("Lower Case  " +str.toLowerCase());
		String s1="Prasanna",s2="Harish",s3="Prasanna";
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s1.compareTo(s2));
		System.out.println(s1.compareTo(s3));
		System.out.println(str.replace("Java", "J2EE"));
	}
	public static void main(String[] args) {
		StrExamples obj = new StrExamples();
		obj.show();
	}
}
