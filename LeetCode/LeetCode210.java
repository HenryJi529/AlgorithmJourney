import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode210 {
    public static void main(String[] args) {
        int numCourses;
        int[][] prerequisites;
        // 输入：numCourses = 2, prerequisites = [[1,0]]
        // 输出：[0,1]
        // 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
        numCourses = 2;
        prerequisites = new int[][] { { 1, 0 } };
        System.out.println(Arrays.deepToString(prerequisites));
        System.out.println(Arrays.toString(new Solution210().findOrder(numCourses, prerequisites)));
        System.out.println("================================================================");

        // 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
        // 输出：[0,2,1,3]
        numCourses = 4;
        prerequisites = new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        System.out.println(Arrays.deepToString(prerequisites));
        System.out.println(Arrays.toString(new Solution210().findOrder(numCourses, prerequisites)));
        System.out.println("================================================================");

        // 输入：numCourses = 1, prerequisites = []
        // 输出：[0]
        numCourses = 1;
        prerequisites = new int[][] {};
        System.out.println(Arrays.deepToString(prerequisites));
        System.out.println(Arrays.toString(new Solution210().findOrder(numCourses, prerequisites)));
        System.out.println("================================================================");
    }
}

class Solution210 {
    public ArrayList<ArrayList<Integer>> adjList;
    public boolean[] visited;// NOTE: 也可以设置visited范围为0,1,2，分别代表未访问/访问中/访问完成
    public boolean[] onStack;
    public int[] order; // NOTE: 这里是用数组和指针代替栈
    public int index; // NOTE: 用来记录顺序的索引
    boolean valid = true;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 构造有向图
        adjList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int end = prerequisites[i][0];
            int start = prerequisites[i][1];
            adjList.get(start).add(end);
        }

        visited = new boolean[numCourses];
        onStack = new boolean[numCourses];
        order = new int[numCourses];
        index = numCourses - 1;

        for (int u = 0; u < numCourses; u++) {
            if (!valid) {
                break;
            }
            if (visited[u] == false) {
                dfs(u);
            }
        }
        if (valid) {
            return order;
        } else {
            return new int[] {};
        }
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
        order[index--] = u;
    }
}
