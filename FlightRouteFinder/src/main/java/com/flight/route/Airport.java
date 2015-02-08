package com.flight.route;

public class Airport implements Comparable<Airport> {
	public final String airportName;
	public Flight[] flights;
	public double minDistance = Double.POSITIVE_INFINITY;
	public Airport airport;

	public Airport(String airportName) {
		this.airportName = airportName;
	}

	public String toString() {
		return airportName;
	}

	public int compareTo(Airport other) {
		return Double.compare(minDistance, other.minDistance);
	}
}
