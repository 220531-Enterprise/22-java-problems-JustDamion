package com.revature.eval.java.core;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class EvaluationService {

	/**
	 * ADD SOME DOCUMENTATION
	 * 
	 * 1.A Speed Converter - Convert to MilesPerHour
	 * 
	 * Write a method called toMilesPerHour that has 1 parameter of type double with
	 * the name kilometersPerHour. This method needs to return the rounded value of
	 * the calculation of type long.
	 * 
	 * If the parameter kilometersPerHour is less than 0, the method toMilesPerHour
	 * needs to return -1 to indicate an invalid value.
	 * 
	 * Otherwise if it is positive, calculate the value of miles per hour, round it
	 * and return it. For conversion and rounding use Math.round().
	 */
	static class SpeedConverter {

		public static long toMilesPerHour(double kilometersPerHour) {

			// check if the params is less than 0, if so return -1
			if(kilometersPerHour < 0)
				return -1;
			
			// find out the formula to convert kph to mph
			long mph = Math.round(kilometersPerHour / 1.60934);
			
			// return it!
			return mph;
		}

		/**
		 * 1.B Speed Converter - Print Conversion
		 * 
		 * Write another method called printConversion with 1 parameter of type double
		 * with the name kilometersPerHour. This method needs to return a String and
		 * needs to calculate milesPerHour from the kilometersPerHour parameter.
		 * 
		 * The String should print in the format: "XX km/h = YY mi/h"
		 * 
		 * XX represents the original value kilometersPerHour. YY represents the rounded
		 * milesPerHour from the kilometersPerHour parameter.
		 * 
		 * If the parameter kilometersPerHour is < 0, then print the text "Invalid
		 * Value"
		 */
		public static String printConversion(double kilometersPerHour) {
			
			// Calculate MPH from KMH using toMilesPerHour method
			long mph = toMilesPerHour(kilometersPerHour);
			
			// Determine output
			String result = (mph == -1 ? "Invalid Value" : kilometersPerHour + " km/h = " + mph + " mi/h");
			
			// Return the result
			return result;
		}
	}

	/**
	 * 2. MegaBytes and KiloBytes
	 * 
	 * Write a method called printMegaBytesAndKiloBytes that has 1 parameter of type
	 * int with the name kiloBytes.
	 * 
	 * The method should return a String and it needs to calculate the megabytes and
	 * remaining kilobytes from the kilobytes parameter.
	 * 
	 * Then it needs to print a message in the format "XX KB = YY MB and ZZ KB".
	 * 
	 * XX represents the original value kiloBytes. YY represents the calculated
	 * megabytes. ZZ represents the calculated remaining kilobytes.
	 * 
	 * For examples, when the parameter kiloBytes is 2500 it needs to print "2500 KB
	 * = 2 MB and 452 KB"
	 * 
	 * If the parameter kiloBytes is less than 0 then print the text "Invalid
	 * Value".
	 */
	public String printMegaBytesAndKiloBytes(int kiloBytes) {
		
		// Check for valid input
		if (kiloBytes < 0)
			return "Invalid Value";
		else 
			// 1024 kb = 1 mb, % used to get remainder
			return kiloBytes + " KB = " + kiloBytes/1024 + " MB and " + kiloBytes%1024 + " KB";

	}

	/**
	 * 3. Barking Dog
	 * 
	 * We have a dog that loves to bark. We need to wake up if the dog is barking at
	 * night!
	 * 
	 * Write a method shouldWakeUp that has 2 parameters.
	 * 
	 * 1st parameter should be of type boolean and be named "barking". It represents
	 * if our dog is currently barking. 2nd parameter represents the hour of the day
	 * and is of type int with the name hourOfDay and has a valid range of 0-23.
	 * 
	 * We have to wake up if the dog is barking before 8 or after 22 hours, so in
	 * that case return true.
	 * 
	 * In all other cases return false.
	 * 
	 * If the hourOfDay parameter is less than 0 or greater than 23, return false.
	 */
	public boolean shouldWakeUp(boolean isBarking, int hourOfDay) {
		
		// Determine hourOfDay and isBarking
		if ((hourOfDay < 8 || hourOfDay > 22) && hourOfDay >= 0 && hourOfDay <= 23 && isBarking)
			return true;
		else
			return false;
		
	}

	/**
	 * 4. DecimalComparator
	 * 
	 * Write a method areEqualByThreeDecimalPlaces with two parameters of type
	 * double.
	 * 
	 * The method should return boolean and it needs to return true if two double
	 * numbers are the same up to three decimal places.
	 * 
	 * Otherwise, return false;
	 */
	public boolean areEqualByThreeDecimalPlaces(double firstNum, double secondNum) {
		
		// Initialize DecimalFormat object
		DecimalFormat df = new DecimalFormat("#.###");
		
		// Set how rounding is handled using RoundingMode...
		// DOWN is used instead of FLOOR to handle negative numbers
		df.setRoundingMode(RoundingMode.DOWN);
		
		// Determine if the parameters are equivalent
		if (df.format(firstNum).equals(df.format(secondNum)))
			return true;
		else
			return false;

	}

	/**
	 * 5. Teen Number Checker
	 * 
	 * We'll say that a number is "teen" if it is in the range 13 -19 (inclusive).
	 * Write a method named hasTeen with 3 parameters of type int.
	 * 
	 * The method should return boolean and it needs to return true if ONE of the
	 * parameters is in range 13(inclusive) - 19 (inclusive). Otherwise return
	 * false.
	 */
	static class TeenNumberChecker {

		public static boolean hasTeen(int x, int y, int z) {
			
			if (isTeen(x) || isTeen(y) || isTeen(z))
				return true;
			else
				return false;
			
		}

		// We can initialize isTeen method first
		// Then pass the parameter to hasTeen method

		public static boolean isTeen(int number) {
			
			// Check if a parameter is between 13 and 19 & return true, else return false
			if (number >= 13 && number <= 19)
				return true;
			else
				return false;
			
		}
	}

	/**
	 * 6. Minutes To Years and Days Calculator
	 * 
	 * Write a method printYearsAndDays with parameter of type long named minutes.
	 * The method should not return anything (void) and it needs to calculate the
	 * years and days from the minutes parameter.
	 * 
	 * If the parameter is less than 0, print text "Invalid Value".
	 * 
	 * Otherwise, if the parameter is valid then it needs to print a message in the
	 * format "XX min = YY y and ZZ d".
	 * 
	 * XX represents the original value minutes. YY represents the calculated years.
	 * ZZ represents the calculated days.
	 */
	public String printYearsAndDays(long minutes) {
		
		// Check for invalid input
		if (minutes < 0)
			return "Invalid Value";
		else
			// 525600 mins = 1 year, 1440 mins = 1 day
			return minutes + " min = " + minutes/525600 + " y and " + (minutes%525600)/1440 + " d";

	}

	/**
	 * 7. Number In Word
	 * 
	 * Write a method called printNumberInWord. The method has one parameter number
	 * which is the whole number. The method needs to print "ZERO", "ONE", "TWO",
	 * ... "NINE", "OTHER" if the int parameter number is 0, 1, 2, .... 9 or other
	 * for any other number including negative numbers. You can use if-else
	 * statement or switch statement whatever is easier for you.
	 */
	public String printNumberInWord(int number) {
		
		String word;
		
		switch (number) {
		case 0:
			word = "ZERO";
			break;
		case 1:
			word = "ONE";
			break;
		case 2:
			word = "TWO";
			break;
		case 3:
			word = "THREE";
			break;
		case 4:
			word = "FOUR";
			break;
		case 5:
			word = "FIVE";
			break;
		case 6:
			word = "SIX";
			break;
		case 7:
			word = "SEVEN";
			break;
		case 8:
			word = "EIGHT";
			break;
		case 9:
			word = "NINE";
			break;
		default:
			word = "OTHER";
			break;
		}
		
		return word;
	}

	/**
	 * 8. Greatest Common Divisor
	 * 
	 * Write a method named getGreatestCommonDivisor with two parameters of type int
	 * named first and second.
	 * 
	 * If one of the parameters is < 10, the method should return -1 to indicate an
	 * invalid value. The method should return the greatest common divisor of the
	 * two numbers (int).
	 * 
	 * The greatest common divisor is the largest positive integer that can fully
	 * divide each of the integers (i.e. without leaving a remainder).
	 * 
	 * For example 12 and 30: 12 can be divided by 1, 2, 3, 4, 6, 12 30 can be
	 * divided by 1, 2, 3, 5, 6, 10, 15, 30
	 * 
	 * The greatest common divisor is 6 since both 12 and 30 can be divided by 6,
	 * and there is no resulting remainder.
	 */
	public int getGreatestCommonDivisor(int first, int second) {
		
		// Initialize divider
		int gcd = -1;
		
		// Check for valid input
		if (first >= 10 && second >= 10) {
			
			// Determine and set highest GCD
			for (int i = 1; i <= first || i <= second; i++) {
				if (first % i == 0 && second % i == 0) {
					gcd = i;
				}
			}
		}
			
		return gcd;
		
	}

	/**
	 * 9. First and Last Digit Sum
	 * 
	 * Write a method named sumFirstAndLastDigit with one parameter of type int
	 * called number.
	 * 
	 * The method needs to find the first and the last digit of the parameter number
	 * passed to the method, using a loop and return the sum of the first and the
	 * last digit of that number.
	 * 
	 * If the number is negative then the method needs to return -1 to indicate an
	 * invalid value.
	 */
	public int sumFirstAndLastDigit(int num) {
		
		int sum = -1;
		
		// Check for valid input
		if (num >= 0) {
			
			// Initialize firstNum & get lastNum
			int firstNum = 0;
			int lastNum = num % 10;
			
			while (num != 0) {
				
				// Find firstNum
				firstNum = num % 10;
				num /= 10;
				
			}
			
			// Calculate sum
			sum = firstNum + lastNum;
			
		}
		
		return sum;
		
	}

	/**
	 * 10. Reverse String
	 * 
	 * Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 */
	public String reverse(String string) {
		
		// Create/initialize variables
		char letter;
		String reversed = "";
		
		// Loop through each character of string
		for (int i = 0; i < string.length(); i++) {
			
			// Get letter and create reversed string
			letter = string.charAt(i);
			reversed = letter + reversed;
			
		}
		
		return reversed;
	}

	/**
	 * 11. Acronyms
	 * 
	 * Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 */
	public String acronym(String phrase) {
		
		// Initialize acronym with first character
		String acronym = "" + phrase.charAt(0);
		
		// Loop through phrase for each character
		for (int i = 0; i < phrase.length(); i++) {
			
			// Check for ' ' and '-'
			if (phrase.charAt(i) == ' ' || phrase.charAt(i) == '-') {
				
				// Add letters after ' ' and '-'
				acronym += phrase.charAt(i + 1);
				
			}
			
		}
		
		// Return acronym in all caps
		return acronym.toUpperCase();
	}

	/**
	 * 12. Triangles
	 * 
	 * Determine if a triangle is equilateral, isosceles, or scalene. An equilateral
	 * triangle has all three sides the same length. An isosceles triangle has at
	 * least two sides the same length.
	 * 
	 * (It is sometimes specified as having exactly two sides the same length, but
	 * for the purposes of this exercise we'll say at least two.) A scalene triangle
	 * has all sides of different lengths.
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if (getSideOne() == getSideTwo() && getSideTwo() == getSideThree())
				return true;
			else
				return false;
		}

		public boolean isIsosceles() {
			if (getSideOne() == getSideTwo() || getSideOne() == getSideThree() || getSideTwo() == getSideThree())
				return true;
			else
				return false;
		}

		public boolean isScalene() {
			if (getSideOne() != getSideTwo() && getSideOne() != getSideThree() && getSideTwo() != getSideThree())
				return true;
			else
				return false;
		}

	}

	/**
	 * 13. Scrabble Score
	 * 
	 * Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 */
	public int getScrabbleScore(String string) {
		
		// Initialize score & convert string to uppercase
		int score = 0;
		string = string.toUpperCase();
		
		// Loop through string for each character
		for (int i = 0; i < string.length(); i++) {
			// Determine character and adjust score
			switch (string.charAt(i)) {
			case 'A': case 'E': case 'I': case 'O': case 'U': case 'L': case 'N': case 'R': case 'S': case 'T':
				score += 1;
				break;
			case 'D': case 'G': 
				score += 2;
				break;
			case 'B': case 'C': case 'M': case 'P':
				score += 3;
				break;
			case 'F': case 'H': case 'V': case 'W': case 'Y':
				score += 4;
				break;
			case 'K':
				score += 5;
				break;
			case 'J': case 'X':
				score += 8;
				break;
			case 'Q': case 'Z':
				score += 10;
				break;
			default:
				break;
			}
		}
		
		return score;
	}

	/**
	 * 14. Clean the Phone Number
	 * 
	 * Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		
		// Replace all non-digit characters with null
		string = string.replaceAll("[^0-9]", "");
		
		// Check for & remove country code
		if (string.charAt(0) == '1')
			string.substring(1);
		
		// Check for valid number, if not, throw exception
		if (string.length() != 10)
			throw new IllegalArgumentException("Not a valid number ~ Illegal argument");
		
		// Return string
		return string;
	}

	/**
	 * 15. Recurring Word Counter
	 * 
	 * Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 */
	public Map<String, Integer> wordCount(String string) {
		
		// Create HashMap to store words + occurrences
		HashMap<String, Integer> wordMap = new HashMap<>();
		
		// Iterate through string for each word, put & count words in wordMap
		for (String w : string.split(",|\\s+")) {
			if (w.isEmpty())
				continue;
			if (wordMap.containsKey(w))
				wordMap.put(w, wordMap.get(w) + 1);
			else
				wordMap.put(w, 1);
		}
		
		// Return wordMap
		return wordMap;
	}

	/**
	 * 16. Armstrong Number
	 * 
	 * An Armstrong number is a number that is the sum of its own digits each raised
	 * to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 */
	public boolean isArmstrongNumber(int input) {
		
		// Store input into userInput
		int userInput = input;
		
		// Initialize LinkedList
		LinkedList<Integer> digits = new LinkedList<Integer>();
		
		while (input > 0) {
			
			// Get last digit of input, then remove last digit of input
			digits.push(input % 10);
			input /= 10;
			
		}
		
		// Determine pow from size of digits
		int pow = digits.size();
		int sum = 0;
		
		while (!digits.isEmpty()) {
			
			// Calculate the sum of each digit ^ pow
			sum += Math.pow(digits.pop(), pow);
			
		}
		
		// Check if Armstrong Number
		if (sum == userInput)
			return true;
		else
			return false;
	}

	/**
	 * 17. Prime Factors
	 * 
	 * Compute the prime factors of a given natural number. A prime number is only
	 * evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> primeNums = new LinkedList<Long>();
		
		// Check for factor of 2, add to list
		while (l % 2 == 0) {
			primeNums.add(2L);
			l /= 2;
		}
		
		// Check for other factors, add to list
		for (long i = 3; i <= l; i += 2) {
			while (l % i == 0) {
				primeNums.add(i);
				l /= i;
			}
		}
		
		return primeNums;
	}

	/**
	 * 18. Calculate Nth Prime
	 * 
	 * Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 */
	public int calculateNthPrime(int k) {
		// TODO Write an implementation for this method declaration
		return 0;
	}

	/**
	 * 19. Pangram
	 * 
	 * Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		return false;
	}

	/**
	 * 20. Sum of Multiples 
	 * 
	 * Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 */
	public int getSumOfMultiples(int i, int[] set) {
		return 0;
	}
	
	/**
	 * 21. Three Magic Numbers
	 * 
	 * You work at a casino in Las Vegas.  Your job is to program a slot machine to
	 * return 3 random numbers using the java.util.Random class.
	 * 
	 * Write a method to return an int array of 3 random numbers between 1 - 100.
	 * Generate the 3 random numbers (1 - 100 inclusive) using the java.util.Random class.
	 */
	
	public int[] threeLuckyNumbers() {
		Random rand = new Random();
		int[] numbers = new int[3];
		
		// Loop through three times, generate random nums
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rand.nextInt(101) - 1;
		}
		
		return numbers;
	}
	
	/*
	 * 22. Easy Guessing Game
	 * 
	 * Create a program to generate a number between the given range:
	 * int x = minimum
	 * iny y = maximum (inclusive)
	 * 
	 * You must use the Math.random class to generate a random number between x and y.
	 */
	
	public int guessingGame(int x, int y) {
		Integer rand = null;

		// Re-generate random numbers until in range
		do 
		{
			rand = (int)(Math.random() * 100);
		} while (rand < x || rand > y);
		
		return rand;
	}
}
