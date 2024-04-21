package Problem7;

import Problem3.Timer;
import HelperClasses.Formulas;
import Problem5.Naive3Sum;

import java.io.IOException;
import java.util.ArrayList;

public class FindRunTimesNaive3Sum {

    public static void main(String[] args) throws IOException {

        // 100 arrays starting at 100.000 always increased by 100.000
        int factor = 100;
        ArrayList<Naive3Sum> bf3sList = new ArrayList<>();

        //CREATE A LIST OF 100 THREE-SUM CLASSES
        for (int i = 1; i <= 8; i++) {
            Naive3Sum bf3s = new Naive3Sum(i*factor);
            bf3sList.add(bf3s);
        }
        Formulas fs = new Formulas();
        Timer t = new Timer();
        ArrayList<Double> times = new ArrayList<>();
        ArrayList<Integer> sizes = new ArrayList<>();

        // FOR EVERY INSTANCE OF THREE-SUM CLASS
        for (int i = 0; i < bf3sList.size(); i++) {

            // GET THE INSTANCE
            Naive3Sum bf3s = bf3sList.get(i);

            // MINIMUMS WILL CONTAIN 10 MINIMUM RUNNING TIMES OF THREE-SUM.THREE-SUM(0)
            ArrayList<Double> minimums = new ArrayList<>();

            // EXECUTE 10 TIMES 10 .THREE-SUM(0) OPERATIONS WITH THE CURRENT INSTANCE OF THREE-SUM
            for (int j = 0; j < 10; j++) {

                double min = 0;
                double time;

                // RUN .THREE-SUM(0) 10 TIMES
                // BUT ONLY TAKE THE MINIMUM TIME TO PERFORM THE OPERATION
                for (int k = 0; k < 10; k++) {
                    // TIME EXECUTION OF .THREE-SUM(0)
                    time = t.timeFunction(() -> {
                        bf3s.threesum(0);
                        return null;
                    });
                    if (k == 0) {
                        min = time;
                    } else {
                        if (time < min) {
                            min = time;
                        }
                    }
                }
                // ADD THE SMALLEST RUN TIME TO MINIMUMS
                minimums.add(min);
            }
            System.out.println("\n"+i);

            // MINIMUMS NOW CONTAINS 10 SMALLEST RUNNING TIMES OF THE .THREE-SUM(0) FUNCTION
            // TAKE THE AVERAGE OF THOSE 10 RUNNING TIMES AND ADD TO THE TIMES
            times.add(fs.findAverageValue(minimums));
            // ADD THE CURRENT SIZE TO THE SIZES
            sizes.add(bf3s.getNrElements());

        }

        // PRINT TIMES
        System.out.println("NAIVE 3-SUM TIMES:");
        for (int i = 0; i < times.size(); i++) {
            System.out.println(sizes.get(i) + "\t SIZE: --> " + times.get(i) + " nanoseconds");
        }

//        CSVReaderWriter readerWriter = new CSVReaderWriter();
//        readerWriter.writeToFile(times, sizes, "src/Problem7/Naive3Sum_8.csv");
    }
}
