package PE_01_to_25;

public class PE_01 {

	private String problem_title = "Sum of multiples of 3 and 5";
    private int problem_number = 01;
    private boolean completed_successfully = true;

    public PE_01(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }
	
	public void run(){
		long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();
		
		int sum = 0;
		
		for(int i=0; i<1000; i++){
			if((i%3 == 0) || (i%5 == 0)){
				sum += i;
			}
		}
		
		System.out.println(sum);
		
		end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
	}
}
