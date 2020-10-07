package base;

import basetwo.Address;
import basetwo.Customer;

class Address{
	private String addressLine;
	private String city;
	
	
	public Address(String addressLine, String city) {
		this.addressLine = addressLine;
		this.city = city;
	}
	
	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	//Methods
	
	String getAddressDetails()
	{
		return this.addressLine + "," + this.city;
	}
	
}

class Customer{
	private String customerName;
	private Address residentialAddress;
	
	public Customer(){}

	public Customer(String customerName, Address residentialAddress) {
		this.customerName = customerName;
		this.residentialAddress = residentialAddress;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Address getResidentialAddress() {
		return residentialAddress;
	}

	public void setResidentialAddress(Address residentialAddress) {
		this.residentialAddress = residentialAddress;
	}
	
	String getCustomerDetails()
	{
		return "Customer : " + this.customerName + "\nResidential Address : " + this.residentialAddress.getAddressDetails() ;
	}
}


public class AggregationEncapsulation {

	public static void main(String[] args) {
		//obj1
		Customer customer = new Customer();
		customer.setCustomerName("John");
		Address add = new Address("Ist Main HSR Layout","Bangalore");
		customer.setResidentialAddress(add);
		System.out.println(customer.getCustomerDetails());
		
		//obj2
		Customer customer1 = new Customer("John",add);
		System.out.println(customer1.getCustomerDetails());
	
	}

}