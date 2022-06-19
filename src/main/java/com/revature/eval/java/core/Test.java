package com.revature.eval.java.core;

import java.util.LinkedList;

public class Test {

	public static void main(String[] args) {

		System.out.println(isPangram("the quick brown fox jumps over the lazy dog"));
		
	}

	public static boolean isPangram(String string) {
		string = string.toLowerCase();
		string = string.replaceAll("\\s", "");
		System.out.println(string);
		
		boolean[] letterCheck = new boolean[26];
		
		for (int i = 0; i < string.length(); i++) {
			int letter = string.charAt(i) - 'a';
			
			letterCheck[letter] = true;
		}
		
		for (int i = 0; i < letterCheck.length; i++) {
			if (letterCheck[i] == false) {
				return false;
			}
		}
		
		return true;
	}
	
}
