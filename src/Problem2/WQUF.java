package Problem2;

import java.util.Arrays;

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
        this.roots = new int[elements];
        this.sizes = new int[elements];
        Arrays.fill(sizes, 1);
    }

    /**
     * Find the root of the set that int A belongs to.
     * @param a An integer (and an index of the array).
     * @return An integer (and an index of the array).
     */
    public int root(int a) {
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
        int rootA = root(a);
        int rootB = root(b);
        if (sizes[rootA] < sizes[rootB]) {
            roots[rootA] = rootB;
            sizes[rootA] += sizes[rootB];
        } else {
            roots[rootB] = rootA;
            sizes[rootB] += sizes[rootA];
        }

    }

    /**
     * Check if 2 elements are in the same set.
     * @param a An integer (and an index of the array).
     * @param b An integer (and an index of the array).
     * @return True or False.
     */
    public boolean connected(int a, int b) {
        return root(a) == root(b);
    }
}
