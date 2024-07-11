import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetCode743 {
    public static void main(String[] args) {
        // 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
        // 输出：2
        System.out.println(
                new Solution743().networkDelayTime(new int[][] { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } }, 4, 2));

        // 输入：times = [[1,2,1]], n = 2, k = 1
        // 输出：1
        System.out.println(
                new Solution743().networkDelayTime(new int[][] { { 1, 2, 1 } }, 2, 1));

        // 输入：times = [[1,2,1]], n = 2, k = 2
        // 输出：-1
        System.out.println(
                new Solution743().networkDelayTime(new int[][] { { 1, 2, 1 } }, 2, 2));
    }
}

/**
 * 找寻从起点到其他所有点最短路径的最大值
 */
class Solution743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<Item>[] graph = buildGraph(times, n);
        boolean[] visited = new boolean[n + 1];
        int countVisted = 0;
        int[] dists = new int[n + 1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        PriorityQueue<Item> pq = new PriorityQueue<Item>();

        int ans = 0;
        pq.offer(new Item(k, 0));
        while (pq.size() > 0) {
            if (countVisted == n) {
                return ans;
            }
            Item curItem = pq.poll();
            if (visited[curItem.v]) {
                continue;
            }
            visited[curItem.v] = true;
            countVisted++;
            ans = curItem.cost;
            for (Item neighborItem : graph[curItem.v]) {
                if (!visited[neighborItem.v]) {
                    // NOTE: 这里会重复添加许多条不同上一跳的路径，需要通过dists排除
                    if (curItem.cost + neighborItem.cost < dists[neighborItem.v]) {
                        pq.offer(new Item(neighborItem.v, curItem.cost + neighborItem.cost));
                        dists[neighborItem.v] = curItem.cost + neighborItem.cost;
                    }
                }
            }

        }
        return countVisted == n ? ans : -1;
    }

    class Item implements Comparable<Item> {
        int v;
        int cost;

        Item(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        public int compareTo(Item that) {
            return this.cost - that.cost;
        }

        public String toString() {
            return String.format("(v=%d, cost=%d)", this.v, this.cost);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Item>[] buildGraph(int[][] times, int n) {
        List<Item>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Item>();
        }
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int cost = times[i][2];
            graph[u].add(new Item(v, cost));
        }
        return graph;
    }
}
