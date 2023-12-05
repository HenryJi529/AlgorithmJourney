public class LeetCode1971 {
    public static void main(String[] args) {
        int n;
        int source;
        int destination;
        int[][] edges;
        // 输入：n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
        // 输出：true
        n = 3;
        edges = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 } };
        source = 0;
        destination = 2;
        System.out.println(new Solution1971().validPath(n, edges, source, destination));

        // 输入：n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination=5
        // 输出：false
        n = 6;
        edges = new int[][] { { 0, 1 }, { 0, 2 }, { 3, 5 }, { 5, 4 }, { 4, 3 } };
        source = 0;
        destination = 5;
        System.out.println(new Solution1971().validPath(n, edges, source, destination));
    }
}

class Solution1971 {
    int[] parent;
    int[] rank;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] info : edges) {
            int p = info[0];
            int q = info[1];
            union(p, q);
        }

        return find(source) == find(destination);
    }

    private int find(int p) {
        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }

    private void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        if (rank[pRoot] >= rank[qRoot]) {
            parent[qRoot] = pRoot;
            if (rank[pRoot] == rank[qRoot]) {
                rank[pRoot] = rank[pRoot] + 1;
            }
        } else {
            parent[pRoot] = qRoot;
        }
    }
}
