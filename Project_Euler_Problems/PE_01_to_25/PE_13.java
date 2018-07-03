package PE_01_to_25;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class PE_13 {
	private String problem_title = "Large Sum";
    private int problem_number = 13;
    private boolean completed_successfully = true;

    public PE_13(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }
	public void run(){
		long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();
		
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
				
		end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
	}
}
