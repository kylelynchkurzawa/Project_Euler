package PE_26_to_50;


import java.util.ArrayList;
import java.util.Collections;

public class PE_49 {
    private String problem_title = "Prime permutations";
    private int problem_number = 49;
    private boolean completed_successfully = true;
    private ArrayList<Integer> numberPermutations;

    public PE_49(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
        numberPermutations = new ArrayList<Integer>();
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        int primeLimit = 10000;
        int primeMin = 1000;
        int desiredPrimePermCount = 3, primeCount;
        ArrayList digits = new ArrayList();
        String[] digitArray;
        ArrayList<Integer> primeList = generatePrimes(primeLimit);
        ArrayList<Integer> uniqueNumberPermutations = new ArrayList<>();
        ArrayList<Integer> sequentialPrimePermutations = new ArrayList<>();

        //remove all low primes
        for(int i=primeList.size()-1; i>=0; i--){
            if(primeList.get(i) < primeMin){
                primeList.remove(i);
            }
        }

        for(Integer i : primeList){
            //clear the digit list and re-populate it
            digits.clear();
            //clear the numberPermutations array
            numberPermutations.clear();
            sequentialPrimePermutations.clear();
            uniqueNumberPermutations.clear();
            //reset the booleans and ints
            primeCount = 0;

            digitArray = String.valueOf(i).split("(?!^)");
            for(String d : digitArray){
                digits.add(d);
            }
            //generate all the permutations of the number
            generateNumberPermutations("", digits);

            //check that there are minimum number of prime permutations
            for(Integer k : numberPermutations){
                if(primeList.contains(k)){
                    primeCount++;
                }
            }

            if(primeCount >= desiredPrimePermCount){
                //remove all the none prime numbers
                for(int k=numberPermutations.size()-1; k>=0; k--){
                    if(!primeList.contains(numberPermutations.get(k))){
                        numberPermutations.remove(numberPermutations.get(k));
                    }
                    else{
                        if(!uniqueNumberPermutations.contains(numberPermutations.get(k))){
                            uniqueNumberPermutations.add(numberPermutations.get(k));
                        }
                    }
                }

                if(uniqueNumberPermutations.size() > 2){
                    //sort the primes
                    Collections.sort(uniqueNumberPermutations);
                    printSequentialPrimes(uniqueNumberPermutations);
                }
            }
        }


        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }

    private void printSequentialPrimes(ArrayList<Integer> primes){
        ArrayList<Integer> sequence = new ArrayList<>();
        int sequence_dif, current;

        for(int i=0; i< primes.size(); i++){
            for(int j=i+1; j< primes.size(); j++){
                sequence_dif = Math.abs(primes.get(j) - primes.get(i));
                sequence.add(primes.get(i));
                sequence.add(primes.get(j));
                current = primes.get(j);

                for(int k=j+1; k< primes.size(); k++){
                    if(Math.abs(primes.get(k) - current) == sequence_dif){
                        sequence.add(primes.get(k));
                        current = primes.get(k);
                    }
                }

                //not a sequence if there's only elements 'i'and 'j'
                if(sequence.size() > 2){
                    System.out.println("Increasing Sequence with diff of "+sequence_dif+": "+sequence);
                }

                sequence.clear();
            }
        }
    }

    private void generateNumberPermutations(String number, ArrayList<String> digits){
        if(digits.size() <= 0){
            return;
        }
        else if(digits.size() == 1){
            String newNum = number+digits.get(0);
            numberPermutations.add(Integer.valueOf(newNum));
        }
        else if(digits.size() > 1){
            ArrayList<String> digitsCopy = new ArrayList<>();

            for(String d : digits){
                digitsCopy.addAll(digits);
                Collections.copy(digitsCopy, digits);
                digitsCopy.remove(d);

                generateNumberPermutations((number+d), digitsCopy);
                digitsCopy.clear();
            }
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
