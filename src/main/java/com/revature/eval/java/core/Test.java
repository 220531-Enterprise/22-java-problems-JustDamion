package com.revature.eval.java.core;

public class Test {

	public static void main(String[] args) {
		
		String kB = printMegaBytesAndKiloBytes(4336);
		
		System.out.println(kB);
	}
	
	public static String printMegaBytesAndKiloBytes(int kiloBytes) {
		
		String result;
		
		if (kiloBytes < 0) {
			result = "Invalid Value";
		} else {
			result = kiloBytes + " KB = " + kiloBytes/1000 + " MB and " + kiloBytes%1000 + " KB";
		}
		
		return result;
	}
}
