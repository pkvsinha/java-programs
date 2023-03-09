import java.util.ArrayList;
import java.util.List;

public class AddLists {
  
  static Lists.List reverseList(Lists.List list1, Lists.List list2) {
    var p1 = list1.head;
    var p2 = list2.head;
    int acc = 0;
    List<Integer> list = new ArrayList<>();
    while (p1 != null && p2 != null) {
      var sum = p1.value + p2.value + acc;
      acc = 0;
      if (sum > 10) {
        sum -= 10;
        acc = 1;
      }
      list.add(sum);
      p1 = p1.next;
      p2 = p2.next;
    }
    while (p1 != null) {
      var sum = p1.value + acc;
      acc = 0;
      if (sum > 10) {
        sum -= 10;
        acc = 1;
      }
      list.add(sum);
      p1 = p1.next;
    }
    while (p2 != null) {
      var sum = p2.value + acc;
      acc = 0;
      if (sum > 10) {
        sum -= 10;
        acc = 1;
      }
      list.add(sum);
      p2 = p2.next;
    }
    if (acc > 0) {
      list.add(acc);
    }
    return Lists.from(
      list.stream().mapToInt(i -> i).toArray()
    );
  }

  public static void main(String[] args) {
    Lists.print(reverseList(Lists.from(0, 7), Lists.from(5)));
  }
}
