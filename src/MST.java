public abstract class MST {
  
  public MST(EdgeWeightedGraph graph) {
    
  }

  protected abstract void build(EdgeWeightedGraph graph);

  public abstract Iterable<Edge> edges();

  public abstract int weight();
}
