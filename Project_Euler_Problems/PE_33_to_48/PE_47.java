package PE_33_to_48;

import java.util.ArrayList;

public class PE_47 {
    private String problem_title = "Distinct primes factors";
    private int problem_number = 47;
    private boolean completed_successfully = false;

    public PE_47(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        //TODO
        //code for problem
        int consecutive_integers=2, distinct_prime_factors=2;
        int prime_upper_bound = 100;
        int start_seed = 4;
        boolean found = false;


        ArrayList<Integer> consecutive_candidates = new ArrayList<Integer>();
        ArrayList<Integer> prime_factors_used = new ArrayList<Integer>();
        ArrayList<Integer> factors = null;
        ArrayList<Integer> primes = generatePrimes(prime_upper_bound);

        while(!found){
            consecutive_candidates.clear();
            prime_factors_used.clear();

            for(int i=start_seed; i<start_seed+consecutive_integers; i++){
                consecutive_candidates.add(i);
            }

            for(Integer i : consecutive_candidates){
                factors = getFactors(i);

                for(Integer j : factors){
                    if(primes.contains(j)){

                    }
                }
            }
        }


        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }

    private ArrayList<Integer> getFactors(int product) {
        ArrayList<Integer> factorList = new ArrayList<Integer>();
        int upperbound = product;
        int f1;

        //loop through the integers until you reach the product
        for(int i=2; i<upperbound; i++) {
            //find the first factor by dividing the product by i
            f1 = product / i;
            //if the product can be divided by i evenly, add the factors to the list
            if(product%i == 0) {
                //add the factors to the list, for this problem we want the duplicates to be included
                factorList.add(f1);
                factorList.add(i);

                upperbound = upperbound / i;
            }
        }

        return factorList;
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
