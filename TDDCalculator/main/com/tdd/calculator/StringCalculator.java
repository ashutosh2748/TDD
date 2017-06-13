package com.tdd.calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	public static int add(String numbers) {
		
		String delimiter = ",|\n";
	    String numbersWithoutDelimiter = numbers;
		
		
		
		
		if (numbers.startsWith("//")) {
	        
			if(numbers.startsWith("//[")){
				int delimiterStartIndex = numbers.indexOf("//[") + 3;
				int delimiterEndIndex = numbers.indexOf("]");
				 delimiter = numbers.substring(delimiterStartIndex, delimiterEndIndex);
				 numbersWithoutDelimiter = numbers.substring(numbers.indexOf("\n") + 1);
			}
			else {
			int delimiterIndex = numbers.indexOf("//") + 2;
	        delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
	        numbersWithoutDelimiter = numbers.substring(numbers.indexOf("\n") + 1);
			}
	    }
			
           
                     
            
        return add(numbersWithoutDelimiter,delimiter);
	}
	
	public static int add(String numbers,String delimiters){
		 int returnValue = 0;
		    String[] numbersArray = numbers.split(delimiters);
		    List<Integer> negativeNumbers = new ArrayList<Integer>();
		    for (String number : numbersArray) {
		        if (!number.trim().isEmpty()) {
		            int numberInt = Integer.parseInt(number.trim());
		            if (numberInt < 0) {
		                negativeNumbers.add(numberInt);
		            }
		            else if(numberInt<=1000)
		            returnValue += numberInt;
		        }
		    }
		    if (negativeNumbers.size() > 0) {
		        throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
		    }
		    return returnValue;    
		
	}

}
