package com.java.lamb;

import java.util.ArrayList;
import java.util.List;

public class StreamExample3 {

	public static void main(String[] args) {
		List<Employ> list=new ArrayList<Employ>();  
		list.add(new Employ(1, "Jaison", 99423));
		list.add(new Employ(2, "Chandra Sekhar", 89432));
		list.add(new Employ(3, "Sunil", 91144));
		list.add(new Employ(4, "Kavyasri", 89744));
		list.add(new Employ(5, "Dinesh", 88994));
//		sum=0;
//		sum+=e.basic;
		 double totalSalary = list.stream()  
                 .map(x->x.basic)  
                 .reduce(0.0,(sum, basic)->sum+basic);  
		 System.out.println("Total Salary  " +totalSalary);
	}
}
