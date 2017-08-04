import java.math.BigInteger;

public class PE_prob16 {
	public PE_prob16(){
		System.out.println("Power Digit Sum");
	}
	
	public void run(){
		long start = System.currentTimeMillis();
		System.out.println("Started at "+start);
		
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
		
		long finish = System.currentTimeMillis();
		long time = finish - start;
		System.out.print("Finished at ");System.out.println(finish);
		System.out.print("Executed in ");System.out.println(time);
	}
}

