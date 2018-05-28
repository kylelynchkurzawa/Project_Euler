package PE_01_to_16;

public class PE_06 {
	private String problem_title = "Sum Square Difference";
    private int problem_number = 06;
    private boolean completed_successfully = true;

    public PE_06(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }
	
	public void run(){
		long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();
		
		long naturalNumberLimit = 100;
		
		long sumOfSquares = sumOfSquares(naturalNumberLimit);
		long squareOfSum = squareOfSums(naturalNumberLimit);
		
		long difference = squareOfSum - sumOfSquares;
		
		System.out.println("Sum Square Difference for the first "+naturalNumberLimit+" natural numbers is: "+difference);
		
		end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
	}
	
	private long sumOfSquares(long x){
		long z = 0;
		
		for(int i=1; i<=x; i++){
			z = z + (i*i);
		}
		
		return z;
	}
	
	private long squareOfSums(long x){
		long z = 0;
		
		for(int i=1; i<=x; i++){
			z = z + i;
		}
		
		return (z*z);
	}
}
