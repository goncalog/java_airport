package com.test.app;

import java.util.ArrayList;

public class Airport {
	ArrayList<Plane> hangar;
	
	public Airport() {
		hangar = new ArrayList<Plane>();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void landing(Plane plane) {
		hangar.add(plane);
	}

	public void takeoff(Plane plane) {
		hangar.remove(plane);
	}
}
