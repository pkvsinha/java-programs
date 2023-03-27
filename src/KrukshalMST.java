import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class KrukshalMST extends MST {

    private Queue<Edge> mst;

    private int weight;

    public KrukshalMST(EdgeWeightedGraph graph) {
        mst = new ArrayDeque<>();
        build(graph);
    }

    @Override
    protected void build(EdgeWeightedGraph graph) {
        final PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (Edge edge : graph.edges()) {
            pq.add(edge);
        }
        UnionFind uf = new UnionFind(graph.V());
        while(!pq.isEmpty() && mst.size() < graph.V() - 1) {
            Edge e = pq.poll();
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w)) continue;
            uf.union(v, w);
            weight += e.weight();
            mst.offer(e);
        }
    }

    @Override
    public Iterable<Edge> edges() {
        return mst;
    }

    @Override
    public int weight() {
        return weight;
    }
    
}
