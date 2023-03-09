public class Lists {
  
  public static class Node {
    int value;
    Node next;
  }

  public static class List {
    Node head;
  }

  public static List from (int... array) {
    List list = new List();
    Node ptr = list.head = new Node();
    ptr.value = array[0];
    for (int i = 1; i < array.length; i++) {
      ptr.next = new Node();
      ptr.next.value = array[i];
      ptr = ptr.next;
    }

    return list;
  }

  public static List reverse(List list) {
    Node prev = null;
    Node current = list.head;
    Node next = null;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    list.head = prev;
    return list;
  }

  public static void print(List list) {
    Node ptr = list.head;
    StringBuilder builder = new StringBuilder();
    while (ptr != null) {
      builder.append(ptr.value).append(" -> ");
      ptr = ptr.next;
    }
    builder.delete(builder.length() - 4, builder.length());
    System.out.println(builder.toString());
  }
}
