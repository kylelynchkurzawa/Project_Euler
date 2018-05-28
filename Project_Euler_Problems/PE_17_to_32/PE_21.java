package PE_17_to_32;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PE_21 {
    private String problem_title = "Amicable Numbers";
    private int problem_number = 21;
    private boolean completed_successfully = true;
    
    public PE_21(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem 21");
        start_time = System.currentTimeMillis();

        //create a hash table to store our numbers sorted by the sum of whole divisors
        //and store their respective integer in the arraylist
        HashMap<Integer, ArrayList<Integer>> myMap = new HashMap<Integer, ArrayList<Integer>>();
        int upper_exclusive_limit = 10000;
        int divisor_sum;
        ArrayList<Integer> divisor_sum_hashtable_array;

        //loop through all the numbers below 10k
        for(int i=1; i<upper_exclusive_limit; i++){
            //get the sum of their even divisors
            divisor_sum = sum_of_whole_divisors(i);

            //if the sum is already in the map, add the value to the arraylist containing the values
            if(myMap.containsKey(divisor_sum)){
                //get the array list holding the key's members and add 'i' to it
                divisor_sum_hashtable_array = myMap.get(divisor_sum);
                divisor_sum_hashtable_array.add(i);

                //replace the arraylist at the key with the updated arraylist
                myMap.replace( divisor_sum, divisor_sum_hashtable_array );
            }
            //else create the arraylist that will hold it and it's fellow amicable numbers (if any)
            else{
                //create the arraylist to hold the sum's members and add i to it
                divisor_sum_hashtable_array = new ArrayList<Integer>();
                divisor_sum_hashtable_array.add(i);

                //set the value at key divisor_sum with the new arraylist
                myMap.put(divisor_sum, divisor_sum_hashtable_array);
            }
        }

        int final_sum_of_amicable_numbers = 0;
        ArrayList<Integer> value_list_1, value_list_2;

        //loop through each map entry in the map using a for each loop
        for (Map.Entry<Integer, ArrayList<Integer>> mapEntry: myMap.entrySet() ) {

            value_list_1 = mapEntry.getValue();

            //'i' will be the key of the entry set for value_list_2
            for( Integer i : value_list_1){
                if(myMap.containsKey(i)){

                    //at this point we know the value of 'i' is a key in the map
                    //so we need to check if the KEY of value 'i' is listed in the 2nd value list
                    value_list_2 = myMap.get(i);

                    //but first check that the 2 lists arent the same, must avoid checking the same value twice
                    if(!value_list_2.equals(value_list_1)){

                        if(value_list_2.contains(mapEntry.getKey())){
                            //if the list contains the KEY of 'i' at this point, then they are an Amicable pair
                            //and the value of i can be added to the sum
                            final_sum_of_amicable_numbers += i;
                        }
                    }
                }
            }
        }

        System.out.println("Total sum of Amicable Numbers: "+final_sum_of_amicable_numbers);

        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finished problem: "+time_elapsed);
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
