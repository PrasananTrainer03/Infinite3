package com.java.lamb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StreamExample1 {

	public static void main(String[] args) {
		List<Employ> list=new ArrayList<Employ>();  
		list.add(new Employ(1, "Jaison", 99423));
		list.add(new Employ(2, "Chandra Sekhar", 89432));
		list.add(new Employ(3, "Sunil", 91144));
		list.add(new Employ(4, "Kavyasri", 89744));
		list.add(new Employ(5, "Dinesh", 88994));
		list.add(new Employ(6, "Shahida", 93423));
		
		Collections.sort(list, (e1,e2) -> {
			return e1.name.compareTo(e2.name);
		});
		
		System.out.println("Sorted Data  ");
		
		list.forEach(System.out::println);
		
		System.out.println("Sort By Salary...");
		
		Collections.sort(list, (e1,e2) -> {
			return (int) ((int)e2.basic - e1.basic);
		});
		
		list.forEach(System.out::println);
		
	}
}
