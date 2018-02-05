import java.util.ArrayList;

public class PE_12 {
	public PE_12(){
		System.out.println("Highest Divisable Triangular Number - Unfinished");
	}
	
	public void run(){
		long start = System.currentTimeMillis();
		System.out.println("Started at "+start);
		
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
		
		long finish = System.currentTimeMillis();
		long time = finish - start;
		System.out.print("Finished at "+ finish);
		System.out.println("Executed in "+ time);
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
