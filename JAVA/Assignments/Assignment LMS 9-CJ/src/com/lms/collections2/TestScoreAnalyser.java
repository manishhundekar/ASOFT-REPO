package com.lms.collections2;

import java.util.LinkedList;
import java.util.Scanner;

public class TestScoreAnalyser {

	public static void main(String[] args) {
		ScoreAnalyzer sa = new ScoreAnalyzer(new LinkedList<>());
		Scanner sc = new Scanner(System.in);
		System.out.println("Number of Runs : ");
		int n = sc.nextInt();
		for(int i=0 ; i<n ; i++)
		{
			sa.addRunsToList(sc.nextInt());
		}
		sa.displayRuns();
		System.out.println("Runrate : " + sa.calcRunRate());
		System.out.println("Lowest : " + sa.lowestRunsScored());
		System.out.println("Count of Player who batted : " + sa.getRunsData().size());
		sc.close();
	}

}
