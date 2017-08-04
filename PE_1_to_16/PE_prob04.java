
public class PE_prob04 {
	
	public PE_prob04(){
		System.out.println("Largest Palindrome Product");
	}
	
	public void run(){
		
		int lowerBound = 99;
		int upperBound = 999;
		
		int val1 = -1;
		int val2= -1;
		int pallindromeProduct = -1;
		
		for(int i=upperBound-1; i>lowerBound; i--){
			
			for(int j=upperBound-1; j>lowerBound; j--){
				
				int product = i*j;
				
				if(isPallindrome(Integer.toString(product).toCharArray())){
					if(product> pallindromeProduct){
						val1 = i;
						val2 = j;
						pallindromeProduct = product;
					}					
				}				
			}
		}
		
		System.out.println("Value 1: "+val1+"Value 2: "+val2);
		System.out.println("Product: "+(val1*val2));
	}
	
	private boolean isPallindrome(char[] x){
		boolean b = true;
		
		for(int i=0; i<x.length; i++){
			if(x[i] != x[x.length-1-i]){
				b = false;
			}
		}
		
		return b;
	}
}
