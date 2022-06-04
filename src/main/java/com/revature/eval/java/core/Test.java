package com.revature.eval.java.core;

public class Test {

	public static void main(String[] args) {

		System.out.println(getGreatestCommonDivisor(25, 15));
		
	}
	
	public static int getGreatestCommonDivisor(int first, int second) {
		
		// Initialize divider
		int divider = -1;
		
		// Check for invalid input
		if (first >= 10 || second >= 10) {
			
			// Determine highest GCD and set divider
			for (int i = 1; i <= first || i <= second; i++) {
				
				System.out.println(i);
				//System.out.println(second % i);
				
				if (first % i == 0 && second % i == 0) {
					divider = i;
				}
			}
		}
			
		return divider;
		
	}
}
