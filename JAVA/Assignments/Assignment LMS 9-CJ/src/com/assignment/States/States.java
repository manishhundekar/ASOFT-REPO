package com.assignment.States;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;


public class States {

	public static void main(String[] args) throws IOException {
		
		//BufferedInputStream bis = BufferedInputStream(new FileInputStream(new File("states.txt")));
		//BufferedReader br = new BufferedReader(new FileReader(new File("states.txt")));
		LinkedHashSet<String> stateSet = new LinkedHashSet<>();
		Scanner sc = new Scanner(new FileReader(new File("states.txt")));
		while(sc.hasNext())
		{
			stateSet.add(sc.nextLine());
		}
		sc.close();
		
		System.out.println("States List :" + stateSet);
		
		//REMOVE DELHI
		
		stateSet.remove("Delhi");
		System.out.println("States List :" + stateSet);
		
		//States starting with K
		System.out.println("States starting with K :");
		for(String str : stateSet)
		{
			if(str.startsWith("K"))
			{
				System.out.println(str);
			}
		}
		
		//SORTED
		//TreeSet<String> statesset2 = new TreeSet<>(new TitleComparator());
		TreeSet<String> statesset2 = new TreeSet<>();
		statesset2.addAll(stateSet);
		System.out.println(statesset2);
	}

}
