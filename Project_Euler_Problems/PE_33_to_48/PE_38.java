package PE_33_to_48;

import java.util.ArrayList;
import java.util.Collections;

public class PE_38 {
    private String problem_title = "Pandigital Multiples";
    private int problem_number = 38;
    private boolean completed_successfully = true;

    public PE_38(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        ArrayList<Integer> pandigitalConcatProducts = new ArrayList<Integer>();
        int concatMaxValue = 987654321;
        int upper_bound = 1000000;
        int concatProductToTest;
        
        //loop through number until the upper bound
        for(int i=1; i<upper_bound; i++) {
        	
        	//loop through the range of multipliers for the concatenated product
        	for(int j=1; j<=9; j++) {
        		//attempt to get the concatenated product
        		try {
        			concatProductToTest = getConcatenatedProduct(i, j);
        		}
        		//if an exception is thrown, the concatenated product was too big for an int to hold it
        		//in which case break since it'd be bigger then the MaxValue anyhow and so would future multipliers
        		catch(NumberFormatException e) {
        			break;
        		}
        		
        		//check that the concatenated product is lower then the limit, if not break
        		if( concatProductToTest > concatMaxValue ) {
        			break;
        		}
        		//add the concatenated product to our record
        		if(isPandigital(concatProductToTest)) {
        			pandigitalConcatProducts.add(concatProductToTest);
        		}
        	}
        }
        
        //sort the record and print out the last entry in the list
        Collections.sort(pandigitalConcatProducts);
        System.out.println("Largest 9 digit pandigital number from Concatenating Products of an integer is: "+pandigitalConcatProducts.get(pandigitalConcatProducts.size()-1));

        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }
    
    private boolean isPandigital(int x) {
    	//split the number up and check if there is exactly 9 numbers
    	//if not, it cant be pandigital
    	String[] argument_numbers = String.valueOf(x).split("(?!^)");
    	if(argument_numbers.length != 9) {
    		return false;
    	}
    	
    	ArrayList<String> numberList = new ArrayList<String>();
    	
    	//generate the list of numbers from 1-9 inclusively
    	for(int i=1; i<=9; i++) {
    		numberList.add(String.valueOf(i));
    	}
    	
    	//remove all numbers in the arguments from the list
    	for(String s : argument_numbers) {
    		numberList.remove(s);
    	}
    	//if the list is now empty, the number was pandigital, else it wasn't and was missing a number from 1-9
    	if(numberList.isEmpty()) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    private int getConcatenatedProduct(int value, int productRange) throws NumberFormatException {
    	StringBuilder sb = new StringBuilder();
    	
    	//append the product of the value with i to the string builder
    	for(int i=1; i<=productRange; i++) {
    		sb.append( String.valueOf(value*i) );
    	}
    	//return the string builder integer as an integer
    	return Integer.parseInt(sb.toString());
    }
    
}
