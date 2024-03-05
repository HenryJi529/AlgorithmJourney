import java.util.Arrays;

public class LeetCode1337 {
    public static void main(String[] args) {
        // 输入：mat =
        // [[1,1,0,0,0],
        // [1,1,1,1,0],
        // [1,0,0,0,0],
        // [1,1,0,0,0],
        // [1,1,1,1,1]],
        // k = 3
        // 输出：[2,0,3]
        System.out.println(Arrays.toString(new Solution1337().kWeakestRows(
                new int[][] {
                        { 1, 1, 0, 0, 0 },
                        { 1, 1, 1, 1, 0 },
                        { 1, 0, 0, 0, 0 },
                        { 1, 1, 0, 0, 0 },
                        { 1, 1, 1, 1, 1 }
                },
                3)));

        // 输入：mat =
        // [[1,0,0,0],
        // [1,1,1,1],
        // [1,0,0,0],
        // [1,0,0,0]],
        // k = 2
        // 输出：[0,2]
        System.out.println(Arrays.toString(new Solution1337().kWeakestRows(
                new int[][] {
                        { 1, 0, 0, 0 },
                        { 1, 1, 1, 1 },
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 0 }
                },
                2)));

        // 输入：mat = [[1,1,1,1,1,1],[1,1,1,1,1,1],[1,1,1,1,1,1]], k = 1;
        // 输出：[0]
        System.out.println(Arrays.toString(new Solution1337().kWeakestRows(
                new int[][] {
                        { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 }
                },
                1)));

        // 输入：mat = [[1,0],[1,0],[1,0],[1,1]], k = 4;
        // 输出：[0, 1, 2, 3]
        System.out.println(Arrays.toString(new Solution1337().kWeakestRows(
                new int[][] {
                        { 1, 0 }, { 1, 0 }, { 1, 0 }, { 1, 1 }
                },
                4)));

        // 输入：mat = [[1,0],[0,0],[1,0]], k = 2;
        // 输出：[1, 0]
        System.out.println(Arrays.toString(new Solution1337().kWeakestRows(
                new int[][] {
                        { 1, 0 }, { 0, 0 }, { 1, 0 }
                },
                2)));

        // 输入：mat = [[1,1,0],[1,0,0],[1,0,0],[1,1,1],[1,1,0],[0,0,0]], k = 4;
        // 输出：[5,1,2,0]
        System.out.println(Arrays.toString(new Solution1337().kWeakestRows(
                new int[][] {
                        { 1, 1, 0 }, { 1, 0, 0 }, { 1, 0, 0 }, { 1, 1, 1 }, { 1, 1, 0 }, { 0, 0, 0 }
                },
                4)));

    }
}

class Solution1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        boolean[] visited = new boolean[mat.length];
        int[] result = new int[k];
        int col = 0;
        while (k > 0) {
            for (int row = 0; row < mat.length; row++) {
                if (visited[row]) {
                    continue;
                }
                if (mat[row][col] == 0) {
                    result[result.length - k] = row;
                    visited[row] = true;
                    k--;
                    if (k == 0) {
                        break;
                    }
                }
            }
            col++;
            if (col == mat[0].length) {
                break;
            }
        }
        if (k != 0) {
            for (int row = 0; row < mat.length; row++) {
                if (visited[row]) {
                    continue;
                } else {
                    result[result.length - k] = row;
                    visited[row] = true;
                    k--;
                    if (k == 0) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}