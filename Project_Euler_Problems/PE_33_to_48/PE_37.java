package PE_33_to_48;

import java.util.ArrayList;

public class PE_37 {
    private String problem_title = "Truncatable Primes";
    private int problem_number = 37;
    private boolean completed_successfully = true;

    public PE_37(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        int upper_bound = 1000000;
        int truncatableSum = 0;
        ArrayList<Integer> primeList = generatePrimes(upper_bound);

        for(int i : primeList) {
        	if(isTruncatable_LTR_RTL(i, primeList)) {
        		System.out.println(i);
        		truncatableSum += i;
        	}
        }

        //removing all single digit primes
        truncatableSum -= (2+3+5+7);
        
        System.out.println("Sum of all LTR and RTL truncatable primes is: "+truncatableSum);

        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }
 
    private boolean isTruncatable_LTR_RTL(int x, ArrayList<Integer> primeList) {
    	boolean truncatable = true;
    	ArrayList<Integer> LTR = truncate_LTR(x);
    	ArrayList<Integer> RTL = truncate_RTL(x);
    	
    	for(int i : LTR) {
    		if(!primeList.contains(i)) {
    			return false;
    		}
    	}
    	
    	for(int i : RTL) {
    		if(!primeList.contains(i)) {
    			return false;
    		}
    	}
    	
    	return truncatable;
    }
    
    private ArrayList<Integer> truncate_LTR(int x){
    	ArrayList<String> integer_to_truncate = new ArrayList<String>();
    	ArrayList<Integer> permutations = new ArrayList<Integer>();
		String[] integer_digits = String.valueOf(x).split("(?!^)");
    	
    	for(String s : integer_digits) {
    		integer_to_truncate.add(s);
    	}
    	
    	int counter = integer_to_truncate.size();
    	StringBuilder sb;
    	//chopping off digits starting at the left hand side
    	for(int i=0; i<counter-1; i++) {
    		
    		//we're always removing the left most index, aka 0
    		integer_to_truncate.remove(0);
    		sb = new StringBuilder();
    		
    		for(String s : integer_to_truncate) {
    			sb.append(s);
    		}
    		permutations.add( Integer.parseInt(sb.toString()) );
    		
    	}
    	permutations.add(x);
    	
    	
    	return permutations;
    }
    
    private ArrayList<Integer> truncate_RTL(int x){
    	ArrayList<String> integer_to_truncate = new ArrayList<String>();
    	ArrayList<Integer> permutations = new ArrayList<Integer>();
		String[] integer_digits = String.valueOf(x).split("(?!^)");
    	
    	for(String s : integer_digits) {
    		integer_to_truncate.add(s);
    	}
    	
    	int counter = integer_to_truncate.size();
    	StringBuilder sb;
    	//chopping off digits starting at the right hand side
    	for(int i=0; i<counter-1; i++) {
    		
    		//we're always removing the right most index, aka the size -1
    		integer_to_truncate.remove(integer_to_truncate.size()-1);
    		sb = new StringBuilder();
    		
    		for(String s : integer_to_truncate) {
    			sb.append(s);
    		}
    		permutations.add( Integer.parseInt(sb.toString()) );
    		
    	}
    	permutations.add(x);
    	
    	
    	return permutations;
    }
    
    private ArrayList<Integer> generatePrimes(int upper_bound){
    	boolean divisible = false;
    	double bound = 0.0;
    	ArrayList<Integer> primeList = new ArrayList<Integer>();
    	
    	//add two since it's the only even prime
    	primeList.add(2);
    	
    	for(int i=3; i<upper_bound; i+=2){
    		//find the factor bound
    		bound = Math.sqrt(i);
    		divisible = false;
    		
    		for(int j : primeList){
    			//if 'j' is divisible, it's not a prime
    			if(i%j == 0) {
    				divisible = true;
    				break;
    			}
    			//if the number we're checking is greater then the squareroot of 'i'
    			//and we haven't found something divisible
    			//then it's a prime by mathematical law
    			else if((double)j >  bound) {
    				//divisible = true;
    				break;
    			}
    		}
    		//if the number did not became divisible, record it
    		if(!divisible) {
    			primeList.add(i);
    		}
    	}
    	return primeList;
    }
}
