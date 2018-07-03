package PE_26_to_50;

import java.util.ArrayList;

public class PE_46 {
    private String problem_title = "Goldbach's other conjecture";
    private int problem_number = 46;
    private boolean completed_successfully = true;

    public PE_46(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        int upper_bound = 1000000, starting_seed = 9;
        ArrayList<Integer> primeList = generatePrimes(upper_bound);

        while(!isNotGoldbachComposite(primeList, starting_seed)){
            starting_seed+=2;
        }

        System.out.println("Odd Composite number that doesn't conform to Goldbach conjecture: " + starting_seed);


        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }

    private boolean isNotGoldbachComposite(ArrayList<Integer> primes, int test_value){
        boolean isGoldComp = true;
        int difference_from_prime, number_squared;

        //if it's a prime, return false
        if(primes.contains(test_value) || test_value%2==0){
            return false;
        }

        //loop through prime numbers
        for(Integer i : primes){
            //subtract the prime from the value
            difference_from_prime = test_value - i;
            //if the difference is not divisable by two, its not a Goldbach Composite number
            if(difference_from_prime%2 == 0){
                //get half of the difference -> which will be a squared value
                number_squared = difference_from_prime/2;
                //if the squareroot of the above number is an integer, it is a Goldbach Composite number
                if(Math.sqrt((double)number_squared)%1 == 0){
                    return false;
                }
            }
        }

        return isGoldComp;
    }

    private ArrayList<Integer> generatePrimes(int upper_bound){
        boolean divisible = false;
        double bound = 0.0;
        ArrayList<Integer> primeList = new ArrayList<Integer>();

        //add two since it's the only even prime
        primeList.add(2);

        for(int i=3; i<upper_bound; i+=2){
            //find the factor bound
            bound = Math.sqrt(i);
            divisible = false;

            for(int j : primeList){
                //if 'j' is divisible, it's not a prime
                if(i%j == 0) {
                    divisible = true;
                    break;
                }
                //if the number we're checking is greater then the squareroot of 'i'
                //and we haven't found something divisible
                //then it's a prime by mathematical law
                else if((double)j >  bound) {
                    break;
                }
            }
            //if the number did not became divisible, record it
            if(!divisible) {
                primeList.add(i);
            }
        }

        return primeList;
    }
}

