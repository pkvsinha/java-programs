import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxHeap<T extends Comparable<T>> {

  private PriorityQueue<T> data;

  public MaxHeap() {
    data = new PriorityQueue<>(Comparator.reverseOrder());
  }

  void add(T t) {
    data.offer(t);
  }

  T max() {
    return data.poll();
  }
}