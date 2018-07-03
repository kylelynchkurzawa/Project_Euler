package PE_01_to_25;

import java.util.ArrayList;
import java.util.Collections;

public class PE_24 {
	private String problem_title = "Lexicographic Permutations";
    private int problem_number = 24;
    private boolean completed_successfully = true;

    private ArrayList<String> permutationList;
    
    public PE_24(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
        permutationList = new ArrayList<String>();
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        int position = 1000000;
        String old_permutation = "0123456789";
        
        //call the function to create the list of all permutations for the given string
        permute(old_permutation, 0, old_permutation.length()-1);
        
        //sort the list of permutations
        Collections.sort(this.permutationList);
        
        System.out.println(position+"th Lexicographic Permutation for the digits of "+old_permutation+" is: "+this.permutationList.get(position-1));
        
        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }
    
    //source of permutation generation
    //https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
    private void permute(String old_permutation, int index_one, int index_two) {
    	if(index_one == index_two) {
    		this.permutationList.add(old_permutation);
    	}
    	else {
    		for(int i=index_one; i<= index_two; i++) {
    			old_permutation = swap(old_permutation, index_one, i);
    			permute(old_permutation, index_one+1, index_two);
    			old_permutation = swap(old_permutation, index_one, i);
    		}
    	}
    }
    
    private String swap(String str, int i, int j)
    {
        char temp;
        char[] charArray = str.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
    
}
