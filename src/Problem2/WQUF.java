package Problem2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Weighted Quick Union Find
 */
public class WQUF {
    private final int[] roots;
    private final int[] sizes;

    /**
     * Create 2 arrays: 1 for the roots of the elements and 1 for the sizes of the sets.
     * @param elements The number of elements (and size of the array).
     */
    public WQUF(int elements){
        this.roots = IntStream.range(0, elements).toArray();
        this.sizes = IntStream.generate(() -> 1).limit(elements).toArray();
    }

    public void printInfo() {
        System.out.println("ARRAY:");
        System.out.println(Arrays.toString(this.roots));
        System.out.println("SIZES:");
        System.out.println(Arrays.toString(this.sizes));
    }

    /**
     * Find the root of the set that int A belongs to.
     * @param a An integer (and an index of the array).
     * @return An integer (and an index of the array).
     */
    public int findRoot(int a) {
        while (a != roots[a])
            a = roots[a];
        return a;
    }

    /**
     * Unite the smaller set to the larger set, by checking the sizes of each set,
     * and increase the size of the chosen set afterwards.
     * @param a An integer (and an index of the array).
     * @param b An integer (and an index of the array).
     */
    public void union(int a, int b) {
        int rootA = findRoot(a);
        int rootB = findRoot(b);
        if (sizes[rootA] < sizes[rootB]) {
            roots[rootA] = rootB;
            sizes[rootB] += sizes[rootA];
        } else {
            roots[rootB] = rootA;
            sizes[rootA] += sizes[rootB];
        }

    }

    /**
     * Check if 2 elements are in the same set.
     * @param a An integer (and an index of the array).
     * @param b An integer (and an index of the array).
     * @return True or False.
     */
    public boolean connected(int a, int b) {
        return findRoot(a) == findRoot(b);
    }

    /**
     * Path compression. Does the same as the 'findRoot' method,
     * but also compresses the paths to root of indirect searched children.
     */
    public int collapsingFindRoot(int a){
        int root = a;
        while (root != roots[root]){ // find the root iteratively
            root = roots[root];
        }

        while (roots[a] != root){
            int next = roots[a]; // save next member before reassigning the root
            roots[a] = root; // assign original root to member
            a = next; // take next member in line & repeat operation until original root is found
        }
        return root;
    }


    public static void main(String[] args) {

        WQUF wquf = new WQUF(15);
        wquf.printInfo();
        wquf.union(0, 1);
        wquf.union(1, 2);

        wquf.union(3, 4);
        wquf.union(4, 5);
        wquf.union(5, 6);

        wquf.union(7, 8);
        wquf.union(8, 9);
        wquf.union(9, 10);
        wquf.union(10, 11);
        wquf.union(11, 12);
        wquf.union(12, 13);
        wquf.union(13, 14);

        wquf.union(0, 3);
        wquf.union(5, 11);

        wquf.printInfo();

        System.out.println("PERFORM COLLAPSING FIND ROOT:");
        wquf.collapsingFindRoot(2);
        wquf.printInfo();

    }
}
