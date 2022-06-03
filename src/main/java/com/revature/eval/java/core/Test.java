package com.revature.eval.java.core;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Test {

	public static void main(String[] args) {

		System.out.println(areEqualByThreeDecimalPlaces(-3.1756, -3.175));
		
	}
	
	public static boolean areEqualByThreeDecimalPlaces(double firstNum, double secondNum) {
		
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.DOWN);
		
		if (df.format(firstNum).equals(df.format(secondNum)))
			return true;
		else
			return false;
		
	}
}
