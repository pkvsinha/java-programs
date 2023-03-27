public abstract class MST {
  
  protected abstract void build(EdgeWeightedGraph graph);

  public abstract Iterable<Edge> edges();

  public abstract int weight();
}
