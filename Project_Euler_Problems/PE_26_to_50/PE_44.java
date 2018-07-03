package PE_26_to_50;

import java.util.ArrayList;

public class PE_44 {
    private String problem_title = "Pentagon numbers";
    private int problem_number = 44;
    private boolean completed_successfully = true;

    public PE_44(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        boolean found = false;
        int seed=1, limit=4000;
        int difference=0, p1, p2;
        ArrayList<Integer> pentagonalList = new ArrayList<>();

        while(seed < limit){
            pentagonalList.add(getPentagonalNumber(seed));
            seed++;
        }

        for(int i=0; i<pentagonalList.size(); i++){
            p1=pentagonalList.get(i);

            for(int j=i+1; j<pentagonalList.size(); j++){
                p2=pentagonalList.get(j);
                if(pentagonalList.contains(p1+p2) && pentagonalList.contains(Math.abs(p1-p2))){
                   difference = Math.abs(p1-p2);
                   found=true;
                   break;
                }
            }
            if(found){
                break;
            }
        }

        if(found){
            System.out.println("Difference between pentagonal pair is: "+difference);
        }
        else{
            System.out.println("Did not find the pair with a limit of: "+limit);
        }

        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }

    private int getPentagonalNumber(int seed){
        return (seed*(3*seed -1))/2;
    }
}
