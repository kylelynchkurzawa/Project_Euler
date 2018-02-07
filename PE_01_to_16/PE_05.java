
public class PE_05 {
	private String problem_title = "Smallest Multiple from 1 to X";
    private int problem_number = 05;
    private boolean completed_successfully = true;

    public PE_05(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }
	public void run(){
		long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();
		
		long upperbound = 20;
		long test = upperbound;
		boolean found = false;
				
		while(true){
			for(long i=upperbound; i>1; i--){
				if(test%i != 0){
					break;
				}
				if((i==2) && (test%i==0)){
					found = true;
				}
			}
			if(found){
				break;
			}
			else{
				test = test + upperbound;
			}
		}
		
		System.out.println("Evenly Divisable by first 20 integers: "+test);
		
		end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
	}
}
