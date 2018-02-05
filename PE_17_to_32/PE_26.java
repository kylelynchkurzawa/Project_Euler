package Project_Euler_Problems;

import java.util.ArrayList;

public class PE_26 {
	private String problem_title = "Reciprocal cycles";
    private int problem_number = 26;
    private boolean completed_successfully = false;

    public PE_26(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        //TODO
        //code for problem
        int limit = 1000;
        double one = 1.0;
        double denominator = 0.0;
        
        ArrayList<Double> fractions = new ArrayList<Double>(); 
        
        for(int i=0; i<limit; i++) {
        	denominator += 1.0;
        	fractions.add((one/denominator));
        }
        
        
        
        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }
}
