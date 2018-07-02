package PE_33_to_48;

import java.util.ArrayList;

public class PE_50 {
    private String problem_title = "Consecutive prime sum";
    private int problem_number = 50;
    private boolean completed_successfully = true;

    public PE_50(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        int primeLimit = 1000000;
        int minLimit = 1000;
        ArrayList<Integer> primes = generatePrimes(primeLimit);
        int primeSumNumCount;
        int largestConsecSumPrime=0, numberOfPrimesUsed=0;

        for(int i=primes.size()-1; i>=0; i--){

            if(primes.get(i) < minLimit){
                break;
            }

            primeSumNumCount = countRunningTotalSumNumbers(primes.get(i), primes);

            if(primeSumNumCount != -1) {
                if (primeSumNumCount > numberOfPrimesUsed) {
                    numberOfPrimesUsed = primeSumNumCount;
                    largestConsecSumPrime = primes.get(i);
                }
            }
        }

        System.out.println("Prime number that can be written as a sum with the most primes: "+largestConsecSumPrime+" with "+numberOfPrimesUsed+" primes used.");

        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }

    private int countRunningTotalSumNumbers(int target, ArrayList<Integer> primes){
        int number_of_primes = 0;
        int running_sum;
        int starting_position = 0;
        boolean totalled = false;
        //System.out.println("Testing: "+target);

        while((primes.get(starting_position) < target) && (!totalled)){
            number_of_primes = 0;
            running_sum = 0;
            for(int i=starting_position; i<primes.size(); i++){
                number_of_primes++;
                running_sum+=primes.get(i);

                if(running_sum == target){
                    totalled = true;
                    break;
                }
                else if(running_sum > target){
                    break;
                }
            }

            starting_position++;
        }

        if(totalled){
            return number_of_primes;
        }
        else{
            return -1;
        }


    }

    private ArrayList<Integer> generatePrimes(int upper_bound){
        boolean divisible;
        double bound;
        ArrayList<Integer> primeList = new ArrayList<>();

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
