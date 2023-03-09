import java.util.Arrays;

public class RotateMatrix {


  public static void rotate(int[][] mat) {
    int rows = mat.length;
    int cols = mat[0].length;
    if (rows != cols) return;
    int n = rows;
    for (int layer = 0; layer < n / 2; layer++) {
      int first = layer;
      int last = n - layer - 1;
      for (int i = first; i < last; i++) {
        // TODO : understand the logic here before implementing.
      }
    }
  }
  public static void main(String[] args) {
    var mat = new int[][] {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12}
    };
    rotate(mat);
    for (var row : mat) {
      System.out.println(Arrays.toString(row));
    }
  }
  
}
