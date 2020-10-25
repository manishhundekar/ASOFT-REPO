package com.airline;

public class International extends Airlines{
	
	private String countryCode;
	private double ticketCost = 0;
	
	public International(String airId, String source, String destination, String countryCode)
			throws InvalidEntryException {
		super(airId, source, destination);
		if(countryCode.equals("I001") || countryCode.equals("I002") || countryCode.equals("I003"))
		{
			this.countryCode = countryCode;
		}
		else
		{
			throw new InvalidEntryException("Invalid Zonal Code");
		}
	}

	public String getcountryCode() {
		return countryCode;
	}

	public void setcountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public double getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(double ticketCost) {
		this.ticketCost = ticketCost;
	}

	@Override
	public void bookTicket(int noOfTickets) {
	
		if(countryCode.equalsIgnoreCase("I001"))
		{
			this.ticketCost += 25000.00 * noOfTickets;
		}
		else if(countryCode.equalsIgnoreCase("I002"))
		{
			this.ticketCost += 36000.00 * noOfTickets;
		}
		else if(countryCode.equalsIgnoreCase("I003"))
		{
			this.ticketCost += 38000.00 * noOfTickets;
		}
		System.out.println(this.ticketCost);
	}
}
