package PE_01_to_25;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;

public class PE_22 {
    private String problem_title = "Names Scores";
    private int problem_number = 22;
    private boolean completed_successfully = true;

    public PE_22(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        //read from the text file
        String nameTextFilePath = "C:\\Users\\lynchkurzaw1\\Documents\\Project_Euler\\PE_22\\p022_names.txt";
        String unformatted_text = readFromNameTextFile(nameTextFilePath);

        //set up the hashmap to hold my values for characters
        HashMap<Character, Integer> myLetterValueMap = new HashMap<Character, Integer>();
        myLetterValueMap.put('A', 1);myLetterValueMap.put('B', 2);myLetterValueMap.put('C', 3);
        myLetterValueMap.put('D', 4);myLetterValueMap.put('E', 5);myLetterValueMap.put('F', 6);
        myLetterValueMap.put('G', 7);myLetterValueMap.put('H', 8);myLetterValueMap.put('I', 9);
        myLetterValueMap.put('J', 10);myLetterValueMap.put('K', 11);myLetterValueMap.put('L', 12);
        myLetterValueMap.put('M', 13);myLetterValueMap.put('N', 14);myLetterValueMap.put('O', 15);
        myLetterValueMap.put('P', 16);myLetterValueMap.put('Q', 17);myLetterValueMap.put('R', 18);
        myLetterValueMap.put('S', 19);myLetterValueMap.put('T', 20);myLetterValueMap.put('U', 21);
        myLetterValueMap.put('V', 22);myLetterValueMap.put('W', 23);myLetterValueMap.put('X', 24);
        myLetterValueMap.put('Y', 25);myLetterValueMap.put('Z', 26);

        //clean up the text file names
        String[] names = unformatted_text.replace("\"", "").split(",");
        //sort the names by alphabetical order using sort static function in Arrays
        Arrays.sort(names);

        int name_score_sum = 0;

        for(int i=0; i<names.length; i++){
            name_score_sum += ((getNameScoreFromHashMap(names[i], myLetterValueMap)) * (i+1) );
        }

        System.out.println("Total sum of all name scores: "+name_score_sum);

        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finished problem: "+time_elapsed);
    }

    private int getNameScoreFromHashMap(String name, HashMap<Character, Integer> characterMap){
        int score = 0;

        for (Character c : name.toCharArray()) {
            score += characterMap.get(Character.toUpperCase(c));
        }

        return score;
    }

    private String readFromNameTextFile(String filePath){
        String unformatted_String = null;
        FileReader fr = null;
        BufferedReader br = null;
        String file_line = null;
        StringBuilder sb = null;

        try{
            File f = new File(filePath);
            if(f.exists() && f.isFile()){
                fr = new FileReader(f);
                br = new BufferedReader(fr);
                file_line = br.readLine();
                sb = new StringBuilder();

                while(file_line != null){
                    sb.append(file_line);
                    file_line = br.readLine();
                }

                unformatted_String = sb.toString();
            }
            else{
                System.out.println("Sorry, file does not exist at: "+filePath);
            }
        }
        catch(Exception exc){
            System.out.println("Something went wrong when trying to read the file");
        }
        finally{
            try{
                br.close();
                fr.close();
            }
            catch(Exception exc) {
                System.out.println("Something went wrong");
            }
        }

        return unformatted_String;
    }
}
