import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class LeetCode1030 {
    public static void main(String[] args) {
        // 输入：rows = 1, cols = 2, rCenter = 0, cCenter = 0
        // 输出：[[0,0],[0,1]]
        System.out.println(
                Arrays.deepToString(new Solution1030().allCellsDistOrder(1, 2, 0, 0)));

        // 输入：rows = 2, cols = 2, rCenter = 0, cCenter = 1
        // 输出：[[0,1],[0,0],[1,1],[1,0]]
        System.out.println(
                Arrays.deepToString(new Solution1030().allCellsDistOrder(2, 2, 0, 1)));

        // 输入：rows = 2, cols = 3, rCenter = 1, cCenter = 2
        // 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
        System.out.println(
                Arrays.deepToString(new Solution1030().allCellsDistOrder(2, 3, 1, 2)));
    }
}

class Solution1030 {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] result = new int[rows * cols][2];
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] { rCenter, cCenter });
        visited[rCenter][cCenter] = true;
        int index = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            // System.out.println("x: " + current[0] + " y: " + current[1]);
            result[index][0] = current[0];
            result[index][1] = current[1];
            index++;
            for (int[] dir : dirs) {
                int x = current[0] + dir[0];
                int y = current[1] + dir[1];
                if (x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y]) {
                    queue.add(new int[] { x, y });
                    visited[x][y] = true;
                }
            }
        }
        return result;
    }
}