package com.custom;

public class TestCustomer {

	public static void main(String[] args) {
		System.out.println("START");
		//1
		Customer customer = new Customer("C123", "Ramesh","Silver");
		customer.showDetails();
		//2 !Starting with C or c
		Customer customer1 = new Customer("D123", "Ramesh","Silver");
		customer1.showDetails();
		//3 Customer Name Length
		Customer customer2 = new Customer("D123", "Ra","Silver");
		customer2.showDetails();
		//4 Category Bronze is Invalid
		Customer customer3 = new Customer("D123", "Ramesh","Bronze");
		customer3.showDetails();
		System.out.println("END");
	}

}
