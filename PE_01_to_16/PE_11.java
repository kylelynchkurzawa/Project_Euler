import java.util.ArrayList;

public class PE_11 {
	private String problem_title = "Largest product in a grid";
    private int problem_number = 11;
    private boolean completed_successfully = true;

    public PE_11(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }
	
	public void run(){
		/*		
		08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08
		49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00
		81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65
		52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91
		22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80
		24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
		32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70
		67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21
		24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72
		21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95
		78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92
		16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
		86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58
		19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40
		04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66
		88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69
		04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36
		20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
		20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54
		01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48		
		*/
		long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();
		
		int matrixRows = 20;
		int matrixColumns = 20;
		int counter = 0;
		int num_of_adj = 4;
		String source = "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08 49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00 81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65 52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91 22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80 24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50 32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70 67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21 24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72 21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95 78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92 16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57 86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58 19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40 04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66 88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69 04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36 20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16 20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54 01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48";
		
		String[] individualNums = source.split(" ");
		myMatrix m = new myMatrix(matrixRows, matrixColumns);
		ArrayList<Integer> highest_factors = new ArrayList<Integer>();
		int highest_factor_product = 0;
		int temp_highest_factor_product = 1;
		
		for(int i=0; i<m.getNumOfRows(); i++){
			for(int j=0; j<m.getNumOfColumns(); j++){				
				m.setMatrixEntry(i, j, Integer.valueOf(individualNums[counter]));
				counter++;
			}
		}
		
		System.out.println(m);
		
		//up and down products
		for(int i=0; i<m.getNumOfRows()-num_of_adj; i++){			
			for(int j=0; j<m.getNumOfColumns(); j++){
				
				temp_highest_factor_product = 1;
				for(int k=0;k<num_of_adj; k++){
					temp_highest_factor_product = temp_highest_factor_product * m.getMatrixEntry(i+k, j);
				}
				
				if(temp_highest_factor_product > highest_factor_product){
					highest_factor_product = temp_highest_factor_product;
					highest_factors.clear();
					
					for(int k=0;k<num_of_adj; k++){
						highest_factors.add(m.getMatrixEntry(i+k, j));
					}
				}
			}
		}
		
		//left and right products
		for(int i=0; i<m.getNumOfRows(); i++){			
			for(int j=0; j<m.getNumOfColumns()-num_of_adj; j++){
				
				temp_highest_factor_product = 1;
				for(int k=0;k<num_of_adj; k++){
					temp_highest_factor_product = temp_highest_factor_product * m.getMatrixEntry(i, j+k);
				}
				
				if(temp_highest_factor_product > highest_factor_product){
					highest_factor_product = temp_highest_factor_product;
					highest_factors.clear();
					
					for(int k=0;k<num_of_adj; k++){
						highest_factors.add(m.getMatrixEntry(i, j+k));
					}	
				}		
			}
		}		
		
		//NW to SE diagonals
		for(int i=0; i<m.getNumOfRows()-num_of_adj; i++){			
			for(int j=0; j<m.getNumOfColumns()-num_of_adj; j++){
				
				temp_highest_factor_product = 1;
				for(int k=0;k<num_of_adj; k++){
					temp_highest_factor_product = temp_highest_factor_product * m.getMatrixEntry(i+k, j+k);
				}
				
				if(temp_highest_factor_product > highest_factor_product){
					highest_factor_product = temp_highest_factor_product;
					highest_factors.clear();
					
					for(int k=0;k<num_of_adj; k++){
						highest_factors.add(m.getMatrixEntry(i, j+k));
					}	
				}			
			}
		}		
		
		//SW to NE diagonals
		for(int i=0+num_of_adj-1; i<m.getNumOfRows(); i++){			
			for(int j=0+num_of_adj-1; j<m.getNumOfColumns(); j++){
				
				temp_highest_factor_product = 1;
				for(int k=0;k<num_of_adj; k++){
					temp_highest_factor_product = temp_highest_factor_product * m.getMatrixEntry(i-k, j+k);
				}
				
				if(temp_highest_factor_product > highest_factor_product){
					highest_factor_product = temp_highest_factor_product;
					highest_factors.clear();
					
					for(int k=0;k<num_of_adj; k++){
						highest_factors.add(m.getMatrixEntry(i-k, j+k));
					}
				}				
			}
		}
		
		System.out.println(highest_factor_product + "\n\n" + highest_factors);
		
		end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
		
	}
	
	private class myMatrix{
		private int rows, columns;
		
		private ArrayList<ArrayList<Integer>> matrix;
		
		public myMatrix(int num_of_rows, int num_of_columns){
			this.rows = num_of_rows;
			this.columns = num_of_columns;
			this.matrix = new ArrayList<ArrayList<Integer>>();
			
			ArrayList<Integer> temp;
			
			for(int i=0; i<rows; i++){
				
				temp = new ArrayList<Integer>();
				for(int j=0; j<columns; j++){
					temp.add(0);
				}
				
				matrix.add(temp);
			}
		}
		
		public int getNumOfRows(){
			return this.rows;
		}
		public int getNumOfColumns(){
			return this.columns;
		}
		
		public int getMatrixEntry(int rowNum, int columnNum){
			int entry;
			
			if((rowNum < 0) || (rowNum >= this.rows)){
				return -1;
			}
			if((columnNum < 0) || (columnNum >= this.columns)){
				return -1;
			}
			
			entry = this.matrix.get(rowNum).get(columnNum);
			
			return entry;
		}
		
		public boolean setMatrixEntry(int rowNum, int coloumnNum, int entry){
			boolean entry_set = false;
			
			ArrayList<Integer> altered_row = this.matrix.get(rowNum);
			altered_row.set(coloumnNum, entry);
			this.matrix.set(rowNum, altered_row);
			
			if(entry == this.getMatrixEntry(rowNum, coloumnNum)){
				entry_set = true;
			}			
			
			return entry_set;
		}
		
		@Override
		public String toString(){
			String s = "";
			ArrayList<Integer> temp = new ArrayList<Integer>();
			
			for(int i=0; i<this.matrix.size(); i++){
				
				temp = this.matrix.get(i);
				for(int j=0; j<temp.size(); j++){
					s = s + "\t" + String.valueOf(temp.get(j));
				}
				s = s + "\n";
			}
			
			
			return s;
		}
	}
}
