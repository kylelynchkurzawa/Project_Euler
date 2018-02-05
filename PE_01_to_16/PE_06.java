
public class PE_06 {
	public PE_06(){
		System.out.println("Sum Square Difference");
	}
	
	public void run(){
		long naturalNumberLimit = 100;
		
		long sumOfSquares = sumOfSquares(naturalNumberLimit);
		long squareOfSum = squareOfSums(naturalNumberLimit);
		
		long difference = squareOfSum - sumOfSquares;
		
		System.out.println("Sum Square Difference for the first "+naturalNumberLimit+" natural numbers is: "+difference);
	}
	
	private long sumOfSquares(long x){
		long z = 0;
		
		for(int i=1; i<=x; i++){
			z = z + (i*i);
		}
		
		return z;
	}
	
	private long squareOfSums(long x){
		long z = 0;
		
		for(int i=1; i<=x; i++){
			z = z + i;
		}
		
		return (z*z);
	}
}
