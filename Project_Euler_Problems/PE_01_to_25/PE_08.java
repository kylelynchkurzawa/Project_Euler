package PE_01_to_25;

import java.util.Arrays;

public class PE_08 {
	private String problem_title = "Largest Product in a Series";
    private int problem_number = 8;
    private boolean completed_successfully = true;

    public PE_08(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }
	
	public void run(){
		long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();
		
		int product_size = 13;
		String source = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		
		char[] allSingleDigits = source.toCharArray();
		char[] product_values = new char[product_size];
		int bookmark = 0;
		long product_result = 0;
		long product_test = 1;
		
		for(int i=0; i<allSingleDigits.length-product_size; i++){
			for(int j=i; j<i+product_size; j++){
				product_test = product_test*(Long.valueOf(Character.toString(allSingleDigits[j])));
			}
			
			if(product_test > product_result){
				bookmark = i;
				product_result = product_test;
				
			}
			product_test = 1;
		}
		
		product_values = Arrays.copyOfRange(allSingleDigits, bookmark, bookmark+product_size);
		
		System.out.print("List of values for making the largest product with "+product_size+" digits: ");
		System.out.println(product_values);
		System.out.println("Product result from digits: "+product_result);
		
		end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
	}
}
