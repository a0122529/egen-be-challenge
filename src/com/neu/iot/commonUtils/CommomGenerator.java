package com.neu.iot.commonUtils;

import java.util.Random;

public class CommomGenerator {

	// generating a random value - using int method to generate as float does
	// not have a method that takes input
	public static float randomFloat(int min, int max) {
		Random rand = new Random();
		float randomNum = (float) rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

}
