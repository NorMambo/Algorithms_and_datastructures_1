package Problem1;

public class QuickFind {

    private int[] arr;

    public QuickFind (int elements) {
        int[] arr = new int[elements];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        this.arr = arr;
    }

    public void union(int a, int b) {
        int id_a = this.arr[a];
        int id_b = this.arr[b];

        for (int i = 0; i < arr.length; i++) {
            if (this.arr[i] == id_a) {
                this.arr[i] = id_b;
            }
        }
    }

    public boolean connected(int a, int b) {
        return (arr[a] == arr[b]);
    }

    public int getNrElements() {
        return this.arr.length;
    }

    public void printArr() {
        for (int i : this.arr) {
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