package com.bridgelabz.cabinvoicegenerator;


public class InvoiceService 
{
	private static final double COST_PER_KM = 10;
	private static final double COST_PER_MIN = 1;
	private static final double MIN_FARE = 5.0;

	/*
	 * Created a method to calculate the fare of journey
	 */
	public double CalculateFare(double distance, int time) {
		double totalFare = distance * COST_PER_KM + time * COST_PER_MIN;
		if (totalFare < MIN_FARE) {
			return MIN_FARE;
		}
		return totalFare;
	}

	public double calculateFare(Ride[] rides) {
		double totalFare = 0.0;
		for (Ride ride : rides) {
			totalFare = CalculateFare(ride.getDistance(), ride.getTime());
		}
		return totalFare;
	}
}
