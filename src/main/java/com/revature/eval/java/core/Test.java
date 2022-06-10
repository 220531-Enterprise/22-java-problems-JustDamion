package com.revature.eval.java.core;

import java.util.LinkedList;

public class Test {

	public static void main(String[] args) {

		System.out.println(isArmstrongNumber(153));
		
	}

	public static boolean isArmstrongNumber(int input) {
		
		int userInput = input;
		LinkedList<Integer> digits = new LinkedList<Integer>();
		
		while (input > 0) {
			
			digits.push(input % 10);
			input /= 10;
			
		}
		
		int pow = digits.size();
		int sum = 0;
		
		while (!digits.isEmpty()) {
			
			sum += Math.pow(digits.pop(), pow);
			System.out.println(sum);
			
		}
		
		if (sum == userInput)
			return true;
		else
			return false;
	}
	
}
