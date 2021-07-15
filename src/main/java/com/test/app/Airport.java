package com.test.app;

import java.util.ArrayList;


public class Airport {
	ArrayList<Plane> hangar;
	int capacity;
	
	public Airport() {
		hangar = new ArrayList<Plane>();
		capacity = 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public  void landing(Plane plane) throws Exception {
		if (hangar.size() < capacity) {
			hangar.add(plane);
		} else {
			throw new Exception("Airport is full");
		}
	}

	public void takeoff(Plane plane) {
		hangar.remove(plane);
	}
}
