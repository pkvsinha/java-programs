public class UnionFindTest {
    
    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        for (int[] point : data) {
            uf.union(point[0], point[1]);
        }
        System.out.println(uf.count());
    }

    private static final int[][] data = {
        {4, 3},
        {3, 8},
        {6, 5},
        {9, 4},
        {2, 1},
        {8, 9},
        {5, 0},
        {7, 2},
        {6, 1},
        {1, 0},
        {6, 7},
    };
}
