package com.assignment.PatientList;

public class Patient implements Comparable<Patient>{

	@Override
	public int compareTo(Patient o) {
		return this.patientID - o.getPatientID();
		//return o.getPatientID() - this.patientID;
	}
	private int patientID;
	private String name;
	private int age;
	public Patient(int patientID, String name, int age) {
		this.patientID = patientID;
		this.name = name;
		this.age = age;
	}
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString()
	{
		return "Patient ID : " + getPatientID() + " \tName : " + getName() + "\tAge : " + getAge();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + patientID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (patientID != other.patientID)
			return false;
		return true;
	}
	
	
}
