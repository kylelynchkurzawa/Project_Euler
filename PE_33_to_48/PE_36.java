package Project_Euler_Problems;

public class PE_36 {
    private String problem_title = "Double-Base Palindromes";
    private int problem_number = 36;
    private boolean completed_successfully = true;

    public PE_36(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        int upper_bound = 1000000;
        int palindromicSum = 0;;
        String base2;
        
        //loop through all numbers to find their value in base 2
        for(int i=0; i<upper_bound; i++) {
        	base2 = convertToBase2(i);
        	
        	//test if the number in base 2 and base 10 is a palindrome 
        	if((isPalindrome(Integer.toString(i))) && (isPalindrome(base2))) {
        		palindromicSum += i;
        	}
        }
        
        System.out.println("Total of all palindromic numbers in base 2 and 10: "+palindromicSum);
        
        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }

    private boolean isPalindrome(String str) {
    	boolean isPalindromic = true;
    	String[] str_divided = str.split("(?!^)");
    	
    	for(int i=0; i<str_divided.length/2; i++) {
    		if(!str_divided[i].equals(str_divided[str_divided.length - 1 - i])) {
    			isPalindromic = false;
    			break;
    		}
    	}
    	
    	return isPalindromic;
    }
    
    private String convertToBase2(int x) {
    	if(x == 1) {
    		return "1";
    	}
    	else if(x == 0) {
    		return "0";
    	}
    	else {
    		return ( convertToBase2(x/2).concat( String.valueOf(x%2) ) );
    	}
    }
}