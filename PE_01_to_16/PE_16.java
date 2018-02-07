import java.math.BigInteger;

public class PE_16 {
	private String problem_title = "Power Digit Sum";
    private int problem_number = 16;
    private boolean completed_successfully = true;

    public PE_16(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }
	
	public void run(){
		long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();
		
		int base = 2;
		int power = 1000;
		
		BigInteger BI_base = new BigInteger(Integer.toString(base));		
		BigInteger product = new BigInteger("1");
		
		for(int i=0; i<power; i++){
			product = product.multiply(BI_base);
		}
		
		System.out.println("Product: "+product.toString());
		char[] ints = product.toString().toCharArray();
		
		BigInteger sum = new BigInteger("0");
		
		for(int i=0; i<ints.length; i++){
			sum = sum.add(new BigInteger(Character.toString(ints[i])));
		}
		
		System.out.println("Sum: "+sum);
		
		end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
	}
}

