import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode54 {
    public static void main(String[] args) {
        // 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        // 输出：[1,2,3,6,9,8,7,4,5]
        // System.out.println(Arrays.toString(
        // new Solution54().spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8,
        // 9 } }).toArray()));

        // 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        // 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
        System.out.println(Arrays.toString(
                new Solution54().spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, {
                        9, 10, 11, 12 } })
                        .toArray()));

        // 输入：matrix = [[3],[2]]
        // 输出：[3,2]
        System.out.println(Arrays.toString(
                new Solution54().spiralOrder(new int[][] { { 3 }, { 2 } }).toArray()));

        // 输入：matrix = [[7],[9],[6]]
        // 输出：[7,9,6]
        System.out.println(Arrays.toString(
                new Solution54().spiralOrder(new int[][] { { 7 }, { 9 }, { 6 }
                }).toArray()));

        // 输入：matrix = [[3,2]]
        // 输出：[3,2]
        // System.out.println(Arrays.toString(
        // new Solution54().spiralOrder(new int[][] { { 3, 2 } }).toArray()));

        // 输入：matrix = [[2,5],[8,4],[0,-1]]
        // 输出：
        // System.out.println(Arrays.toString(
        // new Solution54().spiralOrder(new int[][] { { 2, 5 }, { 8, 4 }, { 0, -1 }
        // }).toArray()));

        // 输入：matrix = [[2,3,4],[5,6,7],[8,9,10],[11,12,13]]
        // 输出：
        // System.out.println(Arrays.toString(
        // new Solution54().spiralOrder(new int[][] { { 2, 3, 4 }, { 5, 6, 7 }, { 8, 9,
        // 10 }, { 11, 12, 13 }
        // }).toArray()));
    }
}

class Solution54 {
    private int[][] dirs = new int[][] { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } }; // 顺时针: 下、左、上、右
    private List<Integer> result = new ArrayList<Integer>();

    public List<Integer> spiralOrder(int[][] matrix) {
        traversal(new int[] { 0, -1 }, 3, matrix, matrix.length, matrix[0].length);
        return result;
    }

    public void traversal(int[] point, int curDirInd, int[][] matrix, int M, int N) {
        int ind = 0;
        if (curDirInd == 0 || curDirInd == 2) {
            // 纵向走
            while (ind < M) {
                point[0] += dirs[curDirInd][0];
                point[1] += dirs[curDirInd][1];
                // System.out.println(point[0] + " " + point[1]);
                result.add(matrix[point[0]][point[1]]);
                ind++;
            }
            if (N != 1) {
                curDirInd = (curDirInd + 1) % 4;
                traversal(point, curDirInd, matrix, M, N - 1);
            }
        } else {
            // 横向走
            while (ind < N) {
                point[0] += dirs[curDirInd][0];
                point[1] += dirs[curDirInd][1];
                // System.out.println(point[0] + " " + point[1]);
                result.add(matrix[point[0]][point[1]]);
                ind++;
            }
            if (M != 1) {
                curDirInd = (curDirInd + 1) % 4;
                traversal(point, curDirInd, matrix, M - 1, N);
            }
        }
    }
}
