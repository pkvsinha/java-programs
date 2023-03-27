import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrimsEager extends MST {

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
    build(graph);
  }

  @Override
  protected void build(EdgeWeightedGraph graph) {
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

  @Override
  public Iterable<Edge> edges() {
    List<Edge> treeEdges = new ArrayList<>();
    // 0  1  2   3   4   5   6
    //   01  02  13  24  35  56
    for (Edge edge : edgeTo) {
      if (edge != null) treeEdges.add(edge);
    }
    return treeEdges;
  }

  @Override
  public int weight() {
    int weight = 0;
    for (int dist : distTo) {
      weight += dist;
    }
    return weight;
  }
}
