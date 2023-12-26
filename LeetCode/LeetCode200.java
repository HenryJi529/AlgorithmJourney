import java.util.Arrays;
import java.util.HashSet;

public class LeetCode200 {
    public static void main(String[] args) {
        // 输入：grid = [
        // ['1','1','1','1','0'],
        // ['1','1','0','1','0'],
        // ['1','1','0','0','0'],
        // ['0','0','0','0','0']
        // ]
        // 输出：1
        System.out.println(new Solution200_1().numIslands(new char[][] {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        }));

        // 输入：grid = [
        // ['1','1','0','0','0'],
        // ['1','1','0','0','0'],
        // ['0','0','1','0','0'],
        // ['0','0','0','1','1']
        // ]
        // 输出：3
        System.out.println(new Solution200_1().numIslands(new char[][] {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        }));
    }
}

class Solution200_1 {
    boolean[][] visited;
    int num = 0;
    char[][] grid;
    int m;
    int n;
    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int numIslands(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j);
                    num++;
                }
            }
        }
        return this.num;
    }

    public void dfs(int x, int y) {
        visited[x][y] = true;
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                // System.out.println(newNode[0] + " " + newNode[1]);
                if (grid[newX][newY] == '1' && !visited[newX][newY]) {
                    dfs(newX, newY);
                }
            }
        }
    }
}

class Solution200_2 {
    // NOTE: 构建一个用内容计算hashcode的HashSet，但没啥用
    HashSet<IntArrayWrapper> visited = new HashSet<>();
    int num = 0;
    char[][] grid;
    int m;
    int n;
    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    class IntArrayWrapper {
        private final int[] array;

        public IntArrayWrapper(int[] array) {
            this.array = array;
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(array);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            IntArrayWrapper other = (IntArrayWrapper) obj;
            return Arrays.equals(array, other.array);
        }
    }

    public int numIslands(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited.contains(new IntArrayWrapper(new int[] { i, j }))) {
                    dfs(new int[] { i, j });
                    num++;
                }
            }
        }
        return this.num;
    }

    public void dfs(int[] node) {
        visited.add(new IntArrayWrapper(node));
        for (int[] dir : dirs) {
            int[] newNode = new int[] { node[0] + dir[0], node[1] + dir[1] };
            if (newNode[0] >= 0 && newNode[0] < m && newNode[1] >= 0 && newNode[1] < n) {
                // System.out.println(newNode[0] + " " + newNode[1]);
                if (grid[newNode[0]][newNode[1]] == '1' && !visited.contains(new IntArrayWrapper(newNode))) {
                    dfs(newNode);
                }
            }
        }
    }
}

class LeetCode200_3 {
    // NOTE: 也可以直接把访问过的节点变成'0': grid[i][j] = '0'
}