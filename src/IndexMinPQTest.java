public class IndexMinPQTest {
  
  public static void main(String[] args) {
    int[] strings = { 8, 2, 4, 5, 3, 1, 9, 6, 7 };
    IndexMinPQ<Integer> pq = new IndexMinPQ<>(strings.length);

    for (int i = 0; i < strings.length; i++) {
      pq.insert(i, strings[i]);
    }

    // delete and print each key
    while (!pq.isEmpty()) {
        int i = pq.removeMin();
        System.out.println(i + " " + strings[i]);
    }
  }
}
