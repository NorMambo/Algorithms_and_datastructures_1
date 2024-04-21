package HelperClasses;

import java.util.ArrayList;

public class Formulas {

    public Formulas(){}
    public double findSlope(ArrayList<Integer> sizes, ArrayList<Double> times, int further_p, int closer_p) {
        // slope = (time2 - time1) / (size2 - size1)
        double rise = times.get(further_p) - times.get(closer_p);
        double run = sizes.get(further_p) - sizes.get(closer_p);
        return rise/run;
    }

    public double findIntercept(ArrayList<Integer> sizes, ArrayList<Double> times, double slope, int pos) {
        // intercept = time - (slope * size)
        return times.get(pos) - (slope * sizes.get(pos));
    }

    public double findC(ArrayList<Integer> sizes, ArrayList<Double> times, double b, int pos) {
        // c = log2time - (b * log2size)
        return log(2,times.get(pos)) - (b * log(2,sizes.get(pos)));
    }

    public double findB(ArrayList<Integer> sizes, ArrayList<Double> times, int further_p, int closer_p) {
        // b = (log2time2 - log2time1) / (log2size2 - log2size1)
        double rise = log(2,times.get(further_p)) - log(2, times.get(closer_p));
        double run = log(2, sizes.get(further_p)) - log(2, sizes.get(closer_p));
        return rise/run;
    }

    public double findA(double c) {
        return Math.pow(2,c);
    }

    public ArrayList<Double> findTimes(ArrayList<Integer> sizes, double slope, double intercept) {
        ArrayList<Double> times = new ArrayList<>();
        for (int size : sizes) {
            times.add((slope*size) + intercept);
        }
        return times;
    }

    public ArrayList<Double> findTimesWithLog(ArrayList<Integer> sizes, double a, double b) {
        ArrayList<Double> times = new ArrayList<>();
        for (int size : sizes) {
            times.add(a * Math.pow(size,b));
        }
        return times;
    }

    public double findAverageValue(ArrayList<Double> list) {
        double sum = 0;
        for (double value : list) {
            sum+=value;
        }
        return sum/list.size();
    }

    public double log(double base, double logNumber) {
        return Math.log(logNumber) / Math.log(base);
    }



}
