package Task02_3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class scoreRecorder {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        HashMap<String, Integer> records = readRecords();

        String name = "";
        Integer score = 0;

        while (true) {
            System.out.println(records);
            System.out.print("\nPlease input a Student Name: ");
            name = checkInput(input, records);
            boolean isValid = false; 
            while (!isValid) {
                try {
                    System.out.print("Input a score: ");
                    score = Integer.parseInt(checkInput(input, records));
                    isValid = true;
                } catch (NumberFormatException e) {
                    System.out.println("invaild input");
                }
            }

            if (records.containsKey(name)) {
                System.out.println("Studnet | " + name + " | is existing. Do you wish to update student entry");
                if (checkInput(input, records).trim().equalsIgnoreCase("y")) {
                    records.put(name, score);
                } 
            } else {
                records.put(name, score);
            }

        }

    }


    public static HashMap<String, Integer> readRecords() {
        
       HashMap<String, Integer> list = new HashMap();
       BufferedReader br = null;

       try {
            br = new BufferedReader(new FileReader("./resources/T02_scores.txt"));
            String line = null;
        
            while ((line = br.readLine()) != null) {
                String str[] = line.split(" ");
                list.put(str[0], Integer.parseInt(str[1]));
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO error");
        } finally {
           if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("IO error");
               }
            }
        }
        return list;
    }


    public static String checkInput(Scanner sc, HashMap<String, Integer> records) {
        String input = sc.nextLine();

        if (input.trim().equalsIgnoreCase("x")) {
            System.out.println("Records Saved");
            writeToFile(records);
            System.exit(0);
        }
        return input;
    }

    public static void writeToFile(HashMap<String, Integer> records) {
        PrintWriter output = null;
        
        try {
            output = new PrintWriter("./resources/T02_scores.txt");
            for (Map.Entry<String, Integer> entry : records.entrySet()) {
                output.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

}