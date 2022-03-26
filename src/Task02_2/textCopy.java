package Task02_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class textCopy {
    public static void main(String[] args) {
       
        //Defining the reader and the writer outide the try catch

        BufferedReader br = null;
        PrintWriter pw = null;

        try {
            
            // setting up the reader and writer and pointing them to the files they will be using
            br = new BufferedReader(new FileReader("./resources/T02_input.txt"));
            pw = new PrintWriter("./resources/T02_output.txt");

            // This String will be used to hold the lines as we iterate through the file
            String line = null;

            //Keep reading new lines untill the line is null (end of file)
            while ((line = br.readLine()) != null) {
                
                // This String will be used to print the output into the new file.
                String str = "";

                // I is the lenght of the line, eg hello is 5 (6-1) and we will be working our way backwards from the end
                for (int i = line.length() - 1; i >= 0; i--) {
                    
                    // checks if the character at i is alphabetic or not , if it is then it will make it uppercase and add it to str
                    if (Character.isAlphabetic(line.charAt(i))) {
                        
                        str += Character.toUpperCase(line.charAt(i));
                    }
                }
                // Once its all done, pass Str into pw.println to print into a new line in the output file
                pw.println(str);
            }
        // i dont understand these yet...
        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        } catch (IOException e) {
            System.out.println("IO Execption ?");

        //gotta close everything up 
        } finally {
            if (pw != null) {
                pw.close();
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
