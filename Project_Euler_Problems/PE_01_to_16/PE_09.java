package PE_01_to_16;

public class PE_09 {	
	private String problem_title = "Pythagorean triplet";
    private int problem_number = 9;
    private boolean completed_successfully = true;

    public PE_09(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }
	
	public void run(){
		long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();
		
		int triplet_sum = 1000;
		int a=0, b=0, c=0;
		int non_hyp_remains = 0;
		
		int side_a=0, side_b=0, side_hyp=0;
		
		boolean found = false;
		
		for(int i=triplet_sum; i>0; i--){
			a = i;
			non_hyp_remains = triplet_sum - i;
			
			System.out.println("Testing hypotenuse of length: "+i+" units");
			for(int j=non_hyp_remains; j>0; j--){
				b=j;
				c=non_hyp_remains-b;
								
				if(c>b){
					break;
				}

				System.out.println("Testing opp and adj of: "+b+" and "+c+" units");
				
				if(isPythagorean(c, b, a) && isConcurrentlyBigger(c, b, a)){
					found = true;
					
					side_a=c;
					side_b=b;
					side_hyp=a;
					
					break;
				}
				
			}
			
			if(found){
				break;
			}
		}
		
		System.out.println(side_a+" - "+side_b+" - "+side_hyp);
		System.out.println("Side Product = "+(side_a*side_b*side_hyp));
		
		end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
	}
	
	private boolean isPythagorean(int x, int y, int z){
		boolean b=false;
		
		if( ((x*x) + (y*y)) == (z*z) ){
			b=true;
		}
		
		return b;
	}
	
	private boolean isConcurrentlyBigger(int x, int y, int z){
		boolean b=false;
		
		if((x<y) && (y<z) && (x<z)){
			b=true;
		}
		
		return b;
	}
}
