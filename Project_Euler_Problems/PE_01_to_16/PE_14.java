package PE_01_to_16;

public class PE_14 {
	private String problem_title = "Longest Collatz Sequence";
    private int problem_number = 14;
    private boolean completed_successfully = false;
    private int sequenceLength = 1;

    public PE_14(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }
	public void start(){
		long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();
		
		long starting_seed = 1;
		long limit = 1000000;
		long current=starting_seed;
		long record_seed=0, record_length=0;

		while(starting_seed < limit){

			//check if we finished the collatz seq.
			if(current==1){
				if(sequenceLength > record_length){
					record_length = sequenceLength;
					record_seed = starting_seed;
				}

				starting_seed++;
				sequenceLength = 1;
				current = starting_seed;

//				System.out.println("Now testing starting seed: "+starting_seed);
			}
			//if current is even
			else if(current%2 == 0){
				current = nextCollatzFromEvenNum(current);
				sequenceLength++;
			}
			else{
				current = nextCollatzFromOddNum(current);
				sequenceLength++;
			}

		}

		System.out.println("Starting number with the longest sequence under "+limit+" is: "+record_seed+" with a sequence length of "+record_length);
		
		end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
	}
		
	private long nextCollatzFromEvenNum(long x){
		return (x/2);
	}
	
	private long nextCollatzFromOddNum(long x){
		return ( (3*x) + 1);
	}
}
