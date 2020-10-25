package com.assignment.PatientList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TestPatientList {

	static int getPatientAge(String name,TreeSet<Patient> tree)
	{
		for(Patient p : tree)
		{
			if(p.getName().equalsIgnoreCase(name))
			{
				return p.getAge();
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Patient pat1 = new Patient(100,"Rahul",28);
		Patient pat2 = new Patient(121,"Mahesh",35);
		Patient pat3 = new Patient(151,"Anup",22);
		
		ArrayList<Patient> patientList = new ArrayList<>();
		patientList.add(pat1);
		patientList.add(pat2);
		patientList.add(pat3);
		
		//COMPARABLE -- Overrides compareTO()
		System.out.println("---------Sort w.r.t ID (Comparable)--------");
		Collections.sort(patientList);
		for(Patient p : patientList)
		{
			System.out.println(p);
		}
		//COMPARATOR -- Overrides compare()
		//System.out.println(patientList);
		//Based on Name - Approach 1
		System.out.println("---------Sort w.r.t Name--------");
		patientList.sort(new PatientNameComparator());
		for(Patient p : patientList)
		{
			System.out.println(p);
		}
		//Based on Age
		System.out.println("-------------Sort w.r.t Age-----------");
		Comparator<Patient> comp = Comparator.comparing(Patient::getAge);
		patientList.sort(comp);
		
		//Using Iterator
		Iterator<Patient> it = patientList.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		
		//Treeset
		System.out.println("-------------TreeSet-----------");
		TreeSet<Patient> tset = new TreeSet<>();
		tset.add(pat1);
		tset.add(pat2);
		tset.add(pat3);
		tset.add(pat3); // Duplicate
		
		System.out.println(tset);
		System.out.println(getPatientAge("mahesh",tset)); // 35
		
	}

}
