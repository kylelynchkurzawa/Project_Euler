package PE_26_to_50;

import java.util.ArrayList;

public class PE_45 {
    private String problem_title = "Triangular, pentagonal, and hexagonal";
    private int problem_number = 45;
    private boolean completed_successfully = true;

    public PE_45(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        //TODO
        //code for problem
        int seed =1, limit=200000, found=0, goal=3;
        ArrayList<Long> triNumberList = new ArrayList<Long>();
        ArrayList<Long> pentNumberList = new ArrayList<Long>();
        ArrayList<Long> hexNumberList = new ArrayList<Long>();

        while(seed < limit){
            triNumberList.add(getTriangleNumber(seed));
            pentNumberList.add(getPentagonalNumber(seed));
            hexNumberList.add(getHexagonalNumber(seed));
            seed++;
        }

        for(Long i : triNumberList){
            if(pentNumberList.contains(i) && hexNumberList.contains(i)){
                System.out.println("Found a Triangle Number that's also a Pentagonal and Hexagonal Number: "+i);
                found++;
                if(found == goal){
                    break;
                }
            }
        }

        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }

    private long getTriangleNumber(int seed){
        long l_seed = (long)(seed);
        return (l_seed*(l_seed +1))/2;
    }
    private long getPentagonalNumber(int seed){
        long l_seed = (long)(seed);
        return (l_seed*((3*l_seed) -1))/2;
    }
    private long getHexagonalNumber(int seed){
        long l_seed = (long)(seed);
        return ((l_seed*((2*l_seed)-1)));
    }
}
