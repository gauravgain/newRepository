package com.flight.route;

public class Flight {
	public final Airport airport;
	public final double distance;

	public Flight(Airport airport, double distance) {
		this.airport = airport;
		this.distance = distance;
	}
}
