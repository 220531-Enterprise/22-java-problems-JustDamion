package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		System.out.println(calculateNthPrime(2));
		
	}

	public static int calculateNthPrime(int k) {
		int count = 0;
		int num = 1;
		int i;
		
		while (k > count) {
			num++;
			
			for (i = 2; i < num; i++) {
				if (num % i == 0) {
					break;
				}
			}
			
			if (num == i) {
				System.out.println(num);
				count++;
			}
		}
		
		return num;
	}
	
}
