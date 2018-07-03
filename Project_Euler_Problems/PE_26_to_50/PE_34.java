package PE_26_to_50;

import java.math.BigInteger;

public class PE_34 {
    private String problem_title = "Digit Factorials";
    private int problem_number = 34;
    private boolean completed_successfully = true;
    
    private final BigInteger bigZero;
    private final BigInteger bigOne;

    public PE_34(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
        bigZero = new BigInteger("0");
        bigOne = new BigInteger("1");
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        int lower_bound = 3;
        int upper_bound = 100000;
        int curiousNumberSum = 0;
        
        //check all numbers under the upper bound to see if they're curious
        for(int i=lower_bound; i<upper_bound; i++) {
        	if(isCuriousNumber(i)) {
        		curiousNumberSum += i;
        	}
        }
        
        System.out.println("Sum of Curious Numbers is: "+curiousNumberSum);
        
        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }
    
    private boolean isCuriousNumber(int x) {
    	//if the sum of the digits' factorials are the same as the number itself, return true
    	if(sumOfFactorialDigits(x) == x) {
    		return true;
    	}
    	//else return false
    	else {
    		return false;
    	}
    }
    
    private int sumOfFactorialDigits(int x) {
    	//split the number into it's digits
    	String[] digits = Integer.toString(x).split("(?!^)");
    	int digitFactSum = 0;
    	
    	for(String s : digits) {
    		digitFactSum = digitFactSum + calculateFactorial(new BigInteger(s)).intValue();
    	}
    	
    	return digitFactSum;
    }
    
    //returning big integers to combat the size of the numberss
    private BigInteger calculateFactorial(BigInteger x) {
    	if(x.equals(bigOne) || x.equals(bigZero)) {
    		return new BigInteger("1");
    	}
    	else {
    		return x.multiply( calculateFactorial(x.subtract(bigOne)) );
    	}
    }
}
