package Problem6;

import HelperClasses.Tuple3;

import java.util.ArrayList;
import java.util.Arrays;

public class LRPointer3Sum {
    int[] arr;
    public LRPointer3Sum(int size) {
        this.arr = randIntArr(size);
    }

    // TEST VERSION (INSERT YOUR OWN ARRAY)
    public LRPointer3Sum(int[] arr) {
        this.arr = arr;
    }

    private int[] randIntArr(int arrSize) {
        int[] intArr = new int[arrSize];
        int min = -10000;
        int max = 10000;
        for (int i = 0; i < intArr.length; i++) {
            int randInt = (int) Math.floor(Math.random() * (max - min + 1) + min);
            intArr[i] = randInt;
        }
        return intArr;
    }

    public ArrayList<Tuple3> threesum(int target) {

        ArrayList<Tuple3> result = new ArrayList<>();
        Arrays.sort(this.arr);

        for (int i = 0; i < this.arr.length; i++) {

            if (i > 0 && this.arr[i] == this.arr[i - 1]) {
                continue;
            }

            int l_pointer = i + 1;
            int r_pointer = this.arr.length - 1;

            while(l_pointer < r_pointer) {

                int sum = this.arr[i] + this.arr[l_pointer] + this.arr[r_pointer];

                if (sum > target) {
                    r_pointer -= 1;
                } else if (sum < target) {
                    l_pointer += 1;
                } else {
                    result.add(new Tuple3(this.arr[i], this.arr[l_pointer], this.arr[r_pointer]));
                    l_pointer += 1;

                    while(this.arr[l_pointer] == this.arr[l_pointer - 1] && l_pointer < r_pointer) {
                        l_pointer += 1;
                    }
                }
            }

        }

        return result;
    }

    public int getNrElements() {
        return this.arr.length;
    }

    public static void main(String[] args) {

        // LEFT RIGHT POINTER 3SUM TEST
        int[] arr = {0, 1, 2, -2, 1, -1};
        LRPointer3Sum test = new LRPointer3Sum(arr);
        int target = 3;
        ArrayList<Tuple3> result = test.threesum(target);

        System.out.println("\nSETS OF 3 INTEGERS IN ARRAY THAT SUM UP TO " + target);
        for (Tuple3 t : result) {
            System.out.println(t.a + " " + t.b + " " + t.c);
        }

    }
}