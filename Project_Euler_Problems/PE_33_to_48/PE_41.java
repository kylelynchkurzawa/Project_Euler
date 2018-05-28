package PE_33_to_48;

import java.math.BigInteger;
import java.util.ArrayList;

public class PE_41 {
    private String problem_title = "Pandigital Prime";
    private int problem_number = 41;
    private boolean completed_successfully = false;
    private ArrayList<BigInteger> pandigitalNumbers;

    public PE_41(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
        pandigitalNumbers = new ArrayList<BigInteger>();
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        //TODO
        //code for problem

        //can't make a bunch of big ints, freezes system
        //can't make a bunch of primes, takes to long

        //

        int nth_size = 9;
        int limit = 987654321;

        ArrayList<Integer> primeList = generatePrimes(limit);
        System.out.println(primeList);


        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
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
