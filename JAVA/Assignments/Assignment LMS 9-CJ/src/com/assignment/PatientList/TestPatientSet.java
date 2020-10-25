package com.assignment.PatientList;

import java.util.LinkedHashSet;

public class TestPatientSet {

	public static void main(String[] args) {
		LinkedHashSet<Patient> patientSet = new LinkedHashSet<>();
		Patient pat1 = new Patient(100,"Rahul",28);
		Patient pat2 = new Patient(121,"Mahesh",35);
		Patient pat3 = new Patient(151,"Anup",22);
		Patient pat4 = new Patient(100,"Rahul",28);
		patientSet.add(pat2);
		patientSet.add(pat3);
		patientSet.add(pat1);
		patientSet.add(pat1);
		
		System.out.println(patientSet);
		System.out.println(pat1.equals(pat4));
	}

}
