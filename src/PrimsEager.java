import java.util.Queue;

public class PrimsEager {

  private Edge[] edgeTo;
  private int[] distTo;
  private boolean[] marked;
  private IndexMinPQ<Integer> pq;
  
  public PrimsEager(EdgeWeightedGraph graph) {
    edgeTo = new Edge[graph.V()];
    distTo = new int[graph.V()];
    marked = new boolean[graph.V()];
    for (int i = 0; i < graph.V(); i++) {
      distTo[i] = Integer.MAX_VALUE;
    }
    pq = new IndexMinPQ<>(graph.V());
    distTo[0] = 0;
    pq.insert(0, 0);
    while (!pq.isEmpty()) visit(graph, pq.removeMin());
  }

  private void visit(EdgeWeightedGraph graph, int v) {
    marked[v] = true;
    for (Edge e : graph.adj(v)) {
      int w = e.other(v);
      if (marked[w]) continue;
      if (e.weight() < distTo[w]) {
        edgeTo[w] = e;
        distTo[w] = e.weight();
        if (pq.contains(w)) pq.change(w, distTo[w]);
        else pq.insert(w, distTo[w]);
      }
    }
  }
}
