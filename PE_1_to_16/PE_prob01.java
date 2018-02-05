
public class PE_01 {
	public PE_01(){
		System.out.println("Sum of multiples of 3 and 5");
	}
	
	public void run(){
		int sum = 0;
		
		for(int i=0; i<1000; i++){
			if((i%3 == 0) || (i%5 == 0)){
				sum += i;
			}
		}
		
		System.out.println(sum);
	}
}
