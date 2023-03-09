import java.util.Arrays;

public class ZeroMatrix {
  
  private static void zeroOut(int[][] mat) {
    boolean rowHasZero = false;
    boolean colHasZero = false;

    int rows = mat.length;
    int cols = mat[0].length;

    for (int i = 0; i < cols; i++) {
      if (mat[0][i] == 0) {
        rowHasZero = true;
        break;
      }
    }

    for (int i = 0; i < rows; i++) {
      if (mat[i][0] == 0) {
        colHasZero = true;
        break;
      }
    }

    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < cols; j++) {
        if (mat[i][j] == 0) {
          mat[i][0] = 0;
          mat[0][j] = 0;
        }
      }
    }

    for (int i = 0; i < rows; i++) {
      if (mat[i][0] == 0) nullifyRow(mat, i);
    }

    for (int i = 0; i < cols; i++) {
      if (mat[0][i] == 0) nullifyCol(mat, i);
    }

    if (rowHasZero) {
      nullifyRow(mat, 0);
    }

    if (colHasZero) {
      nullifyCol(mat, 0);
    }
  }

  private static void nullifyCol(int[][] mat, int i) {
    for (int j = 0; j < mat.length; j++) {
      mat[j][i] = 0;
    }
  }

  private static void nullifyRow(int[][] mat, int i) {
    for (int j = 0; j < mat[0].length; j++) {
      mat[i][j] = 0;
    }
  }

  public static void main(String[] args) {
    var mat = new int[][] {
      {1, 2, 3, 4},
      {4, 0, 0, 1},
      {8, 2, 4, 6}
    };
    zeroOut(mat);
    for (var row : mat) {
      System.out.println(Arrays.toString(row));
    }
  }
}
