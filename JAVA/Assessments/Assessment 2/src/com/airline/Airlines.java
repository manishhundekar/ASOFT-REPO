package com.airline;

public abstract class Airlines {

	private String airId;
	private String source;
	private String destination;
	
	public Airlines(String airId, String source, String destination) throws InvalidEntryException {
		if(airId.startsWith("BOEING") && !(source.equalsIgnoreCase(destination)))
		{
			this.airId = airId;
			this.source = source;
			this.destination = destination;
		}
		else
		{
			throw new InvalidEntryException("Invalid Airline ID or Source and Destination are same");
		}
	}
	
	
	public String getAirId() {
		return airId;
	}



	public void setAirId(String airId) {
		this.airId = airId;
	}



	public String getSource() {
		return source;
	}



	public void setSource(String source) {
		this.source = source;
	}



	public String getDestination() {
		return destination;
	}



	public void setDestination(String destination) {
		this.destination = destination;
	}



	public abstract void bookTicket( int noOfTickets);



	
	
}