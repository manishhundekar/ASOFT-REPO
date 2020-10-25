package com.lms.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentMarks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> studentmarks = new ArrayList<>();
		System.out.println("Enter the Number of Students : ");
		int n = sc.nextInt();
		System.out.println("Enter Marks : ");
		for(int i=0 ; i<n ; i++)
		{
			studentmarks.add(sc.nextInt());
		}
		int sum=0;
		for(int i : studentmarks)
		{
			sum += i ;
		}
		System.out.println("Highest Marks : " + Collections.max(studentmarks));
		System.out.println("Average Marks : " + sum/n);
		System.out.println("Marks : " + studentmarks);
		System.out.println("3rd Student marks : " + studentmarks.get(2));
		Collections.sort(studentmarks);
		System.out.println("Sorted : " + studentmarks);
		sc.close();
	}

}
