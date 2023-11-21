/*
 * 问题描述: https://leetcode.cn/problems/course-schedule/
 * 解题思路: 问题转化为有向环检测
 */

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
    public int[] visited;
    public int[] onStack;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adjList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int end = prerequisites[i][0];
            int start = prerequisites[i][1];
            adjList.get(start).add(end);
        }
        visited = new int[numCourses];
        onStack = new int[numCourses];

        for (int u = 0; u < numCourses; u++) {
            if (!valid) {
                break;
            }
            if (visited[u] == 0) {
                dfs(u);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        visited[u] = 1;
        onStack[u] = 1;
        for (int v : adjList.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
            }
            if (onStack[v] == 1) {
                valid = false;
                break;
            }
        }
        onStack[u] = 0;
    }
}