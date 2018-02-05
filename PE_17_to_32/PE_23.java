package Project_Euler_Problems;

import java.util.ArrayList;

public class PE_23 {
    private String problem_title = "Non-Abundant Sums";
    private int problem_number = 23;
    private boolean completed_successfully = false;

    public PE_23(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        //TODO
        //code for problem
        int upper_limit = 28123;
        int divider_sum;
        ArrayList<Integer> abundant_numbers = new ArrayList<Integer>();

        for(int i=1; i<upper_limit; i++){
            divider_sum = sum_of_whole_divisors(i);
            if(divider_sum > i){
                //System.out.println("Found an abundant number with: "+i +" with a divider sum of: "+divider_sum);
                abundant_numbers.add(i);
            }
        }

        System.out.println(abundant_numbers);
        System.out.println(abundant_numbers.size());

        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }

    private int sum_of_whole_divisors(int x){
        //every number is divisable by 1 so sum is always starting at 1
        int sum = 1;
        int limit = x;

        //handle values less than or equal to 0 just in case
        if(x<=0){
            return 1;
        }

        for(int i=2; i<limit; i++){
            if(x%i == 0){
                //System.out.println("Found an even divisor: "+ i +" with "+(x/i));
                sum = sum + (x/i) + i;
                //System.out.println(sum);
                limit = (x/i);
            }
        }
        //System.out.println("Sum of divisors: "+sum);
        return sum;
    }
}
