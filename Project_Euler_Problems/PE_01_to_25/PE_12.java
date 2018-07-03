package PE_01_to_25;

public class PE_12 {
	private String problem_title = "Highest Divisible Triangular Number";
    private int problem_number = 12;
    private boolean completed_successfully = false;

    public PE_12(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }
	public void start(){
		long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        boolean found = false;
        int starting_seed=10000;
        int target = 500;
        int factorCount;

        while(!found){
			factorCount = getNumberOfFactors(generateTriangleNumber(starting_seed));
			if(factorCount >= target){
				System.out.println("First Triangle Number with "+target+" factors is: "+generateTriangleNumber(starting_seed));
				break;
			}
			else{
				System.out.println(factorCount);
				starting_seed++;
			}

		}

		
		end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
	}

	public int generateTriangleNumber(int seed){
    	int tri = 0;
    	for(int i=1; i<=seed; i++){
    		tri+=i;
		}
		return tri;
	}

	public int getNumberOfFactors(int original_number){
    	int factorcount = 0;
    	int loop_number = original_number;
    	for(int i=1; i<=loop_number; i++){
    		if(original_number%i == 0){
				factorcount++;
			}
		}

		return factorcount;
	}

}
