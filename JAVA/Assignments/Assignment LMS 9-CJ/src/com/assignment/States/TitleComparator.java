package com.assignment.States;

import java.util.Comparator;

public class TitleComparator implements Comparator<String>
{

	@Override
	public int compare(String s1, String s2) {
		return s1.compareTo(s2);
	}
	
}
