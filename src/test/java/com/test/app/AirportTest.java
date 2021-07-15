package com.test.app;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class AirportTest {
	Airport heathrow;
	Plane tap;

	@Before
	public void setUp() throws Exception {
		heathrow = new Airport();
		tap = new Plane();
	}
	
	//	As an air traffic controller 
	//	So I can get passengers to a destination 
	//	I want to instruct a plane to land at an airport
	@Test
	public void planeCanLand() {
		heathrow.landing(tap);
		
		ArrayList<Plane> expectedPlanes = new ArrayList<Plane>();
		expectedPlanes.add(tap);
		assertEquals(expectedPlanes, heathrow.hangar);
	
		assertSame(tap, heathrow.hangar.get(0));
	}

}
