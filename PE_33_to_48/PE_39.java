package Project_Euler_Problems;

public class PE_39 {
    private String problem_title = "Integer Right Triangles";
    private int problem_number = 39;
    private boolean completed_successfully = true;

    public PE_39(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        int max_solution_num=0, max_num_of_solutions=0;
        int testing_solution_num, testing_num_of_solutions, testing_hyp;
        int max_perimeter = 1000; //inclusive
        
        //loop through the different perimeter sizes
        for(int i=1; i<max_perimeter-1; i++){
        	testing_solution_num = i;
        	testing_num_of_solutions = 0;
        	
        	//loop through the different adj lengths
        	for(int j=1; j<i; j++) {
        		//and loop through the different opp lengths
        		for(int k=1; k<i-j; k++) {
        			
        			//using the adj, and opp, find hyp
        			testing_hyp = getHypotenuseLength(j, k);
        			
        			if(testing_hyp != -1 && isTotalEqualToPerimeter(j, k, testing_hyp, i)) {
        				testing_num_of_solutions++;
        			}
        		}
        	}
        	
        	if(testing_num_of_solutions > max_num_of_solutions) {
        		max_num_of_solutions = testing_num_of_solutions;
        		max_solution_num = testing_solution_num;
        	}
        }
        
        System.out.println("Perimeter with the highest number of solutions is: "+max_solution_num+" with "+max_num_of_solutions+" ways of making a right angle.");

        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }
    
    private boolean isTotalEqualToPerimeter(int adj, int opp, int hyp, int per) {
    	if( (adj+opp+hyp) == per){
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    private int getHypotenuseLength(int adj, int opp) {
    	//get the length of the hyp of the right angle triangle
    	double hyp = Math.sqrt( ((double) (adj*adj)) + ((double) (opp*opp)) );
    	
    	//if the hyp is an integer return it
    	if(hyp%1 == 0) {
    		return (int)hyp;
    	}
    	//else reutrn -1 to indicate this triangle has a non-integral side
    	else {
    		return -1;
    	}
    }
    
    
    
}
