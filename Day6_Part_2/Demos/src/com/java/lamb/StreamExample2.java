package com.java.lamb;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample2 {

	public static void main(String[] args) {
		List<Employ> list=new ArrayList<Employ>();  
		list.add(new Employ(1, "Jaison", 99423));
		list.add(new Employ(2, "Chandra Sekhar", 89432));
		list.add(new Employ(3, "Sunil", 91144));
		list.add(new Employ(4, "Kavyasri", 89744));
		list.add(new Employ(5, "Dinesh", 88994));
		list.add(new Employ(6, "Shahida", 93423));
		
		Stream<Employ> filter_data = list.stream().filter(e -> e.basic >= 90000);
		System.out.println("Filtered Data ");
		
		filter_data.forEach(System.out::println);
	}
}
