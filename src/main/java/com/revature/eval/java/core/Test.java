package com.revature.eval.java.core;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Test {

	public static void main(String[] args) {

		System.out.println(printYearsAndDays(561600));
		
	}
	
	public static String printYearsAndDays(long minutes) {
		
		if (minutes < 0)
			return "Invalid Value";
		else
			return minutes + " min = " + minutes/525600 + " y and " + (minutes%525600)/1440 + " d";

	}
}
