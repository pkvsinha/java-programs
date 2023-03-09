import java.util.PriorityQueue;

public class MinHeap<T extends Comparable<T>> {

  private PriorityQueue<T> data;

  public MinHeap() {
    data = new PriorityQueue<>();
  }

  void add(T t) {
    data.offer(t);
  }

  T min() {
    return data.poll();
  }
}