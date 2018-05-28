package PE_01_to_16;

import java.util.ArrayList;

public class PE_12 {
	private String problem_title = "Highest Divisible Triangular Number";
    private int problem_number = 12;
    private boolean completed_successfully = false;

    public PE_12(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }
	public void run(){
		long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();
		
		boolean found = false;
		long factorLimit = 500L;
		long triangular_test = 1L;
		long counter = 30000L;
		long num_of_factors = 0L;;
		
		while(!found){
			
			triangular_test = NthTriangularNumber(counter);
			num_of_factors = returnnumberOfFactors(triangular_test);
			
			System.out.println("Testing: "+counter+"th and "+triangular_test+" with num of factors: "+num_of_factors);
			
			if(num_of_factors > factorLimit){
				found = true;
				System.out.println("First number with greater then "+ factorLimit+" divisors is: "+triangular_test);
				System.out.println("Factors of: "+triangular_test);
				System.out.println(factorList(triangular_test));
			}
			else{
				counter++;
			}
			
		}
		
		end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
	}
	
	public ArrayList<Long> factorList(long x){
		ArrayList<Long> factors = new ArrayList<Long>();
		
		for(long i=1L; i<=x; i++){
			if(x%i == 0){
				factors.add(i);
			}
		}
		
		return factors;
	}
	
	public long returnnumberOfFactors(long x){
		long count = 0;
		
		for(long i=1L; i<=x; i++){
			if(x%i == 0){
				count = count + 1;
			}
		}
		
		return count;
	}
	
	public long NthTriangularNumber(long x){
		long z = 0;
		
		for(long i=1L; i<=x; i++){
			z = z + i;
		}
		
		return z;
	}
}
