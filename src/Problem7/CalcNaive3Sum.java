package Problem7;

import HelperClasses.CSVReaderWriter;
import HelperClasses.Formulas;
import HelperClasses.InfoList;

import java.io.IOException;
import java.util.ArrayList;

public class CalcNaive3Sum {
    public static void main(String[] args) throws IOException {

        CSVReaderWriter readerWriter = new CSVReaderWriter();
        readerWriter.assignCSVFile("src/Problem7/Naive3Sum_8.csv");
        InfoList info = readerWriter.getInfoArrays();
        Formulas fs = new Formulas();
        ArrayList<Integer> sizes = info.getSizes();
        ArrayList<Double> times = info.getTimes();

        double b = fs.findB(sizes, times, 7, 3);
        double c = fs.findC(sizes,times, b, 7);
        double a = fs.findA(c);

        // PREDICT VALUES
        ArrayList<Double> predictedTimes = fs.findTimesWithLog(sizes, a, b);

        // WRITE
        readerWriter.writeToFile(predictedTimes, sizes, "src/Problem4/Naive3Sum_8_predicted.csv");
    }
}
