package com.flight.route;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class FlightRouteFinder {
	public static void computePaths(Airport source) {
		source.minDistance = 0.;
		PriorityQueue<Airport> airportQueue = new PriorityQueue<Airport>();
		airportQueue.add(source);

		while (!airportQueue.isEmpty()) {
			Airport airport = airportQueue.poll();

			for (Flight flight : airport.flights) {
				Airport a = flight.airport;
				double distance = flight.distance;
				double distanceThroughU = airport.minDistance + distance;
				if (distanceThroughU < a.minDistance) {
					airportQueue.remove(a);

					a.minDistance = distanceThroughU;
					a.airport = airport;
					airportQueue.add(a);
				}
			}
		}
	}

	public static List<Airport> getShortestRoute(Airport destination) {
		List<Airport> route = new ArrayList<Airport>();
		for (Airport Airport = destination; Airport != null; Airport = Airport.airport)
			route.add(Airport);

		Collections.reverse(route);
		return route;
	}

	public static void main(String[] args) {
		Airport a0 = new Airport("India");
		Airport a1 = new Airport("Nepal");
		Airport a2 = new Airport("Bangladesh");
		Airport a3 = new Airport("Shreelanka");
		Airport a4 = new Airport("Pakistan");
		Airport a5 = new Airport("Bhutan");
		Airport a6 = new Airport("China");
		
		a0.flights = new Flight[] { new Flight(a1, 79.83),
				new Flight(a5, 81.15) };
		a1.flights = new Flight[] { new Flight(a0, 79.75),
				new Flight(a2, 39.42), new Flight(a3, 103.00) };
		a2.flights = new Flight[] { new Flight(a1, 38.65) };
		a3.flights = new Flight[] { new Flight(a1, 102.53),
				new Flight(a5, 61.44), new Flight(a6, 96.79) };
		a4.flights = new Flight[] { new Flight(a5, 133.04) };
		a5.flights = new Flight[] { new Flight(a0, 81.77),
				new Flight(a3, 62.05), new Flight(a4, 134.47),
				new Flight(a6, 91.63) };
		a6.flights = new Flight[] { new Flight(a3, 97.24),
				new Flight(a5, 87.94) };
		
		Airport[] airports = { a0, a1, a2, a3, a4, a5, a6 };

		computePaths(a0);
		for (Airport a : airports) {
			System.out.println("Distance to " + a + ": " + a.minDistance);
			List<Airport> route = getShortestRoute(a);
			System.out.println("Route: " + route);
		}
	}
}
