package Problem2;

import java.util.Arrays;

public class Heapsort {

    private int left;
    private int right;
    int[] maxBinaryHeap;

    // Create this to sort the entire array
    public Heapsort(int[] arr) {
        this.left = 0;
        this.right = arr.length-1;
        maxBinaryHeap = arr;
    }

    private void _sink(int parentPos) {

        int childPos = 2 * parentPos + 1; // position of 1st child

        while (childPos <= right) { // (2 * k + 1) needs to be within array bounds

            // invert comparison here to convert from min to max heap or viceversa
            if (childPos < right && maxBinaryHeap[childPos] < maxBinaryHeap[childPos + 1]) // use right child if it is larger (smaller)
                childPos++;

            // invert comparison also here to convert from min to max heap or viceversa
            if (maxBinaryHeap[parentPos] >= maxBinaryHeap[childPos]) {// if parent is larger (smaller) than largest (smallest) child, STOP
                break;
            } else {
                swap(parentPos, childPos);
                parentPos = childPos; // repeat the procedure but with increased parent position
            }
        }
    }

    public void sort() {

        int k = right/2;

        while (k >= left) { // ensure that we are dealing with a max (or min) heap
            _sink(k);
            k--; // move to the next parent
        }

        while (right >= left) {
            swap(left, right);
            right--;
            _sink(left);
        }
    }

        private void swap(int a, int b) {
        int tmp = maxBinaryHeap[a];
        maxBinaryHeap[a] = maxBinaryHeap[b];
        maxBinaryHeap[b] = tmp;
    }

    public static void main(String[] args) {

        // TESTING (Positions start at 0 and sorting happens in place)
        int[] arr = {9, 8, 7, 6};
        int[] arrForSliceSort = {9, 8, 7, 5, 6, 5, 4, 3, 2, 1};

        // test the sorting of the complete array
        Heapsort heapsort = new Heapsort(arrForSliceSort);
        System.out.println("\nSorting full array: \n" + Arrays.toString(arrForSliceSort));
        heapsort.sort();
        System.out.println("Sorted: \n"+ Arrays.toString(arrForSliceSort));
        System.out.println("\n---------------------------\n");

    }
}
