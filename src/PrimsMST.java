import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimsMST extends MST {

  private boolean[] marked;
  private Queue<Edge> mst;
  private int weight;
  private PriorityQueue<Edge> pq;

  public PrimsMST(EdgeWeightedGraph graph) {
    this.marked = new boolean[graph.V()];
    this.mst = new ArrayDeque<>();
    this.pq = new PriorityQueue<>();
    build(graph);
  }

  protected void build(EdgeWeightedGraph graph) {
    visit(graph, 0);
    while (!pq.isEmpty()) {
      Edge e = pq.poll();
      int v = e.either(), w = e.other(v);
      if (marked[v] && marked[w]) continue;
      mst.add(e);
      weight += e.weight();
      if (!marked[v]) visit(graph, v);
      if (!marked[w]) visit(graph, w);
    }
  }

  private void visit(EdgeWeightedGraph graph, int v) {
    marked[v] = true;
    for (Edge e : graph.adj(v)) {
      if (!marked[e.other(v)]) pq.add(e);
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
