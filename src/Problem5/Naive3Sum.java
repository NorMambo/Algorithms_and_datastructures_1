package Problem5;

import HelperClasses.Tuple3;

import java.util.ArrayList;

public class Naive3Sum {

    private int[] arr;

    public Naive3Sum(int arrSize) {
        this.arr = randIntArr(arrSize);
    }

    // TEST VERSION (INSERT YOUR OWN ARRAY)
    public Naive3Sum(int[] arr) {
        this.arr = arr;
    }

    private int[] randIntArr(int arrSize) {
        int[] intArr = new int[arrSize];
        int min = -100;
        int max = 100;
        for (int i = 0; i < intArr.length; i++) {
            int randInt = (int) Math.floor(Math.random() * (max - min + 1) + min);
            intArr[i] = randInt;
        }
        return intArr;
    }

    public ArrayList<Tuple3> threesum(int target) {
        ArrayList<Tuple3> res = new ArrayList<>();
        for (int i = 0; i < this.arr.length; i++) {
            for (int j = i+1; j < this.arr.length; j++) {
                for (int k = j+1; k < this.arr.length; k++) {
                    if (this.arr[i] + this.arr[j] + this.arr[k] == target) {
                        res.add(new Tuple3(arr[i], arr[j], arr[k]));
                    }
                }
            }
        }
        return res;
    }

    public int getNrElements() {
        return this.arr.length;
    }

    public static void main(String[] args) {

        // NAIVE 3SUM TEST
        int[] arr = {0, 1, 2, -2, 1, -1};
        Naive3Sum test = new Naive3Sum(arr);
        int target = 3;
        ArrayList<Tuple3> result = test.threesum(target);
        System.out.println("\nSETS OF 3 INTEGERS IN ARRAY THAT SUM UP TO " + target);
        for (Tuple3 t : result) {
            System.out.println(t.a + " " + t.b + " " + t.c);
        }

    }

}

