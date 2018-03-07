public class PE_03 {
	
	private String problem_title = "Largest Prime Factor";
    private int problem_number = 03;
    private boolean completed_successfully = true;

    public PE_03(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }
	
	public void run(){
		long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();
		
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
		
		end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
	}
}
