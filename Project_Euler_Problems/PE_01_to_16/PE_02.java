package PE_01_to_16;

public class PE_02 {
	
	private long lastVal;
	private long secLastVal;
	private String problem_title = "Sum of even fibanacci numbers";
    private int problem_number = 02;
    private boolean completed_successfully = true;

    public PE_02(){
		this.lastVal = 1;
		this.secLastVal = 2;
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }
	
	public void run(){
		long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();
		
		long limit = 4000000;
		long newVal = 0;
		 
		long sum = 0 + this.secLastVal;
		 
		//loop until you reach the limit
		while(this.secLastVal <= limit){
			//find the new value
			newVal = this.lastVal + this.secLastVal;
			System.out.println(newVal);
			
			//asssign the values
			this.lastVal = this.secLastVal;
			this.secLastVal = newVal;
			 
			//do not exceed limit
			if(this.secLastVal > limit){
				break;
			}
			//if you don't exceed limit
			else{
			//check if even
				if(this.secLastVal%2 == 0){
					System.out.println("Even number: "+this.secLastVal);
			 
					sum = sum + this.secLastVal;
				}
			}
		}//end while
		 
		System.out.println("Total: "+sum);
		
		end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
	}
}
