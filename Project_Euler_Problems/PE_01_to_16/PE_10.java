package PE_01_to_16;

import java.util.ArrayList;

public class PE_10 {
	private String problem_title = "Summation of Primes";
    private int problem_number = 10;
    private boolean completed_successfully = true;

    public PE_10(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }
	public void run(){
		long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();
		
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		long prime_limit = 2000000L;
		long prime_sum = 0L;
		
		boolean divisable = false;
		
		for(int i=2; i<prime_limit; i++){
			divisable = false;
			
			for(int j=0; j<primeList.size(); j++){
				if(i%primeList.get(j) == 0){
					divisable = true;
					break;
				}
			}
			
			if(!divisable){
				primeList.add(i);
				prime_sum = prime_sum + i;
			}
		}
		
		System.out.println(primeList);
		System.out.println(prime_sum);
		
		end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
	}
}
