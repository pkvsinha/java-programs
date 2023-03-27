public class UnionFind {

    private int count;

    private int[] data;
    
    private int[] size;
    
    public UnionFind(int capacity) {
        this.data = new int[capacity];
        this.size = new int[capacity];
        for (var i = 0; i < capacity; i++) {
            this.data[i] = i;
            this.size[i] = 1;
            count++;
        }
    }

    public void union(int v, int w) {
        int rv = root(v);
        int rw = root(w);
        if (rv == rw) return;
        if (size[rv] > size[rw]) {
            data[rw] = rv;
            size[rv] += size[rw];
        } else {
            data[rv] = rw;
            size[rw] += size[rv];
        }
        count--;
    }

    private int root(int v) {
        while (v != data[v]) v = data[v];
        return v;
    }

    public boolean connected(int v, int w) {
        return root(v) == root(w);
    }

    public int count() {
        return count;
    }
}
