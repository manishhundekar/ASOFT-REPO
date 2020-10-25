package com.airline;

public class Domestic extends Airlines{
	
	private String zonalCode;
	private double ticketCost = 0;
	
	public Domestic(String airId, String source, String destination, String zonalCode)
			throws InvalidEntryException {
		super(airId, source, destination);
		if(zonalCode.equals("Z001") || zonalCode.equals("Z002") || zonalCode.equals("Z003"))
		{
			this.zonalCode = zonalCode;
		}
		else
		{
			throw new InvalidEntryException("Invalid Zonal Code");
		}
	}

	public String getZonalCode() {
		return zonalCode;
	}

	public void setZonalCode(String zonalCode) {
		this.zonalCode = zonalCode;
	}

	public double getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(double ticketCost) {
		this.ticketCost = ticketCost;
	}

	@Override
	public void bookTicket(int noOfTickets) {
		if(this.zonalCode.equalsIgnoreCase("Z001"))
		{
			this.ticketCost += 3500.00 * noOfTickets;
		}
		else if(this.zonalCode.equalsIgnoreCase("Z002"))
		{
			this.ticketCost += 4000.00 * noOfTickets;
		}
		else if(this.zonalCode.equalsIgnoreCase("Z003"))
		{
			this.ticketCost += 4500.00 * noOfTickets;
		}
		System.out.println(this.ticketCost);
	}

}
