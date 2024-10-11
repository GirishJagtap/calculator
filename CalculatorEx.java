package com.calculatorEx;

import java.util.ArrayList;
import java.util.List;

public class CalculatorEx {
	public int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0; 
		}

		String delimiter = ",|\n"; 
		if (numbers.startsWith("//")) {

			int delimiterIndex = numbers.indexOf("\n");
			delimiter = numbers.substring(2, delimiterIndex);
			numbers = numbers.substring(delimiterIndex + 1);
		}

		String[] tokens = numbers.split(delimiter);
		List<Integer> negatives = new ArrayList<>();
		int sum = 0;

		for (String token : tokens) {
			if (!token.isEmpty()) {
				int number = Integer.parseInt(token);
				if (number < 0) {
					negatives.add(number); 
				}
				sum += number;
			}
		}

		if (!negatives.isEmpty()) {
			throw new IllegalArgumentException("Negative numbers not allowed: " + negatives);
		}

		return sum;
	}

	public static void main(String[] args) {
		CalculatorEx calculator = new CalculatorEx();
		System.out.println(calculator.add("")); 
		System.out.println(calculator.add("1"));  
		System.out.println(calculator.add("1,5"));  
		System.out.println(calculator.add("1\n2,3"));  
		System.out.println(calculator.add("//;\n1;2"));
		try {
			System.out.println(calculator.add("1,-2,3"));  
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());  
		}
	}
}

