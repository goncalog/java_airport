package com.test.app;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AirportTest {
	Airport heathrow;
	Airport cst;
	Plane tap;
	Plane ba;
	ArrayList<Plane> expectedPlanes;

	@Mock
	Weather weatherMock;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		heathrow = new Airport(weatherMock);
		when(weatherMock.getWeather()).thenReturn("sunny");
		tap = new Plane();
		ba = new Plane();
		expectedPlanes = new ArrayList<Plane>();
	}

	// As an air traffic controller
	// So I can get passengers to a destination
	// I want to instruct a plane to land at an airport
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

	// As an air traffic controller
	// So I can get passengers on the way to their destination
	// I want to instruct a plane to take off from an airport and confirm that it is
	// no longer in the airport
	@Test
	public void planeCanTakeOff() {
		try {
			heathrow.landing(tap);
		} catch (Exception exception) {

		}

		try {
			heathrow.takeoff(tap);
		} catch (Exception exception) {

		}

		assertEquals(expectedPlanes, heathrow.hangar);
		assertTrue(heathrow.hangar.isEmpty());
	}

	// As an air traffic controller
	// To ensure safety
	// I want to prevent landing when the airport is full
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

	// As the system designer
	// So that the software can be used for many different airports
	// I would like a default airport capacity that can be overridden as appropriate

	@Test
	public void overrideDefaultCapacity() {
		cst = new Airport(2, weatherMock);
		assertEquals(2, cst.capacity);
	}

	// As an air traffic controller
	// To ensure safety
	// I want to prevent takeoff when weather is stormy
	@Test
	public void preventTakeOffWhenStormyWeather() {
		Exception exception = new Exception();

		try {
			heathrow.landing(tap);
			// airport instance return stormy weather
			when(weatherMock.getWeather()).thenReturn("stormy");
			heathrow.takeoff(tap);
		} catch (Exception e) {
			exception = e;
		}

		assertEquals("Not allowed to takeoff in stormy weather", exception.getMessage());
		assertEquals(1, heathrow.hangar.size());
	}

	//	As an air traffic controller 
	//	To ensure safety 
	//	I want to prevent landing when weather is stormy 

	@Test
	public void preventLandingWhenStormyWeather() {
		Exception exception = new Exception();

		try {
			when(weatherMock.getWeather()).thenReturn("stormy");
			heathrow.landing(tap);
		} catch (Exception e) {
			exception = e;
		}

		assertEquals("Not allowed to land in stormy weather", exception.getMessage());
		assertEquals(0, heathrow.hangar.size());

	}

}
