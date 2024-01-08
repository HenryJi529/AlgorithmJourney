import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class LanQiao89 {
    static int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    static int N;
    static int[] lefts;
    static int[] tops;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 在此输入您的代码...
        N = scan.nextInt();
        lefts = new int[N];
        tops = new int[N];
        for (int i = 0; i < N; i++) {
            tops[i] = scan.nextInt();
        }
        for (int i = 0; i < N; i++) {
            lefts[i] = scan.nextInt();
        }
        scan.close();
        boolean[][] visited = new boolean[N][N];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(0, 0, path, visited);
        while (path.size() > 0) {
            System.out.print(path.pollLast() + " ");
        }
    }

    public static boolean dfs(int x, int y, Deque<Integer> path, boolean[][] visited) {
        visited[x][y] = true;
        path.push(x * N + y);
        lefts[x]--;
        tops[y]--;
        // System.out.println(
        // String.format("搜索至(%d, %d); lefts=%s, tops=%s, path=%s", x, y,
        // Arrays.toString(lefts),
        // Arrays.toString(tops), Arrays.toString(path.toArray())));

        if (isEnd()) {
            if (x == N - 1 && y == N - 1) {
                // System.out.println("搜到到目标路径【结束】...");
                return true;
            } else {
                // System.out.println("提前射光箭【回溯】...");
                lefts[x]++;
                tops[y]++;
                path.pop();
                visited[x][y] = false;
                return false;
            }
        } else {
            if (x == N - 1 && y == N - 1) {
                // System.out.println("已到终点，但还未射完箭【回溯】...");
                lefts[x]++;
                tops[y]++;
                path.pop();
                visited[x][y] = false;
                return false;
            }
        }

        for (int[] dir : dirs) {
            int x1 = x + dir[0];
            int y1 = y + dir[1];
            if (x1 < N && x1 >= 0 && y1 < N && y1 >= 0) {
                // 确保没有出界
                if (visited[x1][y1] == false) {
                    // 确保没有被访问过
                    if (lefts[x1] > 0 && tops[y1] > 0) {
                        // 确保不会向错的方向继续搜索
                        if (dfs(x1, y1, path, visited)) {
                            return true;
                        }
                    }
                }
            }
        }

        lefts[x]++;
        tops[y]++;
        path.pop();
        visited[x][y] = false;
        // System.out.println(String.format("遍历可行方向，未找到目标路径【回溯至(%d, %d)】", x, y));
        return false;
    }

    public static boolean isEnd() {
        boolean res = true;
        for (int i = 0; i < N; i++) {
            if (lefts[i] != 0 || tops[i] != 0) {
                return false;
            }
        }
        return res;
    }
}
