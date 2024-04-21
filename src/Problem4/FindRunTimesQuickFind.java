package Problem4;

import Problem1.QuickFind;
import Problem3.Timer;

import java.io.IOException;
import java.util.ArrayList;

public class FindRunTimesQuickFind {

    public static void main(String[] args) throws IOException {

        // 100 arrays starting at 100.000 always increased by 100.000
        int factor = 100000;
        ArrayList<QuickFind> qfList = new ArrayList<>();

        //CREATE A LIST OF 100 QUICK-FIND CLASSES
        for (int i = 1; i <= 100; i++) {
            QuickFind qf = new QuickFind(i*factor);
            qfList.add(qf);
        }

        Timer t = new Timer();
        ArrayList<Double> times = new ArrayList<>();
        ArrayList<Integer> sizes = new ArrayList<>();

        // FOR EVERY INSTANCE OF QUICK-FIND CLASS
        for (int i = 0; i < qfList.size(); i++) {

            // GET THE INSTANCE
            QuickFind qf = qfList.get(i);

            // MINIMUMS WILL CONTAIN 10 MINIMUM RUNNING TIMES OF QUICK-FIND.UNION()
            ArrayList<Double> minimums = new ArrayList<>();

            // EXECUTE 10 TIMES 10 .UNION OPERATIONS WITH THE CURRENT INSTANCE OF QUICK-FIND
            for (int j = 0; j < 10; j++) {

                double min = 0;
                double time;

                // RUN .UNION(first element, last element) 10 TIMES
                // BUT ONLY TAKE THE MINIMUM TIME TO PERFORM THE UNION
                for (int k = 0; k < 10; k++) {
                    // TIME EXECUTION OF .UNION
                    int last_pos = qf.getNrElements() - 1;
                    time = t.timeFunction(() -> {
                        qf.union(0, last_pos);
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
                // ADD THE SMALLEST RUNNING TIME TO MINIMUMS
                minimums.add(min);
            }

            // MINIMUMS NOW CONTAINS 10 SMALLEST RUNNING TIMES OF THE .UNION() FUNCTION
            // TAKE THE AVERAGE OF THOSE 10 RUNNING TIMES
            double sum = 0;
            for (Double time : minimums) {
                sum+=time;
            }
            double avg_min = sum/minimums.size();

            // ADD THE RUNNING TIME AVERAGE_VALUE TO THE TIMES
            times.add(avg_min);
            // ADD THE CURRENT SIZE TO THE SIZES
            sizes.add(qf.getNrElements());

        }

        // PRINT TIMES
        System.out.println("QUICK-FIND TIMES:");
        for (int i = 0; i < times.size(); i++) {
            System.out.println(sizes.get(i) + "\t SIZE: --> " + times.get(i) + " nanoseconds");
        }

//        CSVReaderWriter readerWriter = new CSVReaderWriter();
//        readerWriter.writeToFile(times, sizes, "src/Problem4/QuickFind_100.csv");
    }
}