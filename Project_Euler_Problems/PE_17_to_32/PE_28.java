package PE_17_to_32;

import java.util.ArrayList;

public class PE_28 {
	private String problem_title = "Number Spiral Diagonals";
    private int problem_number = 28;
    private boolean completed_successfully = true;

    public PE_28(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        int current_width = 3;
        int corner_base = -1;
        int corner1, corner2, corner3, corner4 = -1;
        int max_width = 1001;
        int corner_total_sum = 0;
        ArrayList<Integer> square_corners = new ArrayList<Integer>();
        
        //add the center of the square to the list, and set the corner base to start at one
        square_corners.add(1);
        corner_base = 1;
        
        //keep looping while the current width is is less then or equal to the max_width we're looking for
        while(current_width <= max_width) {
        	//each corner can be found by using the series of
        	// base + ((next width -1)*corner number)
        	
        	//find the new corners and add them to the list
        	corner1 = corner_base + ((current_width -1)*1);
        	corner2 = corner_base + ((current_width -1)*2);
        	corner3 = corner_base + ((current_width -1)*3);
        	corner4 = corner_base + ((current_width -1)*4);
        	
        	square_corners.add(corner1);
        	square_corners.add(corner2);
        	square_corners.add(corner3);
        	square_corners.add(corner4);
        	
        	//set the base to be the last corner found and increase the width by 2 to get to the next layer in the spiral
        	corner_base = corner4;
        	current_width += 2;
        }
        
        //loop through the list and total the corners up
        for(Integer i : square_corners) {
        	corner_total_sum += i;
        }
        
        System.out.println("Sum of all spiral diagonal numbers with a spiral of "+max_width+" by "+max_width+" is: "+corner_total_sum);

        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }
}
