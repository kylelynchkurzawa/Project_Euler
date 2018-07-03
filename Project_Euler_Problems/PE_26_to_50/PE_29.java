package PE_26_to_50;

import java.util.ArrayList;

public class PE_29 {
	private String problem_title = "Distinct Powers";
    private int problem_number = 29;
    private boolean completed_successfully = true;

    public PE_29(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        int min_a_boundary = 2;
        int max_a_boundary = 100;
        int min_b_boundary = 2;
        int max_b_boundary = 100;

        double newest_power = -1;
        
        ArrayList<Double> powers_list = new ArrayList<Double>();
        
        //loop through the values for a in a^b
        for(int i=min_a_boundary; i<=max_a_boundary; i++) {
        	//loop through the values for b in a^b
        	for(int j=min_b_boundary; j<=max_b_boundary; j++) {
        		
        		//get the result a^b
        		newest_power = x_to_the_power_of_y(i, j);
        		
        		//if the list doesn't contain the new result, add it
        		if(!powers_list.contains(newest_power)) {
        			powers_list.add(newest_power);
        		}
        	}
        }
        
        System.out.println("Number of distinct powers for ranges for a^b is: "+powers_list.size());
        System.out.println("where a's range is: "+min_a_boundary+" <= a <= "+max_a_boundary);
        System.out.println("and where b's range is: "+min_b_boundary+" <= b <= "+max_b_boundary);
        
        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }
    
    private double x_to_the_power_of_y(int x, int y) {
    	return (Math.pow(x, y));
    }
}
