package PE_26_to_50;

import java.util.ArrayList;

public class PE_30 {
	private String problem_title = "Digit Fifth Powers";
    private int problem_number = 30;
    private boolean completed_successfully = true;

    public PE_30(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        //took an ambiguous maximum boundary to not run forever
        int temp_max_bound = 1000000;
        
        int min_start = 2;
        int nth_power = 5;
        int sum = 0;
        ArrayList<Integer> digitPowerList = new ArrayList<Integer>();
        
        //loop through the numbers to find if they are nth digit power sums
        for(int i=min_start; i<temp_max_bound; i++) {
        	//if the number is a digit power sum, add it to the list
        	if(isDigitPowerSum(i, nth_power)) {
        		digitPowerList.add(i);
        	}
        }
        
        //loop through all the digit power sums and add them
        for(Integer db : digitPowerList) {
        	sum += db;
        }
        
        System.out.println("Sum of all digit power sums with power of "+nth_power+" is: "+sum);
        
        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }
    
    private boolean isDigitPowerSum(int x, int power) {
    	boolean isDigPowerSum = false;
    	int power_sum = 0;
    	//first split the digits into strings
    	String[] numbers = Integer.toString(x).split("(?!^)");
    	
    	//loop through each digit, put it to the power of n, and add it to a running total
    	for(String num : numbers) {
    		power_sum += (int)Math.pow(Integer.valueOf(num), power);
    	}
    	
    	//if the total equals the full number we we're checking, set to true
    	if(power_sum == x) {
    		isDigPowerSum = true;
    	}
    	
    	return isDigPowerSum;
    }
}
