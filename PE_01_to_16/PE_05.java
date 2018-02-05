
public class PE_05 {
	
	public PE_05(){
		System.out.println("Smallest Multiple from 1 to X");
	}
	
	public void run(){
		
		long upperbound = 20;
		long test = upperbound;
		boolean found = false;
				
		while(true){
			for(long i=upperbound; i>1; i--){
				if(test%i != 0){
					break;
				}
				if((i==2) && (test%i==0)){
					found = true;
				}
			}
			if(found){
				break;
			}
			else{
				test = test + upperbound;
			}
		}
		
		System.out.println("Evenly Divisable by first 20 integers: "+test);
	}
}
