package PE_33_to_48;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PE_42 {
    private String problem_title = "Coded triangle numbers";
    private int problem_number = 42;
    private boolean completed_successfully = true;

    public PE_42(){
        System.out.println("Starting Project Euler Problem No. "+ problem_number +": "+problem_title);
        System.out.println("Problem Solved: "+completed_successfully);
    }

    public void start(){
        long start_time, end_time, time_elapsed;
        System.out.println("Starting Problem "+problem_number);
        start_time = System.currentTimeMillis();

        String source_file_path = "/home/kyle/Documents/Personal-Git-Repos/my project euler/Project_Euler/Project_Euler_Problems/Problem Files/Problem_42.txt";
        HashMap<String, Integer> alphabet = new HashMap<String, Integer>();
        alphabet.put("A", 1);alphabet.put("B", 2);alphabet.put("C", 3);alphabet.put("D", 4);
        alphabet.put("E", 5);alphabet.put("F", 6);alphabet.put("G", 7);alphabet.put("H", 8);
        alphabet.put("I", 9);alphabet.put("J", 10);alphabet.put("K", 11);alphabet.put("L", 12);
        alphabet.put("M", 13);alphabet.put("N", 14);alphabet.put("O", 15);alphabet.put("P", 16);
        alphabet.put("Q", 17);alphabet.put("R", 18);alphabet.put("S", 19);alphabet.put("T", 20);
        alphabet.put("U", 21);alphabet.put("V", 22);alphabet.put("W", 23);alphabet.put("X", 24);
        alphabet.put("Y", 25);alphabet.put("Z", 26);

        ArrayList<String> words = extractWords(source_file_path);
        ArrayList<Integer> wordValues = generateWordValues(alphabet, words);
        Collections.sort(wordValues);

        int highestWordValue = wordValues.get(wordValues.size()-1);
        int triangleWordCount = 0;
        ArrayList<Integer> triangleNumbers = generateTriangleNumbers(highestWordValue);

        for(Integer i : wordValues){
            if(triangleNumbers.contains(i)){
                triangleWordCount++;
            }
        }

        System.out.println("Number of triangle words in the text file: "+triangleWordCount);

        end_time = System.currentTimeMillis();
        System.out.println("Finished Problem");
        time_elapsed = end_time - start_time;
        System.out.println("Time taken to finish problem: "+time_elapsed);
    }

    private int getTriangleNumber(int seed){
        return (seed*(seed+1))/2;
    }

    private ArrayList<Integer> generateTriangleNumbers(int limit){
        ArrayList<Integer> triangleNumbers = new ArrayList<Integer>();

        for(int i=1; i<= limit; i++){
            triangleNumbers.add(getTriangleNumber(i));
        }

        return triangleNumbers;
    }

    private ArrayList<Integer> generateWordValues(HashMap<String, Integer> map, ArrayList<String> words){
        ArrayList<Integer> wordValues = new ArrayList<Integer>();
        int wordValue = 0;

        //for each word
        for(String word : words){
            wordValue = 0;

            //split the word into letters
            //then for each letter
            for(String letter : word.split("(?!^)")){
                //System.out.println(letter);
                wordValue += map.get(letter);
            }
            wordValues.add(wordValue);
        }

        return wordValues;
    }

    private ArrayList<String> extractWords(String filepath){
        ArrayList<String> words = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        String currentline;
        File f = null;
        FileReader fr = null;
        BufferedReader br = null;

        try{
            f = new File(filepath);
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            while((currentline = br.readLine()) != null){
                sb.append(currentline);
            }
        }
        catch(Exception e){
            System.out.println("Had a problem reading the text file.");
        }
        finally{
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String[] wordsarray = sb.toString().split(",");
        for(String s : wordsarray){
            words.add(s.replace("\"", ""));
        }

        return words;
    }
}

