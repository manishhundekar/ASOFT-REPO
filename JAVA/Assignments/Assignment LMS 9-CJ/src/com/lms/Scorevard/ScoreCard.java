package com.lms.Scorevard;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class ScoreCard {

	public static void main(String[] args) {

		HashMap<String,Integer> scorecard = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number of Scores");
		int n = sc.nextInt(); sc.nextLine();
		for(int i =0 ; i<n ; i++)
		{
			scorecard.put(sc.nextLine(), sc.nextInt());
			sc.nextLine();
		}
		sc.close();
		//Key Set
		Set<String> batsman = scorecard.keySet();
		System.out.println("Players who batted : ");
		for(String s : batsman)
		{
			System.out.println(s);
		}
		//
		System.out.println("Scores by Players : ");
		int totalscores = 0,maxscore=0;
		String maximumRunScorer = null;
		for(String s : batsman)
		{
			int value = scorecard.get(s);
			System.out.println(s + " : " + value);
			totalscores += value;
			if(value > maxscore) {maxscore = value; maximumRunScorer = s;};
		}
		System.out.println("Total Score : " + totalscores);
		System.out.println("Maximum Run Scorer " + maximumRunScorer );
		System.out.println("Runs Scored by Dhoni " + scorecard.get("Dhoni") );
		//
		
	}

}
