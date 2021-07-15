package com.test.app;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class AirportTest {
	Airport heathrow;
	Plane tap;
	Plane ba;
	ArrayList<Plane> expectedPlanes;

	@Before
	public void setUp() throws Exception {
		heathrow = new Airport();
		tap = new Plane();
		ba = new Plane();
		expectedPlanes = new ArrayList<Plane>();
	}
	
	//	As an air traffic controller 
	//	So I can get passengers to a destination 
	//	I want to instruct a plane to land at an airport
	@Test
	public void planeCanLand() {
		try {
			heathrow.landing(tap);
		} catch (Exception exception) {
			
		}
		expectedPlanes.add(tap);
		
		assertEquals(expectedPlanes, heathrow.hangar);
		assertSame(tap, heathrow.hangar.get(0));
	}

	 //	As an air traffic controller 
	 //	So I can get passengers on the way to their destination 
	 //	I want to instruct a plane to take off from an airport and confirm that it is no longer in the airport
	@Test
	public void planeCanTakeOff() {
		try {
			heathrow.landing(tap);
		} catch (Exception exception) {
			
		}
		
		heathrow.takeoff(tap);
		
		assertEquals(expectedPlanes, heathrow.hangar); 
		assertTrue(heathrow.hangar.isEmpty());	
	}
	
	//	As an air traffic controller 
	//	To ensure safety 
	//	I want to prevent landing when the airport is full 	
	@Test
	public void landingPreventedWhenFull() throws Exception {
		Exception e = new Exception();
		
		try {
			heathrow.landing(tap);
			heathrow.landing(ba);
		} catch (Exception exception) {
			e = exception;
		}

		assertEquals("Airport is full", e.getMessage());
		
		assertEquals(heathrow.capacity, heathrow.hangar.size());
		assertEquals(1, heathrow.hangar.size());
		assertEquals(-1, heathrow.hangar.indexOf(ba));
	}
	
}

