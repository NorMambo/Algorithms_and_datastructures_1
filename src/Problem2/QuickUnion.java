package Problem2;

import Problem1.QuickFind;

public class QuickUnion {
    private final int[] arr;
    private int elements;

    public QuickUnion (int elements) {
        int[] arr = new int[elements];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        this.elements = elements;
        this.arr = arr;
    }

    public void union (int a, int b) {
        int root_a = root( a);
        int root_b = root( b);
        this.arr[root_a] = root_b;
    }

    public boolean connected (int a, int b) {
        return root(a) == root(b);
    }

    public int root (int a) {
        while(a != this.arr[a]) {
            a = this.arr[a];
        }
        return a;
    }
    public void printArr() {
        for (int i : this.arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int getNrElements() {
        return this.elements;
    }

    public static void main(String[] args) {

        // TEST QUICK UNION
        QuickUnion qu = new QuickUnion(10);
        System.out.println("\nORIGINAL ARRAY:");
        qu.printArr();
        System.out.println("\nUNITE 0 AND 9");
        qu.union(0,9);
        qu.printArr();
        System.out.println("\nCONNECTED 0 AND 9:");
        System.out.println(qu.connected(0, 9));
        System.out.println("\nUNITE 0 AND 2");
        qu.union(0,2);
        qu.printArr();
        System.out.println("\nCONNECTED 0 AND 9:");
        System.out.println(qu.connected(0, 2));
        System.out.println("\nCONNECTED 2 AND 9:");
        System.out.println(qu.connected(0, 2));
    }
}
