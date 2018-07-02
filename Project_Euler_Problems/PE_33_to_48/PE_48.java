package PE_33_to_48;

import java.math.BigInteger;

public class PE_48 {
    private String problem_title = "Self powers";
    private int problem_number = 48;
    private boolean completed_successfully = true;

    public PE_48(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        int limit = 1000, trailing_digits = 10;
        double sigma_sum;
        String s_squared, s_sigma_sum="0";
        BigInteger big_num_squared;

        for(int i=1; i<=limit; i++) {
            big_num_squared = new BigInteger(String.valueOf(i)).pow(i);
            s_squared = big_num_squared.toString();

            //check if the squared number is too big
            if (s_squared.length() > trailing_digits) {
                //cut down the string before adding
                s_squared = s_squared.substring(s_squared.length() - trailing_digits);
            }

            //add them
            sigma_sum = Double.valueOf(s_squared) + Double.valueOf(s_sigma_sum);
            s_sigma_sum = String.format("%.0f", sigma_sum);

            //if the sum has more digits then what were looking for, trim it down
            if (s_sigma_sum.length() > trailing_digits) {
                s_sigma_sum = s_sigma_sum.substring(s_sigma_sum.length() - trailing_digits);
            }
        }

        System.out.println("Last "+trailing_digits+" trailing digits of the running self power sum is: "+s_sigma_sum);


        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }
}
