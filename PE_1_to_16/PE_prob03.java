public class PE_prob03 {
	public PE_prob03(){
		System.out.println("Largest Prime Factor");
	}
	
	public void run(){
		
		long value = 600851475143L;
		int primeNum = 0;
		
		for(int i=1; i<value; i++){
			
			boolean isPrime = true;
			
			//find if it is a prime
			for(int j=2; j<i; j++){
				if(i%j == 0){
					isPrime = false;
					break;
				}				
			}//end inner for
			
			//f it is a prime
			if(isPrime){
				
				//check if its a factor
				if(value%i == 0){
					//divide value (lowers bound in for loop btw!!!)
					value = value/i;
				}
				
				//check if it's the same as value
				if(value/i == 1){
					//found our largest prime factor
					primeNum = (int) value;
				}
			}
			
		}//end outer for
				
		System.out.println(primeNum);
	}
}
