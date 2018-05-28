package PE_17_to_32;

import java.util.ArrayList;

public class PE_32 {
	private String problem_title = "Pandigital Products";
    private int problem_number = 32;
    private boolean completed_successfully = false;

    public PE_32(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();
        
        ArrayList<Integer> factors = null;
        ArrayList<Integer> pandigitalProducts = new ArrayList<Integer>();
        int upperbound = 50000;
        int nth_Pandigital = 9;
        int product_sum = 0;
        
        for(int i=2; i<upperbound; i++) {
        	//System.out.println(i);
        	factors = getFactors(i);
        	
        	for(int j=0; j<factors.size()/2; j++) {
        		if(isPandigital( factors.get(j), factors.get(factors.size()-1-j), i, nth_Pandigital)) {
        			pandigitalProducts.add(i);
        			break;
        		}
        	}
        }
        
        for(Integer i : pandigitalProducts) {
        	product_sum += i;
        }
        System.out.println("PanDigital Products Sum: "+product_sum);
        
        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }
    
    private ArrayList<Integer> getFactors(int product) {
    	ArrayList<Integer> factorList = new ArrayList<Integer>();
    	int upperbound = product;
    	int f1 =-1;
    	
    	for(int i=2; i<upperbound; i++) {
    		f1 = product / i;
    		if(product%i == 0) {
    			if(f1 != i) {
    				factorList.add(f1);
    				factorList.add(i);
    			}
    			else {
    				factorList.add(f1);
    			}
    			upperbound = upperbound / i;
    		}
    	}
    	
    	return factorList;
    }
    
    private boolean isPandigital(int multiplicand, int multiplier, int product, int nth_panDigit) {
    	boolean removed = false;
    	ArrayList<String> numberList = new ArrayList<String>();
    	String[] str_multiplicand = Integer.toString(multiplicand).split("(?!^)");
    	String[] str_multiplier = Integer.toString(multiplier).split("(?!^)");
    	String[] str_product = Integer.toString(product).split("(?!^)");
    	
    	
    	for(int i=1; i<nth_panDigit+1; i++) {
    		numberList.add(Integer.toString(i));
    	}
    	
    	for(String s : str_multiplicand) {
    		removed = numberList.remove(s);
    		if(!removed) {
    			//System.out.println("did not remove: "+s);
    			return false;
    		}
    	}
    	for(String s : str_multiplier) {
    		removed = numberList.remove(s);
    		if(!removed) {
        		//System.out.println("did not remove: "+s);
    			return false;
    		}
    	}
    	for(String s : str_product) {
    		removed = numberList.remove(s);
    		if(!removed) {
        		//System.out.println("did not remove: "+s);
    			return false;
    		}
    	}
    	
    	return removed;
    }
}
