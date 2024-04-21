package Problem7;

import HelperClasses.CSVReaderWriter;
import HelperClasses.Formulas;
import HelperClasses.InfoList;

import java.io.IOException;
import java.util.ArrayList;

public class CalcLR3Sum {
    public static void main(String[] args) throws IOException {

        CSVReaderWriter readerWriter = new CSVReaderWriter();
        readerWriter.assignCSVFile("src/Problem7/LRPointer3Sum_96.csv");
        InfoList info = readerWriter.getInfoArrays();
        Formulas fs = new Formulas();
        ArrayList<Integer> sizes = info.getSizes();
        ArrayList<Double> times = info.getTimes();

        double b = fs.findB(sizes, times, 11, 5);
        double c = fs.findC(sizes,times, b, 11);
        double a = fs.findA(c);
        System.out.println(b);
        System.out.println(c);
        System.out.println(a);

        // PREDICT VALUES
        ArrayList<Double> predictedTimes = fs.findTimesWithLog(sizes, a, b);

        // WRITE
        readerWriter.writeToFile(predictedTimes, sizes, "src/Problem7/LRPointer3Sum_961_predicted.csv");
    }
}
