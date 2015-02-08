package com.flight.route;

import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Unit test for FilightRouteFinder App.
 */
public class FlightRouteFinderTest 
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	public static Airport a0,a1,a2,a3,a4,a5,a6=null;
	public static Flight[] flights=null;
	
	@BeforeClass
	public static void setupFlightsRoutes() {
		 a0 = new Airport("India");
		 a1 = new Airport("Nepal");
		 a2 = new Airport("Bangladesh");
		 a3 = new Airport("Shreelanka");
		 a4 = new Airport("Pakistan");
		 a5 = new Airport("Bhutan");
		 a6 = new Airport("China");	
		 
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
		
		FlightRouteFinder.computePaths(a0);		 
	}
	
	@Test
	public void testRoute1() {
			List<Airport> toNepal = FlightRouteFinder.getShortestRoute(a1);			
			assertEquals(2, toNepal.size());
			assertEquals("Nepal", toNepal.get(1).toString());
	}
	
	@Test
	public void testRoute2() {
			List<Airport> toBangladesh = FlightRouteFinder.getShortestRoute(a2);			
			assertEquals(3, toBangladesh.size());
			assertEquals("Bangladesh", toBangladesh.get(2).toString());
	}
}
