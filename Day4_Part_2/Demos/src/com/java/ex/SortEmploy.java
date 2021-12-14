package com.java.ex;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortEmploy {

	public static void main(String[] args) {
	//	Comparator c = new NameComparator();
		Comparator c = new BasicComparator();
		SortedSet employs = new TreeSet(c);
		employs.add(new Employ(7, "Kamesh", 91823));
		employs.add(new Employ(8, "Madhukumar", 90844));
		employs.add(new Employ(1, "Omkar", 84823));
		employs.add(new Employ(2, "Suchita", 90844));
		employs.add(new Employ(3, "Vamshi", 91142));
		employs.add(new Employ(4, "Shahida", 89988));
		employs.add(new Employ(5, "Harish", 91043));
		employs.add(new Employ(6, "Mohammad", 90843));
		
		System.out.println("Employ List   ");
		for (Object ob : employs) {
			Employ employ = (Employ)ob;
			System.out.println(employ);
		}
	}
}
