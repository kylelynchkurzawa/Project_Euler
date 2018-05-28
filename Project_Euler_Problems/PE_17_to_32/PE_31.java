package PE_17_to_32;

import java.util.ArrayList;

public class PE_31 {
	private String problem_title = "Coin Sums";
    private int problem_number = 31;
    private boolean completed_successfully = false;

    private ArrayList<String> combinations;
    public PE_31(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
        combinations = new ArrayList<String>();
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        //credit goes to for a dynamic solution to just get the number of combinations
        //http://www.mathblog.dk/project-euler-31-combinations-english-currency-denominations/
        int targetInCents = 200;
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
        int[] combos = new int[targetInCents+1];
        
        //must set the first entry to be 1
        //to give back 
        combos[0] = 1;
        
        //loop through the number of coins available
        for(int i=0; i<coins.length; i++) {
        	
        	//loop through the list of of coins starting at i, and ending at (and including) the target value to give in change
        	//so very first iteration will be from j=1, to j=200
        	for(int j=coins[i]; j<= targetInCents; j++) {
        		
        		//so very first call of the loop, where i is 0 
        		//first, combos[1] = combos[1] + combos[1-coins[0]] => 1
        		//second, combos[2] = combos[2] + combos[2-coins[0]] => 1
        		//third, combos[3] = combos[3] + combos[3-coins[0]] => 1
        		//fourth, combos[4] = combos[4] + combos[4-coins[0]] => 1
        		//fifth, combos[5] = combos[5] + combos[5-coins[0]] => 1
        		
        		//on second call of this loop, where i is 1
        		//first iteration, combos[2] = combos[2] + combos[2-coins[1]] => 2
        		//second, combos[3] = combos[3] + combos[3-coins[1]] => 2
        		//third, combos[4] = combos[4] + combos[4-coins[1]] => 2
        		//fourth, combos[5] = combos[5] + combos[5-coins[1]] => 3
        		
        		//on third call of this loop, where i is 2
        		//first iteration, combos[5] = combos[5] + combos[5-coins[2]] => 4
        		combos[j] += combos[j - coins[i]];
        	}
        }
        
        System.out.println("Number of combinations to give "+targetInCents+" european cents in change: "+combos[combos.length-1]);
        /*-------------------------------------------------------------------------------------------*/
        
        //credit for getting all change combinations to 
        //https://www.youtube.com/watch?v=3VBjhiKUtmE
//        int[] coins = {200, 100, 50, 20, 10, 5, 2, 1};
//        int[] counts = new int[coins.length];
//        int totalAmount = 500;
//        changeCombination(coins, counts, 0, totalAmount);
//        
//        for(int i=0; i<combinations.size(); i++) {
//        	System.out.println("Combination "+(i+1)+" for giving �"+totalAmount+" cents in change:	"+combinations.get(i));
//        }
//        
//        System.out.println("Total number of combinations for "+totalAmount+" in change is: "+combinations.size());
        
        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }
    
    //coins[] is the list of coins we have available
    //counts[] is the list of how many of each coin we are using
    //startindex is the position in our coin list to start making combinations with
    //totalAmount is the value we have to reach
    @SuppressWarnings("unused")
	private void changeCombination(int[] coins, int[] counts, int startIndex, int totalAmount) {
    	
    	//if the start index is the same or greater then the number of coins available to use, then we're finished with this combination
    	//so record it
    	if(startIndex>= coins.length) {
    		//create a string builder and make our string listing how many of each coin we use to get to our target
    		StringBuilder sb = new StringBuilder();
    		
    		for(int i=0; i<coins.length; i++) {
    			sb.append(counts[i]+"*"+coins[i]+" + ");
    		}
    		sb.delete(sb.length()-1-2, sb.length()-1);
    		this.combinations.add(sb.toString());
    		return;
    			
    	}
    	
    	//if we have reached the end of the coin list
    	if(startIndex == coins.length-1) {
    		if( (totalAmount % coins[startIndex]) == 0 ) {
    			counts[startIndex] = totalAmount/coins[startIndex];
    			//doesn't matter what value you pass in as totalAmount since the index value is too high now at this point
    			changeCombination(coins, counts, startIndex+1, 0);
    		}
    	}
    	//else we are still iterating over the coin list
    	else {
    		//divide the amount we have to reach by the value of the coin in our coin list at position 'startIndex'
    		//use the new value to use as the end point in the lop below
    		//eg. assume we're at 50p, so 200/50 = 4
    		for(int i=0; i<=totalAmount/coins[startIndex]; i++) {
    			//so on each iteration of the loop, we'll set the counts value for 50p to 0,1,2,3 respectively
    			counts[startIndex] = i;
    			//then we'll call this method again but
    			//we'll increase the index so that we test the next coin, so in our example run, it should be the 10p coin
    			//and we'll change the total amount because our number of, eg 20 p coins, is 0,1,2,3 depending on what iteration
    			//is covering a portion of the cost, so the 10p's will only need to make up the remainder, if there is anything left to make up...
    			//eg, we have two 20p coins, so we'll call our function passing in (coins, counts, position of the 10p coins, totalAmount-(20*2) )
    			changeCombination(coins, counts, startIndex+1, totalAmount-coins[startIndex]*i);
    		}
    	}
    }
}
