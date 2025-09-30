import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;


public class evenProblems {

    public static void main(String[] args){
        String csvPath = "/Users/austin/Documents/CPSC_2735/assignment05/Team-Red/data/insurance.csv";
        String line = "";
        ArrayList<String> data = new ArrayList<>();
        ArrayList<Integer> ageVals = new ArrayList<>();
        ArrayList<Double> bmiVals = new ArrayList<>();
        ArrayList<Integer> childrenVals = new ArrayList<>();
        ArrayList<Double> chargesVals = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvPath))){
            line = reader.readLine(); // Skip header line
            while(reader.readLine() != null){
                line = reader.readLine();
                data.add(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        for(String c : data){
            String[] values = c.split(",");
            ageVals.add(Integer.parseInt(values[0]));
            bmiVals.add(Double.parseDouble(values[2]));
            childrenVals.add(Integer.parseInt(values[3]));
            chargesVals.add(Double.parseDouble(values[6]));
        }

        System.out.println("Age values: " + calculateValsFromIntegers(ageVals));
        System.out.println("Children values: " + calculateValsFromIntegers(childrenVals));

    }

    //Problem 2
    public static ArrayList<String> calculateValsFromIntegers(ArrayList<Integer> red){
        int count = 0;

        int Amean = 0;
        int Amin = 999999;
        int Amax = -999999;
        int variance = 0;
        int SumofSquares = 0;
        double Astd = 0.0;
        ArrayList<String> results = new ArrayList<>();

        for(int age : red){
            count++;
            Amean += age;
            if(age < Amin){
                Amin = age;
            }
            if(age > Amax){
                Amax = age;
            }
        }
        Amean /= count;

        //Calculate the variance
        for(int age : red){
            int temp = age - Amean;
            int tempSquared = temp * temp;
            SumofSquares += tempSquared;
        }
        variance = SumofSquares / (count - 1);

        //Calculate the standard deviation
        Astd = Math.sqrt(variance);
        double rounded = Math.round(Astd * 1000) / 1000.0; //Round the std to 3 decimal places

        results.add("Count: " + count);
        results.add("Mean: " + Amean);
        results.add("Min: " + Amin);
        results.add("Max: " + Amax);
        results.add("Standard Deviation: " + rounded);

        return results;
    }

    
}

