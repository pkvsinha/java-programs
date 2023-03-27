public class MSTTestClient {
  
  public static void main(String[] args) {
    EdgeWeightedGraph graph = buildGraph();
    MST mst = new PrimsMST(graph);
    System.out.println("-------- Lazy Prims ------ ");
    for (Edge e : mst.edges()) {
      System.out.println(e);
    }
    System.out.println(mst.weight());
    System.out.println("----------------------------");
    MST mstEager = new PrimsEager(graph);
    System.out.println("-------- Eager Prims ------ ");
    for (Edge e : mstEager.edges()) {
      System.out.println(e);
    }
    System.out.println(mstEager.weight());

    System.out.println("----------------------------");
    MST mstKrukshal = new KrukshalMST(graph);
    System.out.println("-------- Krukshal ------ ");
    for (Edge e : mstKrukshal.edges()) {
      System.out.println(e);
    }
    System.out.println(mstKrukshal.weight());
    System.out.println("----------------------------");
  }

  private static EdgeWeightedGraph buildGraph() {
    EdgeWeightedGraph graph = new EdgeWeightedGraph(8);
    for (int[] lines : testdata) {
      int v = lines[0], w = lines[1], weight = lines[2];
      graph.addEdge(new Edge(v, w, weight));
    }
    return graph;
  }

  private static int[][] testdata = new int[][]{
    {4, 5, 35},
    {4, 7, 37},// 37
    {5, 7, 28},// 28
    {0, 7, 16},// 
    {1, 5, 32},
    {0, 4, 38},
    {2, 3, 17},
    {1, 7, 19},// 19
    {0, 2, 26},
    {1, 2, 36},
    {1, 3, 29},
    {2, 7, 34},// 34 
    {6, 2, 40},
    {3, 6, 52},
    {6, 0, 58},
    {6, 4, 93},
  };
}
