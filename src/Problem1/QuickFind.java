package Problem1;

public class QuickFind {

    private int[] arr;

    public QuickFind (int elements) {

        // Create an array of increasing numbers starting from 0.
        // The numbers represent group id's.
        // At first, every index has its own id.
        arr = new int[elements];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i; // [0, 1, 2, 3, ...., N]
        }
    }

    // A and B are indexes and we want to connect them.
    // To show that they are connected, the value at their index in the array needs to be equal.
    // At first, all the values are different, because every index is its own set.
    // When we perform a union of two indexes, the values at their position become equal.
    // We can decide which value to use (value of index a or value of index b).
    public void union(int a, int b) {
        int id_a = arr[a];
        int id_b = arr[b];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == id_a) {
                arr[i] = id_b;
            }
        }
    }

    // constant time operation that tells us if two indexes are have the same id
    // (or, if two indexes are connected).
    public boolean connected(int a, int b) {
        return (arr[a] == arr[b]);
    }

    public int getNrElements() {
        return arr.length;
    }

    public void printArr() {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // TEST QUICK FIND
        QuickFind qf = new QuickFind(10);
        System.out.println("\nORIGINAL ARRAY:");
        qf.printArr();
        System.out.println("\nUNITE 0 AND 9");
        qf.union(0,9);
        qf.printArr();
        System.out.println("\nCONNECTED 0 AND 9:");
        System.out.println(qf.connected(0, 9));
        System.out.println("\nUNITE 0 AND 2");
        qf.union(0,2);
        qf.printArr();
        System.out.println("\nCONNECTED 0 AND 9:");
        System.out.println(qf.connected(0, 2));
        System.out.println("\nCONNECTED 2 AND 9:");
        System.out.println(qf.connected(0, 2));
    }
}