package com.test.app;

import java.util.ArrayList;

public class Airport {
	ArrayList<Plane> hangar;
	int capacity;
	int DEFAULTCAPACITY = 1;
	Weather weather;
	
	public Airport(Weather currentWeather) {
		hangar = new ArrayList<Plane>();
		capacity = DEFAULTCAPACITY;
		weather = currentWeather;
	}
	
	public Airport(int updatedCapacity, Weather currentWeather) {
		hangar = new ArrayList<Plane>();
		capacity = updatedCapacity;
		weather = currentWeather;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public  void landing(Plane plane) throws Exception {
		if (hangar.size() >= capacity) {
			throw new Exception("Airport is full");
		} else {
			hangar.add(plane);		
		}
	}

	public void takeoff(Plane plane) throws Exception {
		if (weather.getWeather().equals("stormy")) {
			throw new Exception("Not allowed to takeoff in stormy weather");
		} else {
			hangar.remove(plane);
		}
	}
}
