package code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ReadFile {
    public ReadFile(String filename){
        String line = null;
        BufferedReader bufferedReader = null;
        String path = new File(filename).getAbsolutePath();
        try {
            File csvFile = new File(path);
            FileReader fileReader = new FileReader(
                    csvFile, StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(fileReader);
            //read till the end of the file
            while ((line = bufferedReader.readLine()) != null) {
                //split the line read into tokens with the defined separator
                String[] csvLineElements = line.split(",");
                for (int i = 0; i < csvLineElements.length; i++) {
                    System.out.println(csvLineElements[i]);
                }
            }
        }
        // don’t forget to handle exceptions
        catch (IOException e) {
            System.out.println("Error Occured while parsing csv file.");
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ReadFile myread = new ReadFile("src/files/nomi.txt");
    }
}