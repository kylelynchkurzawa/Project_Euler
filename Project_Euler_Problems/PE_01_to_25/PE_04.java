package PE_01_to_25;

public class PE_04 {
	private String problem_title = "Largest Palindrome Product";
    private int problem_number = 04;
    private boolean completed_successfully = true;

    public PE_04(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }
	
	public void run(){
		long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();
		
		int lowerBound = 99;
		int upperBound = 999;
		
		int val1 = -1;
		int val2= -1;
		int pallindromeProduct = -1;
		
		for(int i=upperBound-1; i>lowerBound; i--){
			
			for(int j=upperBound-1; j>lowerBound; j--){
				
				int product = i*j;
				
				if(isPallindrome(Integer.toString(product).toCharArray())){
					if(product> pallindromeProduct){
						val1 = i;
						val2 = j;
						pallindromeProduct = product;
					}					
				}				
			}
		}
		
		System.out.println("Value 1: "+val1+"Value 2: "+val2);
		System.out.println("Product: "+(val1*val2));
		
		end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
	}
	
	private boolean isPallindrome(char[] x){
		boolean b = true;
		
		for(int i=0; i<x.length; i++){
			if(x[i] != x[x.length-1-i]){
				b = false;
			}
		}
		
		return b;
	}
}
