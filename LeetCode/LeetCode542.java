import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class LeetCode542 {
    public static void main(String[] args) {
        // 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
        // 输出：[[0,0,0],[0,1,0],[0,0,0]]
        System.out.println(
                Arrays.deepToString(
                        new Solution542().updateMatrix(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } })));

        // 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
        // 输出：[[0,0,0],[0,1,0],[1,2,1]]
        System.out.println(
                Arrays.deepToString(
                        new Solution542().updateMatrix(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } })));

        // 输入：mat = [[0],[1]]
        // 输出：[[0],[1]]
        System.out.println(
                Arrays.deepToString(
                        new Solution542().updateMatrix(new int[][] { { 0 }, { 1 } })));
    }
}

class Solution542 {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        Queue<int[]> queue = new LinkedList<int[]>();
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }
        int cost = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] cur = queue.poll();
                res[cur[0]][cur[1]] = cost;
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                        queue.offer(new int[] { x, y });
                        visited[x][y] = true;
                    }
                }
            }
            cost++;
        }
        return res;
    }
}