import java.util.Arrays;
import java.util.HashSet;

import util.PrintUtil;

public class LeetCode73 {
    public static void main(String[] args) {
        int[][] matrix;
        // 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
        // 输出：[[1,0,1],[0,0,0],[1,0,1]]
        matrix = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        System.out.println(Arrays.deepToString(matrix));
        new Solution73_2().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
        PrintUtil.printDivider();

        // 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
        // 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
        matrix = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        System.out.println(Arrays.deepToString(matrix));
        new Solution73_2().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
        PrintUtil.printDivider();
    }
}

class Solution73_1 {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    rows.add(row);
                    cols.add(col);
                }
            }
        }
        for (int row : rows) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = 0;
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col : cols) {
                matrix[row][col] = 0;
            }
        }
    }
}

class Solution73_2 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
