package PE_33_to_48;

import java.util.ArrayList;

public class PE_35 {
    private String problem_title = "Circular Primes";
    private int problem_number = 35;
    private boolean completed_successfully = true;
    
    public PE_35(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        int upper_bound = 1000000;
        ArrayList<Integer> primeList = generatePrimes(upper_bound);
        int circularPrimeCount = 0;
        
        //loop through all prime numbers and check if they're circular
        for(int i : primeList) {
        	if(isCircularPrime(i, primeList)) {
        		circularPrimeCount++;
        	}
        }
        
        System.out.println("Number of Circular Primes under "+upper_bound+" is: "+circularPrimeCount);
        
        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }
    
    private boolean isCircularPrime(int primeNumber, ArrayList<Integer> primeList){
    	boolean rotationPresent = true;
    	//create a list of the rotated numbers
    	ArrayList<String> rotated_permutations = generator(String.valueOf(primeNumber));
    	
    	//loop through the list of rotated and check if all are present in the prime list
    	for(String s : rotated_permutations) {
    		if(!primeList.contains(Integer.parseInt(s))) {
    			rotationPresent = false;
    			break;
    		}
    	}
    	
    	return rotationPresent;
    }
    
    //rotate the elements around
    public ArrayList<String> generator(String prime) {
    	//if passed in a single digit number, just return it back in a list
    	if(prime.length() <= 1) {
    		ArrayList<String> default_list = new ArrayList<String>();
    		default_list.add(prime);
    		return default_list;
    	}
    	
    	ArrayList<String> finished_rotated_permutations = new ArrayList<String>();
    	
    	String prime_to_edit = prime;
    	String last_char, new_prime_rotation;
    	
    	for(int i=0; i<prime.length(); i++) {
    		//get the last character
    		last_char = prime_to_edit.substring(prime_to_edit.length()-1);
    		
    		//and create a new 'prime' using the last character as the first and concatenating the rest onto it
    		new_prime_rotation = last_char.concat(prime_to_edit.substring(0, prime_to_edit.length()-1));
    		
    		//record the new prime and set the old 'prime_to_edit' equal to the new one
    		finished_rotated_permutations.add(new_prime_rotation);
    		prime_to_edit = new_prime_rotation;
    	}
    	
    	return finished_rotated_permutations;
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
