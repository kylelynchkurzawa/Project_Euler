package PE_17_to_32;

import java.math.BigInteger;

public class PE_20 {
    private String problem_title = "Factorial Digit Sum";
    private int problem_number = 20;
    private boolean completed_successfully = true;

    public PE_20(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        String seedString = "100";
        BigInteger seed = new BigInteger(seedString);

        BigInteger factorialSeed = generateFactorial(seed);

        String[] digits = factorialSeed.toString().split("(?!^)");

        long digitSum = 0;
        for(String s :  digits){
            digitSum+= Integer.valueOf(s);
        }

        System.out.println("Sum of digits in the factorial of "+seedString+" is: "+digitSum);

        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }

    private BigInteger generateFactorial(BigInteger seed){
        int seedValue = Integer.valueOf(seed.toString());

        if(seedValue > 1){
            return seed.multiply(generateFactorial(seed.subtract(BigInteger.ONE)));
        }
        else{
            return BigInteger.ONE;
        }
    }
}
