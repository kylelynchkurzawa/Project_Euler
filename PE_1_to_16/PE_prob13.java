import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class PE_prob13 {
	public PE_prob13(){
		System.out.println("Large Sum");
	}
	
	public void run(){
		
		long start = System.currentTimeMillis();
		System.out.println("Started at "+start);
		
		int length_of_numbers = 50;
		int num_of_large_numbers = 100;
		
		ArrayList<BigInteger> bigInts = new ArrayList<BigInteger>();
		String filepath = "C:\\Users\\Java_Dev_KLK\\Documents\\PE_files\\PE_13_large_numbers.txt";
		
		try{
			File f = new File(filepath);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String temp = br.readLine();
			
			String num_value = "";
			
			while(temp != null){
				num_value = temp;
				
				bigInts.add(new BigInteger(num_value));
				
				temp = br.readLine();
			}
			
			br.close();
			fr.close();
		}
		catch(Exception e){
			System.out.println("Something went wrong!");
		}
		
		if(bigInts.size() == num_of_large_numbers){
			System.out.println("Got all "+num_of_large_numbers+" large numbers");
		}
		else{
			System.out.println("Did NOT get all "+num_of_large_numbers+" large numbers");
		}
		
		boolean differnet_sized_number_found = false;
		for(int i=0; i<bigInts.size(); i++){
			if(bigInts.get(i).toString().length() != length_of_numbers){
				System.out.println("Found a number that woesn't "+length_of_numbers+" digits long");
				differnet_sized_number_found =true;
				break;
			}
		}
		
		
		if(!differnet_sized_number_found){
			/*
			for(int i=0; i<bigInts.size(); i++){
				System.out.println("Number "+(i+1)+": "+bigInts.get(i));
			}
			*/
			
			BigInteger sum= bigInts.get(0);
			
			for(int i=1; i<bigInts.size(); i++){
				sum = sum.add(bigInts.get(i));
			}
			
			System.out.println("Sum of all large numbers: "+sum);
			
		}
		
				
		long finish = System.currentTimeMillis();
		long time = finish - start;
		System.out.print("Finished at ");System.out.println(finish);
		System.out.print("Executed in ");System.out.println(time);
	}
}
