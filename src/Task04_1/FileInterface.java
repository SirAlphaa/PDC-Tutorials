package Task04_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

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
}  