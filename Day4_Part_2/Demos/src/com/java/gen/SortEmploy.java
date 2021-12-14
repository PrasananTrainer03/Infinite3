package com.java.gen;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;


public class SortEmploy {

	public static void main(String[] args) {
		Comparator<Employ> c = new BasicComparator();
		// Comparator<Employ> c = new NameComparator();
		SortedSet<Employ> names = new TreeSet<Employ>(c);
		names.add(new Employ(7, "Kamesh", 91823));
		names.add(new Employ(8, "Madhukumar", 90844));
		names.add(new Employ(1, "Omkar", 84823));
		names.add(new Employ(2, "Suchita", 90844));
		names.add(new Employ(3, "Vamshi", 91142));
		names.add(new Employ(4, "Shahida", 89988));
		names.add(new Employ(5, "Harish", 91043));
		names.add(new Employ(6, "Mohammad", 90843));
		
		for (Employ e : names) {
			System.out.println(e);
		}
	}
}
