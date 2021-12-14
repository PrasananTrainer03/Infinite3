package com.java.gen;

import java.util.Comparator;

public class BasicComparator implements Comparator<Employ> {

	@Override
	public int compare(Employ o1, Employ o2) {
		if (o1.basic >= o2.basic) {
			return 1;
		} else {
			return -1;
		}
	}

}
