public class IndexMinPQ<T extends Comparable<T>> {

  private int heapSize;

  private int n;

  private T[] keys;

  private int[] heapIndex;

  private int[] index;

  public IndexMinPQ(int maxN) {
    this.n = maxN;
    this.keys = (T[]) new Comparable[maxN];
    this.index = new int[maxN];
    for (int i = 0; i < maxN; i++) {
      this.index[i] = -1;
    }
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

  private void swap(int i, int j) {
    T temp = keys[i];
    keys[i] = keys[j];
    keys[j] = temp;
    heapIndex[index[i]] = i;
    heapIndex[index[j]] = j;
  }

  private boolean greater(int i, int j) {
    return keys[i].compareTo(keys[j]) > 0;
  }

  private void sink(int i) {
    while(i < heapSize) {
      int j = left(i);
      if (j < (heapSize - 1) && greater(j, right(i))) j = right(i);
      if (!greater(i, j)) break;
      swap(i, j);
      i = j;
    }
  }

  private void swim(int i) {
    while(i > 0 && greater(parent(i), i)) {
      swap(i, parent(i));
      i = parent(i);
    }
  }

  public void insert(int k, T item) {
    inverseIndex[k] = heapSize;
    index[heapSize] = k;
    keys[heapSize] = item;
    
    heapSize++;
    swim(heapSize - 1);
  }

  public void change(int k, T item) {
    
  }

  public boolean contains(int k) {
    return this.index[k] != -1;
  }

  public void remove(int k) {
    int i = index[k];
    index[k] = -1;
  }

  public T peek() {
    return keys[0];
  }

  public int peekMinIndex() {
    return findIndex(0);
  }

  private int findIndex(int k) {
    for (int i = 0; i < n; i++) {
      if (index[i] == k) return i;
    }
    return -1;
  }

  public int removeMin() {
    // T top = keys[0];
    heapSize--;
    // int k = findIndex(heapSize);
    int k = index[0];
    keys[0] = keys[heapSize];
    index[peekMinIndex()] = -1;
    sink(0);
    return k;
  }

  public boolean isEmpty() {
    return heapSize == 0;
  }

  public int size() {
    return heapSize;
  }
}
