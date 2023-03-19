public abstract class MST {
  
  public MST(EdgeWeightedGraph graph) {
    
  }

  protected abstract void build(EdgeWeightedGraph graph);

  public Iterable<Edge> edges() {
    return null;
  }

  public int weight() {
    return -1;
  }
}
