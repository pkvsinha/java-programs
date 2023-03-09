public class OneEditAway {
  
  public static void main(String[] args) {
    System.out.println(oneEditAway("pale", "bake"));
  }

  private static boolean oneEditAway(String first, String second) {
    if (first.length() == second.length()) {
      return oneEdit(first, second);
    } else if (first.length() + 1 == second.length()) {
      return oneEdit(second, first);
    } else if (first.length() - 1 == second.length()) {
      return oneEdit(first, second);
    }
    return false;
  }

  private static boolean oneEdit(String first, String second) {
    boolean oneDiffFound = false;
    int i = 0, j = 0;
    while (i < first.length() && j < second.length()) {
      if (first.charAt(i) != second.charAt(j)) {
        if (oneDiffFound) return false;
        oneDiffFound = true;
        if (first.length() == second.length()) {
          j++;
        }
      } else {
        j++;
      }
      i++;
    }
    return true;
  }
}
