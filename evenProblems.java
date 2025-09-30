import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;


public class evenProblems {

    public static void main(String[] args){
        String csvPath = "/Users/austin/Documents/CPSC_2735/assignment05/Team-Red/data/insurance.csv";
        String line = "";
        ArrayList<String> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvPath))){
            line = reader.readLine(); // Skip header line
            while(reader.readLine() != null){
                line = reader.readLine();
                data.add(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(data);
    }

    
}

