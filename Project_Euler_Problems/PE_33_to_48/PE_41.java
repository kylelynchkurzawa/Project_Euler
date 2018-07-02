package PE_33_to_48;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PE_41 {
    private String problem_title = "Pandigital Prime";
    private int problem_number = 41;
    private boolean completed_successfully = false;
    private ArrayList<String> permutations;

    public PE_41(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        //TODO
        //code for problem

        //can't make a bunch of big ints, freezes system
        //can't make a bunch of primes, takes too long

        //so we should make a bunch of pandigitals?

        ArrayList<Long> primes = generatePrimes((long)10000000);
        String source = "987654321";
        generatePermutations(source);

        //sort the list of permutations
        Collections.sort(this.permutations);

        //clean the list and remove all even numbers
        for(int i=this.permutations.size()-1; i>=0; i--){
            if(Integer.valueOf(this.permutations.get(i))%2 == 0){
                this.permutations.remove(i);
            }
        }

        for(int i=this.permutations.size()-1; i>=0; i--){
            System.out.println("Testing: "+permutations.get(i));
//            for(Long l : primes){
//                if(Long.valueOf(permutations.get(i)) == l){
//                    //do nothing
//                }
//                else if((Long.valueOf(this.permutations.get(i)))%l == 0){
//                    this.permutations.remove(i);
//                    break;
//                }
//            }
        }



        System.out.println("Size of permutation list: "+this.permutations.size());


        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }

    private void generatePermutations(String src){
        this.permutations = new ArrayList<String>();
        String[] source = src.split("(?!^)");
        ArrayList<String> digits = new ArrayList<>();

        for(String s : source){
            digits.add(s);
        }

        generatePermutationsV2("", digits);
    }

    private void generatePermutationsV2(String seed, List<String> src){
        //check if there's only one character left to iterate over
        if(src.size() == 1){
            for(String s : src){
                this.permutations.add((seed.concat(s)));
            }
        }
        else{
            //choose a character to use as a base
            for(String s : src){
                //remove the chosen character from the src
                List<String> editedSrc = new ArrayList<>();
                editedSrc.addAll(src);
                editedSrc.remove(s);

                //pass into the method again with the removed letter added to the seed
                generatePermutationsV2(seed.concat(s), editedSrc);
            }
        }
    }


    private boolean isPandigital(int nth, BigInteger target){
    	boolean isPan = true;
		String s_target = target.toString();

		if(s_target.contains(String.valueOf(0))){
		    return false;
        }

		for(int i=1; i<=nth; i++){
			if(!s_target.contains(String.valueOf(i))){
				return false;
			}
		}
		return isPan;
	}

    private ArrayList<Integer> generatePrimesVer2(int upper_bound){
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        ArrayList<Integer> primeList = new ArrayList<Integer>();
        for(int i=2; i<=upper_bound; i++){
            numberList.add(i);
            primeList.add(i);
        }

        for(int i=0; i<numberList.size(); i++){
            for(int j=0; j<primeList.size(); j++){
                if(primeList.get(j) == numberList.get(i)){
                    //do nothing
                }
                else if(primeList.get(j)%numberList.get(i) == 0){
                    primeList.remove(primeList.get(j));
                }
            }
            numberList.remove(numberList.get(i));
        }

        return primeList;
    }

    private ArrayList<Long> generatePrimes(long upper_bound){
        boolean divisible = false;
        double bound = 0;
        ArrayList<Long> primeList = new ArrayList<Long>();

        //add two since it's the only even prime
        //primeList.add((long)2);

        for(long i=3; i<upper_bound; i+=2){
            //find the factor bound
            bound = Math.sqrt(i);
            divisible = false;

            for(long j : primeList){
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
