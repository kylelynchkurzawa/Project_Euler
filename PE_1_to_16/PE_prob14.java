
public class PE_prob14 {
	public PE_prob14(){
		System.out.println("Longest Collatz Sequence");
	}
	
	public void run(){
		long start = System.currentTimeMillis();
		System.out.println("Started at time "+start);
		
		int startingPoint = 2;
		int startingPointLimit = 1000000;
		
		int leadingPoint=0, leadingChainLength=0;
		int currentPoint = startingPoint, currentChainLength=1;
		int currentPointValue;
		
		//int temp = 0;
		
		while(currentPoint < startingPointLimit){
			
			currentPointValue = currentPoint;
			currentChainLength=1;
			
			//System.out.println("Testing number: "+currentPoint);
			
			while((currentPointValue != 1) && (currentPointValue > 0)){
				
				if(currentPointValue%2 == 0){
					currentPointValue = nextCollatzFromEvenNum(currentPointValue);					
					currentChainLength++;
					//System.out.println("Value is even, testing: "+currentPointValue);
					//temp = How_Many_Times_Can_Be_Halfed(currentPointValue);
					//currentPointValue  = Halfed_X_Times(currentPointValue, temp);
					//currentChainLength = currentChainLength + temp;
				}
				else{
					//System.out.println("Value is odd, testing: "+currentPointValue);
					currentPointValue = nextCollatzFromOddNum(currentPointValue);
					currentChainLength++;
				}				
				
			}
			
			if(currentChainLength > leadingChainLength){
				leadingChainLength = currentChainLength;
				leadingPoint = currentPoint;
				System.out.println("New Longest Chain starting point: "+ leadingPoint);
				System.out.println("New Longest Chain length : "+ leadingChainLength+"\n");
			}
			
			currentPoint++;
		}
		
		System.out.println("Leading Collatz value: "+leadingPoint+" with a chain of "+leadingChainLength);
		
		long finish = System.currentTimeMillis();
		long time = finish - start;
		System.out.print("Finished at time ");System.out.println(finish);
		System.out.print("Executed in ");System.out.println(time);
	}
	
	private int Halfed_X_Times(int x, int z){
		int y = x;
		
		for(int i=0; i<z; i++){
			y = y/2;
		}
		
		return y;
	}
	
	private int How_Many_Times_Can_Be_Halfed(int x){
		int y = x;
		int z = 0;
		//System.out.println("Counting number of times can be halfed for "+x);
		while((y%2==0) && (y!=0)){
			y = y/2;
			//System.out.println("Currently at: "+y);
			z++;
		}
		//System.out.println("Times can be halfed "+z);
		return z;
	}
		
	private int nextCollatzFromEvenNum(int x){
		return (x/2);
	}
	
	private int nextCollatzFromOddNum(int x){
		return ( (3*x) + 1);
	}
}
