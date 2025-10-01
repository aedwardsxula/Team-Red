package teamred;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
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
        ArrayList<String> smokerVals = new ArrayList<>();

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
            smokerVals.add(values[4]);

        }

       // System.out.println("Age values: " + calculateValsFromIntegers(ageVals));
       // System.out.println("Children values: " + calculateValsFromIntegers(childrenVals));
       // System.out.println("BMI values: " + calculateValsFromDoubles(bmiVals));
       // System.out.println("Charges values: " + calculateValsFromDoubles(chargesVals));

        //verticalHistogram(bmiVals);
        smokerHistogram(smokerVals);

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
        double percentile1 = 0.0;
        double percentile2 = 0.0;
        double percentile3 = 0.0;
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

        //Get the percentiles for 25%, 50%, and 75%
        percentile1 = getPercentileFromIntArray(red, 25.0);
        percentile2 = getPercentileFromIntArray(red, 50.0);
        percentile3 = getPercentileFromIntArray(red, 75.0);

        results.add("Count: " + count);
        results.add("Mean: " + Amean);
        results.add("Min: " + Amin);
        results.add("Max: " + Amax);
        results.add("Standard Deviation: " + rounded);
        results.add("25th Percentile: " + percentile1);
        results.add("50th Percentile: " + percentile2);
        results.add("75th Percentile: " + percentile3);

        return results;
    }

    public static ArrayList<String> calculateValsFromDoubles(ArrayList<Double> blue){
        int count = 0;

        double Bmean = 0.0;
        double Bmin = 999999.0;
        double Bmax = -999999.0;
        double variance = 0.0;
        double SumofSquares = 0.0;
        double Bstd = 0.0;
        double percentile1 = 0.0;
        double percentile2 = 0.0;
        double percentile3 = 0.0;
        ArrayList<String> results = new ArrayList<>();

        for(double val : blue){
            count++;
            Bmean += val;
            if(val < Bmin){
                Bmin = val;
            }
            if(val > Bmax){
                Bmax = val;
            }
        }
        Bmean /= count;

        //Calculate the variance
        for(double val : blue){
            double temp = val - Bmean;
            double tempSquared = temp * temp;
            SumofSquares += tempSquared;
        }
        variance = SumofSquares / (count - 1);

        //Calculate the standard deviation
        Bstd = Math.sqrt(variance);
        double rounded = Math.round(Bstd * 1000) / 1000.0; //Round the std to 3 decimal places

        //Get the percentiles for 25%, 50%, and 75%
        percentile1 = getPercentileFromDoubleArray(blue, 25.0);
        percentile2 = getPercentileFromDoubleArray(blue, 50.0);
        percentile3 = getPercentileFromDoubleArray(blue, 75.0);

        results.add("Count: " + count);
        results.add("Mean: " + Math.round(Bmean * 1000) / 1000.0);
        results.add("Min: " + Bmin);
        results.add("Max: " + Bmax);
        results.add("Standard Deviation: " + rounded);
        results.add("25th Percentile: " + Math.round(percentile1 * 1000) / 1000.0);
        results.add("50th Percentile: " + Math.round(percentile2 * 1000) / 1000.0);
        results.add("75th Percentile: " + Math.round(percentile3 * 1000) / 1000.0);

        return results;
    }

    //Calculate the percentiles
    public static double getPercentileFromIntArray(ArrayList<Integer> carbon, double percentile){
        Collections.sort(carbon); //Sort the arraylist in ascending order

        //Find the rank(Position in the sorted list)
        double index = (percentile / 100.0) * (carbon.size() - 1);

        int lowerIndex = (int) Math.floor(index);
        int upperIndex = (int) Math.ceil(index);

        //Find the values between the two indexes if necessary
        if(lowerIndex == upperIndex){
            return carbon.get(lowerIndex);
        } else {
            double weight = index - lowerIndex;
            return carbon.get(lowerIndex) * (1 - weight) + carbon.get(upperIndex) * weight;
        }
    }

    public static double getPercentileFromDoubleArray(ArrayList<Double> carbon, double percentile){
        Collections.sort(carbon); //Sort the arraylist in ascending order

        //Find the rank(Position in the sorted list)
        double index = (percentile / 100.0) * (carbon.size() - 1);

        int lowerIndex = (int) Math.floor(index);
        int upperIndex = (int) Math.ceil(index);

        //Find the values between the two indexes if necessary
        if(lowerIndex == upperIndex){
            return carbon.get(lowerIndex);
        } else {
            double weight = index - lowerIndex;
            return carbon.get(lowerIndex) * (1 - weight) + carbon.get(upperIndex) * weight;
        }
    }



    //Problem 4
    public static void verticalHistogram(ArrayList<Double> green){

        TreeMap<Integer, Integer> Tmap = new TreeMap<>();
        

        for(double val : green){
            //Round the value down to the nearest integer
            int intVal = (int) Math.floor(val);

            if(Tmap.containsKey(intVal)){
                Tmap.put(intVal, Tmap.get(intVal) + 1);
            } else {
                Tmap.put(intVal, 1);
            }
        }
        //Get the max value in the TreeMap
        int max = Collections.max(Tmap.values());

        //Print the histogram
        for(int i = max; i > 0; i--){
            for(int key : Tmap.keySet()){
                if(Tmap.get(key) >= i){
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }

        for(int key : Tmap.keySet()){
            System.out.print(String.format("%2d ", key));
        }
        System.out.println();  


    }

    //Probelem 6
    public static void smokerHistogram(ArrayList<String> silver){
        TreeMap<String, Integer> Tmap = new TreeMap<>();

        for(String val : silver){
            if(val.equals("yes")){
                val = "Smoker";
            } else {
                val = "Non-Smoker";
            }
            if(Tmap.containsKey(val)){
                Tmap.put(val, Tmap.get(val) + 1);
            } else {
                Tmap.put(val, 1);
            }
        }

        int max = Collections.max(Tmap.values());
        for(int i = max; i > 0; i--){
            for(String key : Tmap.keySet()){
                if(Tmap.get(key) >= i){
                    System.out.print(" * \t\t");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
        for(String key : Tmap.keySet()){
            System.out.print(String.format("%s", key));
            System.out.print("\t");
        }
        System.out.println();


    }

    
}

