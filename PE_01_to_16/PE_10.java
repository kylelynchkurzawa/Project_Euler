import java.util.ArrayList;

public class PE_10 {
	public PE_10(){
		System.out.println("Summation of Primes - Revisit");
	}
	
	public void run(){
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
	}
}
