package PE_01_to_16;

public class PE_14 {
	private String problem_title = "Longest Collatz Sequence";
    private int problem_number = 14;
    private boolean completed_successfully = false;

    public PE_14(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }
	public void run(){
		long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();
		
		int startingPoint = 2;
		int startingPointLimit = 1000000;
		
		int leadingPoint=0, leadingChainLength=0;
		int currentPoint = startingPoint, currentChainLength=1;
		int currentPointValue;
		
		//int temp = 0;
		
		while(currentPoint < startingPointLimit){
			
			currentPointValue = currentPoint;
			currentChainLength=1;
			
			//System.out.println("Testing number: "+currentPoint);
			
			while((currentPointValue != 1) && (currentPointValue > 0)){
				
				if(currentPointValue%2 == 0){
					currentPointValue = nextCollatzFromEvenNum(currentPointValue);					
					currentChainLength++;
					//System.out.println("Value is even, testing: "+currentPointValue);
					//temp = How_Many_Times_Can_Be_Halfed(currentPointValue);
					//currentPointValue  = Halfed_X_Times(currentPointValue, temp);
					//currentChainLength = currentChainLength + temp;
				}
				else{
					//System.out.println("Value is odd, testing: "+currentPointValue);
					currentPointValue = nextCollatzFromOddNum(currentPointValue);
					currentChainLength++;
				}				
				
			}
			
			if(currentChainLength > leadingChainLength){
				leadingChainLength = currentChainLength;
				leadingPoint = currentPoint;
				System.out.println("New Longest Chain starting point: "+ leadingPoint);
				System.out.println("New Longest Chain length : "+ leadingChainLength+"\n");
			}
			
			currentPoint++;
		}
		
		System.out.println("Leading Collatz value: "+leadingPoint+" with a chain of "+leadingChainLength);
		
		end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
	}
	
	@SuppressWarnings("unused")
	private int Halfed_X_Times(int x, int z){
		int y = x;
		
		for(int i=0; i<z; i++){
			y = y/2;
		}
		
		return y;
	}
	
	@SuppressWarnings("unused")
	private int How_Many_Times_Can_Be_Halfed(int x){
		int y = x;
		int z = 0;
		//System.out.println("Counting number of times can be halfed for "+x);
		while((y%2==0) && (y!=0)){
			y = y/2;
			//System.out.println("Currently at: "+y);
			z++;
		}
		//System.out.println("Times can be halfed "+z);
		return z;
	}
		
	private int nextCollatzFromEvenNum(int x){
		return (x/2);
	}
	
	private int nextCollatzFromOddNum(int x){
		return ( (3*x) + 1);
	}
}
