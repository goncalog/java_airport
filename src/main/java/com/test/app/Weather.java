package com.test.app;

import java.util.Random;

public class Weather {
	
	public String getWeather() {
		String[] options = { "sunny", "stormy"};
		Random rand = new Random();
		System.out.println(options[rand.nextInt(options.length)]);
		return options[rand.nextInt(options.length)];
	}

}
