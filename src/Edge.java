public class Edge implements Comparable<Edge>{

  private int v;

  private int w;

  private int weight;

  public Edge(int v, int w, int weight) {
    this.v = v;
    this.w = w;
    this.weight = weight;
  }

  public int either() {
    return v;
  }

  public int other(int x) {
    if (x == v) return w;
    return v;
  }

  public int weight() {
    return weight;
  }

  @Override
  public int compareTo(Edge e) {
    if (e == null) return 1;
    if (this.weight == e.weight) return 0;
    if (this.weight < e.weight) return -1;
    return 1;
  }

  @Override
  public String toString() {
    return String.format("%d - %d", v, w);
  }
}