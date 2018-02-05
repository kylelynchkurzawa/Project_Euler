
public class PE_02 {
	
	private long lastVal;
	private long secLastVal;
	
	public PE_02(){
		this.lastVal = 1;
		this.secLastVal = 2;
		System.out.println("Sum of even fibanacci numbers");
	}
	
	public void run(){
		long limit = 4000000;
		long newVal = 0;
		 
		long sum = 0 + this.secLastVal;
		 
		//loop until you reach the limit
		while(this.secLastVal <= limit){
			//find the new value
			newVal = this.lastVal + this.secLastVal;
			System.out.println(newVal);
			
			//asssign the values
			this.lastVal = this.secLastVal;
			this.secLastVal = newVal;
			 
			//do not exceed limit
			if(this.secLastVal > limit){
				break;
			}
			//if you don't exceed limit
			else{
			//check if even
				if(this.secLastVal%2 == 0){
					System.out.println("Even number: "+this.secLastVal);
			 
					sum = sum + this.secLastVal;
				}
			}
		}//end while
		 
		System.out.println("Total: "+sum);
	}
}
