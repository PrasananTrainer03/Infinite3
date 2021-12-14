package com.java.gen;

import java.util.ArrayList;
import java.util.List;

import com.java.ex.Employ;

public class GenEmployList {

	public static void main(String[] args) {
		List<Employ> employList = new ArrayList<Employ>();
		employList.add(new Employ(1, "Omkar", 84823));
		employList.add(new Employ(2, "Suchita", 90844));
		employList.add(new Employ(3, "Vamshi", 91142));
		employList.add(new Employ(4, "Shahida", 89988));
		employList.add(new Employ(5, "Harish", 91043));
		employList.add(new Employ(6, "Mohammad", 90843));
		
		for (Employ e : employList) {
			System.out.println(e);
		}
	}
}
