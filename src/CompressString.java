public class CompressString {
  
  public static void main(String[] args) {
    System.out.println(compress("aaadddddbbffffffffccg"));
  }

  private static String compress(String string) {
    char[] chars = string.toCharArray();
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < string.length();) {
      int j = i + 1;
      int count = 1;
      while (j < string.length() && chars[j] == chars[i]) {
        count++;
        j++;
      }
      builder.append(chars[i]);
      builder.append(count);
      i = j;
    }
    String compressed = builder.toString();
    return compressed.length() > string.length() ? string : compressed;
  }
}
