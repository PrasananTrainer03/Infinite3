package com.java.ex;

import java.util.ArrayList;
import java.util.List;

public class ListEmploy {
	public static void main(String[] args) {
		List employList = new ArrayList();
		employList.add(new Employ(1, "Omkar", 84823));
		employList.add(new Employ(2, "Suchita", 90844));
		employList.add(new Employ(3, "Vamshi", 91142));
		employList.add(new Employ(4, "Shahida", 89988));
		employList.add(new Employ(5, "Harish", 91043));
		employList.add(new Employ(6, "Mohammad", 90843));
		
		for (Object ob : employList) {
			Employ employ = (Employ)ob;
			System.out.println(employ);
		}
	}
}
