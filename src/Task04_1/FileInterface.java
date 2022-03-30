package Task04_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class FileInterface {

    // public void getInfo() {
    // HashMap<String, Integer> records = readRecords();
    // }

    public static HashMap<String, Integer> readRecords() {

        HashMap<String, Integer> list = new HashMap<>();
        BufferedReader br = null;
        String line = null;
        try {
            br = new BufferedReader(new FileReader("./resources/T02_scores.txt"));
            while ((line = br.readLine()) != null) {
                String str[] = line.split(" ");
                list.put(str[0], Integer.parseInt(str[1]));
            }
        } catch (FileNotFoundException e) {
            System.out.print("File not found");
        } catch (IOException e) {
            System.out.print("IO Execption");
        }
        return list;
    }

    public static void writeRecords(HashMap<String, Integer> records) {
        PrintWriter output = null;
        try {
            output = new PrintWriter("./resources/T02_scores.txt");
            for (Map.Entry<String, Integer> entry : records.entrySet()) {
                output.println(entry.getKey() + " " + entry.getValue());;
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