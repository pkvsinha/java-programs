public class IndexMinPQ<T extends Comparable<T>> {

  private int heapSize;

  private final int capacity;

  private T[] keys;

  private int[] indexHeap;

  private int[] inverseIndex;

  public IndexMinPQ(int capacity) {
    this.capacity = capacity;
    this.keys = (T[]) new Comparable[capacity];
    this.indexHeap = new int[capacity];
    this.inverseIndex = new int[capacity];
    for (int i = 0; i < capacity; i++) {
      this.inverseIndex[i] = -1;
    }
  }

  public void insert(int k, T item) {
    keys[k] = item; // permanent storage of key-value
    inverseIndex[k] = heapSize;
    indexHeap[heapSize] = k;
    swim(heapSize++);
  }
  
  private void swim(int i) {
    while(i > 0 && greater(parent(i), i)) {
      swap(i, parent(i));
      i = parent(i);
    }
  }
  
  private boolean greater(int i, int j) {
    return keys[indexHeap[i]].compareTo(keys[indexHeap[j]]) > 0;
  }

  private void swap(int i, int j) {
    int temp = indexHeap[i];
    indexHeap[i] = indexHeap[j];
    indexHeap[j] = temp;
    inverseIndex[indexHeap[i]] = i;
    inverseIndex[indexHeap[j]] = j;
  }

  public int removeMin() {
    int minIndex = indexHeap[0];
    swap(0, --heapSize);
    sink(0);

    inverseIndex[minIndex] = -1;
    keys[minIndex] = null;
    indexHeap[heapSize] = -1;
    
    return minIndex;
  }

  private void sink(int i) {
    while(left(i) < heapSize) {
      int j = left(i);
      if (j < (heapSize - 1) && greater(j, right(i))) j = right(i);
      if (!greater(i, j)) break;
      swap(i, j);
      i = j;
    }
  }

  public void change(int k, T item) {
    keys[k] = item;
    swim(inverseIndex[k]);
    sink(inverseIndex[k]);
  }
  
  public boolean contains(int k) {
    return inverseIndex[k] != -1;
  }

  public void remove(int k) {
    int i = inverseIndex[k];
    swap(i, --heapSize);
    swim(i);
    sink(i);
    keys[k] = null;
    inverseIndex[k] = -1;
  }

  public T peek() {
    return keys[indexHeap[0]];
  }

  public int peekMinIndex() {
    return indexHeap[0];
  }

  public boolean isEmpty() {
    return heapSize == 0;
  }

  public int size() {
    return heapSize;
  }

  private int left(int i) {
    return 2 * i + 1;
  }

  private int right(int i) {
    return left(i) + 1;
  }

  private int parent(int i) {
    return (i - 1) / 2;
  }
}
