import java.util.Arrays;

import util.PrintUtil;

public class LeetCode48 {
    public static void main(String[] args) {
        int[][] matrix;
        // 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        // 输出：[[7,4,1],[8,5,2],[9,6,3]]
        matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        new Solution48_1().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
        PrintUtil.printDivider();

        // 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
        // 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
        matrix = new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
        new Solution48_1().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
        PrintUtil.printDivider();
    }
}

/**
 * 逐层轮转赋值
 */
class Solution48_1 {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int[][] starts = new int[4][2];
        int[][] currents = new int[4][2];
        int[] cache = new int[4];
        while (N > 1) {
            // 每条边的起始点
            starts[0] = new int[] { 0 + (matrix.length - N) / 2, 0 + (matrix.length - N) / 2 };
            starts[1] = new int[] { starts[0][0], starts[0][1] + N - 1 };
            starts[2] = new int[] { starts[0][0] + N - 1, starts[0][1] + N - 1 };
            starts[3] = new int[] { starts[0][0] + N - 1, starts[0][1] };
            // System.out.println(N);
            // System.out.println("starts:" + Arrays.deepToString(starts));
            for (int i = 0; i < N - 1; i++) {
                // System.out.println("\tind: " + i);
                for (int j = 0; j < 4; j++) {
                    currents[j] = new int[] { starts[j][0] + i * dirs[j][0], starts[j][1] + i * dirs[j][1] };
                }
                // System.out.println("\tcurrents: " + Arrays.deepToString(currents));
                // 存储每条边上对应的点
                for (int j = 0; j < 4; j++) {
                    cache[j] = matrix[currents[j][0]][currents[j][1]];
                }
                // System.out.println("\tcache: " + Arrays.toString(cache));
                // 旋转cache数组并将值传回去
                for (int j = 0; j < 4; j++) {
                    matrix[currents[j][0]][currents[j][1]] = cache[(j + 3) % 4];
                }
            }
            N -= 2;
        }
    }
}

/**
 * 先转置后翻转
 */
class Solution48_2 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 第一步，转置矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 第二步，反转每一行
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}