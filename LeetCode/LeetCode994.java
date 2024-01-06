import java.util.Deque;
import java.util.LinkedList;

public class LeetCode994 {
    public static void main(String[] args) {
        // 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
        // 输出：4
        System.out.println(new Solution994().orangesRotting(new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }));

        // 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
        // 输出：-1
        System.out.println(new Solution994().orangesRotting(new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } }));

        // 输入：grid = [[0,2]]
        // 输出：0
        System.out.println(new Solution994().orangesRotting(new int[][] { { 0, 2 } }));

        // 输入：grid = [[0]]
        // 输出：0
        System.out.println(new Solution994().orangesRotting(new int[][] { { 0 } }));
    }
}

class Solution994 {
    int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshNum = 0;
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshNum++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }
        int minutes = 0;
        while (!queue.isEmpty()) {
            if (freshNum == 0) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < m && x >= 0 && y < n && y >= 0) {
                        if (visited[x][y] == false && grid[x][y] == 1) {
                            freshNum--;
                            queue.add(new int[] { x, y });
                            visited[x][y] = true;
                        }
                    }
                }
            }
            minutes++;
        }
        return freshNum == 0 ? minutes : -1;
    }
}