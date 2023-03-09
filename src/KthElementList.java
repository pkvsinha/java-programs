public class KthElementList {

  public static void main(String[] args) {
    Lists.List list = Lists.from(new int[] {1, 2, 3, 4, 5, 6});
    System.out.println(kth(list, 2));
  }

  private static Integer kth(Lists.List list, int k) {
    Lists.Node end = list.head;
    int i = 0;
    while(end != null && i < k) {
      end = end.next;
      i++;
    }
    Lists.Node start = list.head;
    while (end != null) {
      start = start.next;
      end = end.next;
    }

    return start.value;
  }
}
