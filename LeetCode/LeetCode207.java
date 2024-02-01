import java.util.ArrayList;

public class LeetCode207 {
    public static void main(String[] args) {
        int numCourses;
        int[][] prerequisites;
        // 输入：numCourses = 2, prerequisites = [[1,0]]
        // 输出：true
        // 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
        numCourses = 2;
        prerequisites = new int[][] { { 1, 0 } };
        System.out.println(new Solution207().canFinish(numCourses, prerequisites));

        // 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
        // 输出：false
        // 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
        numCourses = 2;
        prerequisites = new int[][] { { 1, 0 }, { 0, 1 } };
        System.out.println(new Solution207().canFinish(numCourses, prerequisites));
    }
}

class Solution207 {
    public ArrayList<ArrayList<Integer>> adjList;
    public boolean[] visited;
    public boolean[] onStack;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 先构建有向图
        adjList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        visited = new boolean[numCourses];
        onStack = new boolean[numCourses];

        for (int u = 0; u < numCourses; u++) {
            if (!valid) {
                break;
            }
            if (visited[u] == false) {
                dfs(u);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        visited[u] = true;
        onStack[u] = true;
        for (int v : adjList.get(u)) {
            if (visited[v] == false) {
                dfs(v);
            }
            if (onStack[v] == true) {
                valid = false;
                break;
            }
        }
        onStack[u] = false;
    }
}