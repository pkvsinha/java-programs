public class EdgeWeightedGraph {

  private Bag<Edge>[] adjList;

  private int V;
  
  public EdgeWeightedGraph(int V) {
    this.V = V;
    this.adjList = new Bag[V];
    for (int i = 0; i < V; i++) {
      this.adjList[i] = new Bag<Edge>();
    }
  }

  public int V() {
    return this.V;
  }

  public int E() {
    return -1;
  }

  public void addEdge(Edge edge) {
    int v = edge.either(), w = edge.other(v);
    adjList[v].add(edge);
    adjList[w].add(edge);
  }

  public Iterable<Edge> adj(int v) {
    return adjList[v];
  }

  public Iterable<Edge> edges() {
    Bag<Edge> edges = new Bag<>();
    for (int v = 0; v < V; v++) {
      for (Edge e : adj(v)) {
        // filtering out self loops and only towards higher vertex 0 -> 1.
        // so that it is only counted once. not 1 -> 0
        if (e.other(v) > v) edges.add(e); 
      }
    }

    return edges;
  }
}
