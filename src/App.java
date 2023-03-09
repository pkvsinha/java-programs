public class App {

  private static void runMinHeapTests() {
    MinHeap<Integer> heap = new MinHeap<>();
    heap.add(19);
    heap.add(8);
    heap.add(20);
    heap.add(90);
    heap.add(12);
    System.out.println(heap.min());
    System.out.println(heap.min());
    System.out.println(heap.min());
    System.out.println(heap.min());
  }

  private static void runMaxHeapTests() {
    MaxHeap<Integer> heap = new MaxHeap<>();
    heap.add(19);
    heap.add(8);
    heap.add(20);
    heap.add(90);
    heap.add(12);
    System.out.println(heap.max());
    System.out.println(heap.max());
    System.out.println(heap.max());
    System.out.println(heap.max());
  }

  public static void main(String[] args) {
    runMaxHeapTests();
  }
}