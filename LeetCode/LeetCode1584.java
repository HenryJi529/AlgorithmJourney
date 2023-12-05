import java.util.PriorityQueue;

public class LeetCode1584 {
    public static void main(String[] args) {
        // 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
        // 输出：20
        System.out.println(new Solution1584()
                .minCostConnectPoints(new int[][] { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } }));

        // 输入：points = [[3,12],[-2,5],[-4,1]]
        // 输出：18
        System.out.println(new Solution1584()
                .minCostConnectPoints(new int[][] { { 3, 12 }, { -2, 5 }, { -4, 1 } }));

        // 输入：points = [[0,0],[1,1],[1,0],[-1,1]]
        // 输出：4
        System.out.println(new Solution1584()
                .minCostConnectPoints(new int[][] { { 0, 0 }, { 1, 1 }, { 1, 0 }, { -1, 1 } }));

        // 输入：points = [[0,0]]
        // 输出：0
        System.out.println(new Solution1584()
                .minCostConnectPoints(new int[][] { { 0, 0 } }));
    }
}

class Solution1584 {
    private class Edge implements Comparable<Edge> {
        int v;
        int w;
        int cost;

        private Edge(int v, int w, int cost) {
            this.v = v;
            this.w = w;
            this.cost = cost;
        }

        public int compareTo(Edge other) {
            if (this.cost > other.cost) {
                return 1;
            } else if (this.cost < other.cost) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    private int getCost(int[] p, int[] q) {
        return Math.abs(p[0] - q[0]) + Math.abs(p[1] - q[1]);
    }

    private class UnionFind {
        int[] parents;
        int[] ranks;
        int count;

        private UnionFind(int size) {
            this.parents = new int[size];
            this.ranks = new int[size];
            this.count = size;
            for (int i = 0; i < size; i++) {
                this.parents[i] = i;
                this.ranks[i] = 1;
            }
        }

        public int count() {
            return count;
        }

        private int find(int v) {
            while (this.parents[v] != v) {
                v = this.parents[v];
            }
            return v;
        }

        private boolean connected(int v, int w) {
            return find(v) == find(w);
        }

        private void union(int v, int w) {
            int vRoot = find(v);
            int wRoot = find(w);
            if (vRoot == wRoot) {
                return;
            } else {
                if (ranks[vRoot] > ranks[wRoot]) {
                    parents[wRoot] = vRoot;
                } else if (ranks[vRoot] < ranks[wRoot]) {
                    parents[vRoot] = wRoot;
                } else {
                    parents[wRoot] = vRoot;
                    ranks[vRoot]++;
                }
                count--;
            }

        }
    }

    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Edge> edges = new PriorityQueue<Edge>();
        UnionFind uf = new UnionFind(points.length);
        int sum = 0;

        // 初始化边
        for (int v = 0; v < points.length; v++) {
            for (int w = v + 1; w < points.length; w++) {
                edges.add(new Edge(v, w, getCost(points[v], points[w])));
            }
        }

        while (uf.count() > 1) {
            Edge edge = edges.poll();
            int v = edge.v;
            int w = edge.w;
            if (!uf.connected(v, w)) {
                uf.union(v, w);
                sum += edge.cost;
            }
        }

        return sum;
    }

}