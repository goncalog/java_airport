package com.test.app;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class AirportTest {
	Airport heathrow;
	Plane tap;
	ArrayList<Plane> expectedPlanes;

	@Before
	public void setUp() throws Exception {
		heathrow = new Airport();
		tap = new Plane();
		expectedPlanes = new ArrayList<Plane>();
	}
	
	//	As an air traffic controller 
	//	So I can get passengers to a destination 
	//	I want to instruct a plane to land at an airport
	@Test
	public void planeCanLand() {
		heathrow.landing(tap);
		expectedPlanes.add(tap);
		
		assertEquals(expectedPlanes, heathrow.hangar);
		assertSame(tap, heathrow.hangar.get(0));
	}

	 //	As an air traffic controller 
	 //	So I can get passengers on the way to their destination 
	 //	I want to instruct a plane to take off from an airport and confirm that it is no longer in the airport
	 //	
	
	
	@Test
	public void planeCanTakeOff() {
		heathrow.landing(tap);
		heathrow.takeoff(tap);
		
		assertEquals(expectedPlanes, heathrow.hangar); 
		assertTrue(heathrow.hangar.isEmpty());
		
	}
}

