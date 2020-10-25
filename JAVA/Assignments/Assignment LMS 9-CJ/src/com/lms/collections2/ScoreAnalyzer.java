package com.lms.collections2;

import java.util.LinkedList;

public class ScoreAnalyzer {
	private LinkedList<Integer> runsData;

	public ScoreAnalyzer(LinkedList<Integer> runsData) {
		this.runsData = runsData;
	}
	
	public LinkedList<Integer> getRunsData() {
		return runsData;
	}

	public void setRunsData(LinkedList<Integer> runsData) {
		this.runsData = runsData;
	}

	public void addRunsToList(int runs)
	{
		runsData.add(runs);
	}
	public double calcRunRate()
	{
		double totalruns = 0;
		for(int i : runsData)
		{
			totalruns += i ;
		}
		double runrate = (totalruns/300)*6;
		return runrate;
	}
	public int lowestRunsScored()
	{
		int lowest = 999 ;
		for(int i : runsData)
		{
			if(i<lowest)
			{
				lowest = i ;
			}
		}
		return lowest;
	}
	public void displayRuns()
	{
		System.out.println("Runs :");
		for(int i : runsData)
		{
			System.out.println(i);
		}
	}
	
}
