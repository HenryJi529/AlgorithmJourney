
public class LeetCode79 {
    public static void main(String[] args) {
        // 输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word =
        // 'ABCCED'
        // 输出：true
        System.out.println(new Solution79().exist(
                new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCCED"));

        // 输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word =
        // 'SEE'
        // 输出：true
        System.out.println(new Solution79().exist(
                new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "SEE"));

        // 输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word =
        // 'ABCB'
        // 输出：false
        System.out.println(new Solution79().exist(
                new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCB"));

        // 输入：board = [['a']], word = "a"
        // 输出：true
        System.out.println(new Solution79().exist(
                new char[][] { { 'a' } }, "a"));
    }
}

class Solution79 {
    private int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != word.charAt(0)) {
                    continue;
                }
                if (dfs(board, visited, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean dfs(char[][] board, boolean[][] visited, String word, int ind, int i, int j) {
        if (ind + 1 == word.length()) {
            return true;
        }
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y]
                    || board[x][y] != word.charAt(ind + 1)) {
                continue;
            }
            if (dfs(board, visited, word, ind + 1, x, y)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}