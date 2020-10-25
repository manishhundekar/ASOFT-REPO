package com.custom;

public class Customer {

	private String custNo;
	private String custName;
	private String category;
	
	public Customer() {}

	public Customer(String custNo, String custName, String category) {
		try
		{
			if(custNo.startsWith("C") || custNo.startsWith("c"))
			{
				if(custName.length() >= 4)
				{
					if(category.equals("Platinum") || category.equals("Gold") || category.equals("Silver"))
					{
						this.custNo = custNo;
						this.custName = custName;
						this.category = category;
					}
					else
					{
						throw new InvalidInputException();
					}
				}
				else
				{
					throw new InvalidInputException();
				}
			}
			else
			{
				throw new InvalidInputException();
			}
		}
		catch(InvalidInputException iie)
		{
			iie.printStackTrace();
		}
		
		
	}
	
	public String getCustNo() {
		return custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void showDetails()
	{
		System.out.println("Customer Number :" + getCustNo() + "\nCustomer Name : " + getCustName() + "\nCategory : " + getCategory() );
	}

}
