import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
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

class Solution743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<Item>[] graph = buildGraph(times, n);
        HashSet<Integer> set = new HashSet<Integer>();
        PriorityQueue<Item> dists = new PriorityQueue<Item>();
        int ans = Integer.MAX_VALUE;
        dists.offer(new Item(k, 0));
        while (dists.size() > 0) {
            if (set.size() == n) {
                // NOTE: 忽略不需要的
                return ans;
            }
            Item curItem = dists.poll();
            int curNode = curItem.v;
            int curCost = curItem.cost;
            if (set.contains(curNode)) {
                continue;
            } else {
                set.add(curNode);
                ans = curCost;
                for (Item neighbor : graph[curNode]) {
                    if (!set.contains(neighbor.v)) {
                        dists.offer(new Item(neighbor.v, curCost + neighbor.cost));
                    }
                }
            }
        }
        if (set.size() == n) {
            return ans;
        } else {
            return -1;
        }
    }

    class Item implements Comparable<Item> {
        int v;
        int cost;

        Item(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        public int compareTo(Item other) {
            if (this.cost > other.cost) {
                return 1;
            } else if (this.cost < other.cost) {
                return -1;
            } else {
                return 0;
            }
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
