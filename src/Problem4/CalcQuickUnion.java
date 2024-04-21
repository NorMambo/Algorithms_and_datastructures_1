package Problem4;

import HelperClasses.CSVReaderWriter;
import HelperClasses.Formulas;
import HelperClasses.InfoList;

import java.io.IOException;
import java.util.ArrayList;

public class CalcQuickUnion {
    public static void main(String[] args) throws IOException {

        CSVReaderWriter readerWriter = new CSVReaderWriter();
        readerWriter.assignCSVFile("src/Problem4/QuickUnion_1000.csv");
        InfoList info = readerWriter.getInfoArrays();
        Formulas calc = new Formulas();
        ArrayList<Integer> sizes = info.getSizes(); // 1000 elements
        ArrayList<Double> times = info.getTimes(); // 1000 elements


        // FIND SLOPES
        ArrayList<Double> slopes = new ArrayList<>();
        for (int i = -1; i < times.size(); i+=100) {
            if (i > 0 && i < times.size()-10) { //990
                double slope = calc.findSlope(sizes, times, i + 100, i);
                slopes.add(slope); //9 slopes
            }
        }

        System.out.println("\nAVERAGE OF 9 SLOPES (rounded to 7th dec. place):");
        double avg_slope = calc.findAverageValue(slopes);
        System.out.printf("%.7f%n", avg_slope);
        System.out.println("\nTHE AVERAGE SLOPE IS SO CLOSE TO ZERO THAT IT CAN BE ROUNDED TO 0.0");
        // avg_slope = 0;


        // FIND INTERCEPTS
        ArrayList<Double> intercepts = new ArrayList<>();
        for (int i = 0; i < times.size(); i++) {
            double intercept = calc.findIntercept(sizes, times, avg_slope, i);
            intercepts.add(intercept);
        }
        System.out.println("\nAVERAGE INTERCEPT:");
        double avg_intercept = calc.findAverageValue(intercepts);
        System.out.println(avg_intercept);
        System.out.println();


        // PREDICT VALUES
        ArrayList<Double> predictedTimes = calc.findTimes(sizes, avg_slope, avg_intercept);

        //WRITE
//        readerWriter.writeToFile(predictedTimes, sizes, "src/Problem4/QuickUnion_1000_predicted.csv");
//        readerWriter.writeToFile(predictedTimes, sizes, "src/Problem4/QuickUnion_1000_predicted_rounded_slope.csv");
    }


}
