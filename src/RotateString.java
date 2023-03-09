public class RotateString {
  
  /**
   * s1 = xy
   * s2 = yx
   * 
   * c = xyxy
   * @param s1
   * @param s2
   * @return
   */
  private static boolean isRotate(String s1, String s2) {
    int n = (s1 == null) ? 0 : s1.length();
    if (n > 0 && (s2 != null && s2.length() != n)) return false;
    String c = s1 + s1;
    return isSubstring(s2, c);
  }

  private static boolean isSubstring(String pat, String text) {
    int j, m = pat.length();
    int i, n = text.length();
    if (m > n) return false;
    i = 0;
    j = 0;
    while (i < n && j < m) {
      if (pat.charAt(j) == text.charAt(i)) {
        j++;
      } else {
        i -= j;
        j = 0;
      }
      i++;
    }
    return j == m;
  }

  public static void main(String[] args) {
    System.out.println(isRotate("waterbottle", "erbottlewat"));
    System.out.println(isSubstring("AABAAA", "AABAABAAAA"));
  }
}
