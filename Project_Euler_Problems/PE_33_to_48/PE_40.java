package PE_33_to_48;

public class PE_40 {
    private String problem_title = "Champernowne's Constant";
    private int problem_number = 40;
    private boolean completed_successfully = true;

    public PE_40(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        int exponent_limit = 7;
        int limit = 1000000;
        
        //can start the product on 1 since the first one found is always 1
        int product = 1;
        int current_factor = 1;
        int length_count = 1;
        
        for(int i=1; i< limit; i++) {
        	
        	//if the length count is greater then or equal to the limit, break
        	if(length_count > limit) {
        		break;
        	}
        	//loop through each digit that we are going to add
        	for(String s : String.valueOf(i).split("(?!^)")) {
        		
        		//if the current length count == 10^x (which is a position we are looking for)
        		//need to multiply it to the ongoing product
        		if(length_count == (int)Math.pow(10, current_factor)) {
        			
        			//System.out.println("Found the digit at position: "+Math.pow(10, current_factor)+", it's: "+s);
        			product *= Integer.parseInt(s);
        			//increment the exponent
        			current_factor++;
        		}
        		length_count++;
        	}
        }
        
        System.out.println("\nProduct of digits at positions: ");
        for(int i=0; i<exponent_limit; i++) {
        	System.out.print("d_"+(int)(Math.pow(10, i))+" ");
        }
        System.out.println("\nin Champernowne's Constant is: "+product+"\n");
        
        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }
}
