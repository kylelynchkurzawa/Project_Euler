package Project_Euler_Problems;

public class PE_40 {
    private String problem_title = "Champernowne's Constant";
    private int problem_number = 40;
    private boolean completed_successfully = false;

    public PE_40(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        //TODO
        //code for problem

        BitDecimal bd = new BigDecimal("0.1");
        String big_dec;
        int ten_factor_count = 7;
        int number_to_add_on = 1;
        int limit = 1000000;
        
        //start on two since we're starting the problem on 0.1
        for(int i=2; i< limit; i++) {
        	big_dec = bd.toString();
        	big_dec.concat(String.valueOf(i));
        	bd = new BigInteger(big_dec);
        	if(bd.length >= limit) {
        		break;
        	}
        }
        
        
        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }
}
