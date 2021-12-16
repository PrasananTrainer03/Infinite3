package com.java.lamb;

import java.util.ArrayList;
import java.util.List;

public class StreamExample4 {

	public static void main(String[] args) {
		List<Employ> list=new ArrayList<Employ>();  
		list.add(new Employ(1, "Jaison", 99423));
		list.add(new Employ(2, "Chandra Sekhar", 89432));
		list.add(new Employ(3, "Sunil", 91144));
		list.add(new Employ(4, "Kavyasri", 89744));
		list.add(new Employ(5, "Dinesh", 88994));
		
		 Employ emp1 = list.stream().max((e1, e2)->e1.basic > e2.basic ? 1 : -1).get();  
		 System.out.println("Maximum Basic  " +emp1.basic);
		 
		 Employ emp2 = list.stream().min((e1, e2)->e1.basic > e2.basic ? 1 : -1).get();  
		 System.out.println("Minimum Basic  " +emp2.basic);
	}
}
