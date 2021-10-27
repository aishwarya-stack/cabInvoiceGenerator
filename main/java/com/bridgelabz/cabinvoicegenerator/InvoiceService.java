package com.bridgelabz.cabinvoicegenerator;

public class InvoiceService {
	private static final double COST_PER_KM = 10;
	private static final double COST_PER_MIN = 1;
	private static final double MIN_FARE = 5.0;

	public double calculateFare(double distance, int time) {
		double totalFare = distance * COST_PER_KM + time * COST_PER_MIN;
		if (totalFare < MIN_FARE) {
			return MIN_FARE;
		}
		return totalFare;
	}

	public double calculateTotalFare(Ride[] rides) {
		double totalFare = 0.0;
		for (Ride ride : rides) {
			totalFare = calculateFare(ride.getDistance(), ride.getTime());
		}
		return totalFare;

	}

	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0.0;
		for (Ride ride : rides) {
			totalFare += calculateFare(ride.getDistance(), ride.getTime());
		}
		return new InvoiceSummary(rides.length, totalFare);

	}
}
