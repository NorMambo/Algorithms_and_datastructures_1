package Problem4;

import Problem2.QuickUnion;
import Problem3.Timer;

import java.io.IOException;
import java.util.ArrayList;

public class FindRunTimesQuickUnion {

    public static void main(String[] args) throws IOException {

        // 100 arrays starting at 100 always increased by 100
        int factor = 100;
        ArrayList<QuickUnion> quList = new ArrayList<>();

        // CREATE A LIST OF 100 QUICK-FIND CLASSES
        for (int i = 1; i <= 1000; i++) {
            QuickUnion qu = new QuickUnion(i*factor);
            quList.add(qu);
        }

        Timer t = new Timer();
        ArrayList<Double> times = new ArrayList<>();
        ArrayList<Integer> sizes = new ArrayList<>();

        // FOR EVERY INSTANCE OF QUICK-UNION CLASS
        for (int i = 0; i < quList.size(); i++) {

            // GET THE INSTANCE
            QuickUnion qu = quList.get(i);

            // MINIMUMS WILL CONTAIN 10 MINIMUM RUNNING TIMES OF QUICK-UNION.UNION()
            ArrayList<Double> minimums = new ArrayList<>();

            // EXECUTE 10 TIMES 10 .UNION OPERATIONS WITH THE CURRENT INSTANCE OF QUICK-UNION
            for (int j = 0; j < 10; j++) {

                double min = 0;
                double time;

                // RUN .UNION(first element, last element) 10 TIMES
                // BUT ONLY TAKE THE MINIMUM TIME TO PERFORM THE UNION
                for (int k = 0; k < 10; k++) {
                    // TIME EXECUTION OF .UNION
                    int last_pos = qu.getNrElements() - 1;
                    time = t.timeFunction(() -> {
                        qu.union(0, last_pos);
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
            sizes.add(qu.getNrElements());

        }

        // PRINT TIMES
        System.out.println("QUICK-UNION TIMES:");
        for (int i = 0; i < times.size(); i++) {
            System.out.println(sizes.get(i) + "\t SIZE: --> " + times.get(i) + " nanoseconds");
        }

//        CSVReaderWriter readerWriter = new CSVReaderWriter();
//        readerWriter.writeToFile(times, sizes, "src/Problem4/QuickUnion_1000.csv");
    }
}