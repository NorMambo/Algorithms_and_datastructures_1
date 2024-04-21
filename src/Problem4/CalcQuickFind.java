package Problem4;

import HelperClasses.CSVReaderWriter;
import HelperClasses.Formulas;
import HelperClasses.InfoList;

import java.io.IOException;
import java.util.ArrayList;

public class CalcQuickFind {
    public static void main(String[] args) throws IOException {

        CSVReaderWriter readerWriter = new CSVReaderWriter();
        readerWriter.assignCSVFile("src/Problem4/QuickFind_100.csv");
        InfoList info = readerWriter.getInfoArrays();
        Formulas calc = new Formulas();
        ArrayList<Integer> sizes = info.getSizes();
        ArrayList<Double> times = info.getTimes();


        // FIND SLOPES
        ArrayList<Double> slopes = new ArrayList<>();
        for (int i = -1; i < times.size(); i+=10) {
            if (i > 0 && i < times.size()-10) {
                double slope = calc.findSlope(sizes, times, i + 10, i);
                slopes.add(slope); // 9 SLOPES
            }
        }

        System.out.println("\nQUICK-FIND VALUES:");
        System.out.println("\nAVERAGE OF 9 SLOPES:");
        double avg_slope = calc.findAverageValue(slopes);
        System.out.println(avg_slope);


        // FIND INTERCEPTS
        ArrayList<Double> intercepts = new ArrayList<>();
        for (int i = 0; i < times.size(); i++) {
            double intercept = calc.findIntercept(sizes, times, avg_slope, i);
            System.out.println(intercept);
            intercepts.add(intercept);
        }
        System.out.println("\nAVERAGE INTERCEPT:");
        double avg_intercept = calc.findAverageValue(intercepts);
        System.out.println(avg_intercept);
        System.out.println();


        // PREDICT VALUES
        ArrayList<Double> predictedTimes = calc.findTimes(sizes, avg_slope, avg_intercept);

        // WRITE
        readerWriter.writeToFile(predictedTimes, sizes, "src/Problem4/QuickFind_100_predicted.csv");

    }
}
