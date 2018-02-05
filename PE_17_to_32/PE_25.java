package Project_Euler_Problems;

import java.math.BigInteger;

public class PE_25 {
	private String problem_title = "1000-digit long Fibonacci Number";
    private int problem_number = 25;
    private boolean completed_successfully = true;

    public PE_25(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();
        
        boolean flag = true;
        BigInteger f_n_1 = new BigInteger("1");
        BigInteger f_n_2 = new BigInteger("1");
        int index = 2;
        BigInteger sum = null;
        int sum_length_limit = 1000;
        
        //loop until the next fibonacci number has 'x' digits or more, so long as the target limit is more than 0
        while(flag && (sum_length_limit > 0)) {
        	//get the next number in the sequence
        	sum = this.getNextFibonacciNumber(f_n_1, f_n_2);
        	//increase the index tpo record it's position in the sequence
        	index++;
        	
        	//if the number has the number of digits or more then we're looking for, break
        	if(sum.toString().length() >= sum_length_limit) {
        		break;
        	}
        	//otherwise, record the previous two numbers and continue
        	else {
        		f_n_1 = f_n_2;
        		f_n_2 = sum;
        	}
        }
        
        System.out.println("Index of the first Fibonacci number with "+sum_length_limit+" digits is: "+index);
        
        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }
    private BigInteger getNextFibonacciNumber(BigInteger f1, BigInteger f2) {
    	return (f1.add(f2));
    }
}
