import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashMap;

public class LeetCode787 {
    public static void main(String[] args) {
        // 输入:
        // n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
        // src = 0, dst = 2, k = 1
        // 输出: 200
        System.out.println(new Solution787().findCheapestPrice(3,
                new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } }, 0, 2, 1));

        // 输入:
        // n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
        // src = 0, dst = 2, k = 0
        // 输出: 500
        System.out.println(new Solution787().findCheapestPrice(3,
                new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } }, 0, 2, 0));

        // 输入:
        // n = 4, edges = [[0,1,1],[0,2,5],[1,2,1],[2,3,1]]
        // src = 0, dst = 3, k = 1
        // 输出: 6
        System.out.println(new Solution787().findCheapestPrice(4,
                new int[][] { { 0, 1, 1 }, { 0, 2, 5 }, { 1, 2, 1 }, { 2, 3, 1 } }, 0, 3, 1));
    }
}

/**
 * Dijkstra变体，寻找最小的cost，并通过记录到点v的可行方案进行剪枝
 */
class Solution787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = buildGraph(flights, n);
        PriorityQueue<FullItem> pq = new PriorityQueue<FullItem>();
        HashMap<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();// 存放到达v的(cost, hop)记录
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<int[]>());
        }
        for (int[] item : graph[src]) {
            pq.add(new FullItem(item[0], item[1], 0));
        }
        while (pq.size() > 0) {
            // System.out.println(Arrays.toString(pq.toArray()));
            FullItem cur = pq.poll();
            if (cur.v == dst) {
                return cur.cost;
            }
            if (cur.hop <= k - 1) {
                List<int[]> records = map.get(cur.v);
                boolean ignore = false;
                for (int[] record : records) {
                    if (record[0] <= cur.cost && record[1] <= cur.hop) {
                        // 如果存在开销和跳数都优于当前方案的，忽略当前方案
                        ignore = true;
                        break;
                    }
                }
                if (ignore) {
                    continue;
                }
                records.add(new int[] { cur.cost, cur.hop });

                for (int[] nextItem : graph[cur.v]) {
                    if (cur.hop + 1 > k || (nextItem[0] != dst && cur.hop + 1 == k)) {
                        continue;
                    }
                    pq.offer(new FullItem(nextItem[0], cur.cost + nextItem[1], cur.hop + 1));
                }
            }
        }
        return -1;
    }

    class FullItem implements Comparable<FullItem> {
        int v;
        int cost; // 存放累计代价
        int hop;

        FullItem(int v, int cost, int hop) {
            this.v = v;
            this.cost = cost;
            this.hop = hop;
        }

        public String toString() {
            return String.format("(v=%d, cost=%d, hop=%d)", this.v, this.cost, this.hop);
        }

        public int compareTo(FullItem other) {
            return this.cost - other.cost;
        }

    }

    @SuppressWarnings("unchecked")
    public List<int[]>[] buildGraph(int[][] flights, int n) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<int[]>();
        }
        for (int i = 0; i < flights.length; i++) {
            int start = flights[i][0];
            int to = flights[i][1];
            int cost = flights[i][2];
            graph[start].add(new int[] { to, cost });
        }
        return graph;
    }
}
