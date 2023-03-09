public class PalindromePermutation {
  
  public static void main(String[] args) {
    System.out.println(isPalindrome("abcdbab"));
  }

  private static boolean isPalindrome(String string) {
    return useBitVector(string);
  }

  private static boolean useBitVector(String string) {
    int bitVector = createBitVector(string);
    return exactlyOneOne(bitVector);
  }

  private static int createBitVector(String string) {
    int bitVector = 0;
    for (char ch : string.toCharArray()) {
      int value = ch - 'a';
      int mask = 1 << value;
      if ((bitVector & mask) == 0) {
        bitVector |= mask;
      } else {
        bitVector &= ~mask;
      }
    }
    return bitVector;
  }

  private static boolean exactlyOneOne(int bitVector) {
    return (bitVector & (bitVector - 1)) == 0;
  }



  private boolean usingArrays(String string) {
    int[] charTable = new int[26];
    for (char ch : string.toCharArray()) {
      charTable[ch - 'a'] += 1;
    }
    boolean oddFound = false;
    for (int count : charTable) {
      if (odd(count)) {
        if (oddFound) return false;
        oddFound = true;
      }
    }
    return true;
  }

  private static boolean even(int n) {
    return n % 2 == 0;
  }

  private static boolean odd(int n) {
    return !even(n);
  }


}
