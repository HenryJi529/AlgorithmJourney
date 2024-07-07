
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode2867 {
    public static void main(String[] args) {
        // 输入：n = 5, edges = [[1,2],[1,3],[2,4],[2,5]]
        // 输出：4
        System.out.println(new Solution2867_2().countPaths(5, new int[][] { { 1, 2 },
                {
                        1, 3 },
                { 2, 4 }, { 2, 5 } }));

        // 输入：n = 6, edges = [[1,2],[1,3],[2,4],[3,5],[3,6]]
        // 输出：6
        System.out.println(
                new Solution2867_2().countPaths(6, new int[][] { { 1, 2 }, { 1, 3 }, { 2, 4
                },
                        { 3, 5 }, { 3, 6 } }));

        // 输入: n = 1, edges = []
        // 输出: 0
        System.out.println(
                new Solution2867_2().countPaths(1, new int[][] {}));

        // 输入: n = 4, edges = [[1,2],[4,1],[3,4]]
        // 输出: 4
        System.out.println(
                new Solution2867_2().countPaths(4, new int[][] { { 1, 2 }, { 4, 1 }, { 3, 4 }
                }));

        // 输入: n = 5, edges = [[1,3],[4,3],[2,3],[5,2]]
        // 输出: 3
        System.out.println(
                new Solution2867_2().countPaths(5, new int[][] { { 1, 3 }, { 4, 3 }, { 2, 3
                },
                        { 5, 2 } }));

        // 输入: n = 5, edges = [[4,1],[5,4],[2,1],[3,4]]
        // 输出: 6
        System.out.println(
                new Solution2867_2().countPaths(5, new int[][] { { 4, 1 }, { 5, 4 }, { 2, 1
                },
                        { 3, 4 } }));
    }
}

/**
 * 以合数为中心，搜素所有质数数量为0的路径
 * 由于是树结构，因此不会存在环，所以求路径树就是求节点数
 */
class Solution2867_1 {
    public long countPaths(int n, int[][] edges) {
        boolean[] isPrimes = loadAllPrimes(n);
        ArrayList<Integer>[] tree = buildTree(n, edges);
        // System.out.println(Arrays.toString(isPrimes));
        long result = 0;
        Integer[] dp = new Integer[n + 1];
        HashSet<Integer> visited;
        for (int ind = 1; ind <= n; ind++) {
            if (isPrimes[ind]) {
                List<Integer> neighborCounts = new ArrayList<>();
                for (int neighbor : tree[ind]) {
                    if (!isPrimes[neighbor]) {
                        if (dp[neighbor] == null) {
                            visited = new HashSet<Integer>();
                            dfs(neighbor, tree, isPrimes, visited);
                            dp[neighbor] = visited.size();
                            for (int k : tree[neighbor]) {
                                if (!isPrimes[k]) {
                                    dp[k] = dp[neighbor];
                                }
                            }
                        }
                        neighborCounts.add(dp[neighbor]);
                    }
                }
                int sum = 0;
                for (int i = 0; i < neighborCounts.size(); i++) {
                    result += neighborCounts.get(i);
                    sum += neighborCounts.get(i);
                }
                long temp = 0;
                for (int i = 0; i < neighborCounts.size(); i++) {
                    temp += (long) neighborCounts.get(i) * (sum - neighborCounts.get(i));
                }
                result += temp / 2;
            }
        }
        // System.out.println(Arrays.toString(dp));
        return result;
    }

    public void dfs(int ind, ArrayList<Integer>[] tree, boolean[] isPrimes, HashSet<Integer> visited) {
        visited.add(ind);
        for (int neighbor : tree[ind]) {
            if (isPrimes[neighbor] || visited.contains(neighbor)) {
                continue;
            }
            dfs(neighbor, tree, isPrimes, visited);
        }
    }

    private ArrayList<Integer>[] buildTree(int n, int[][] edges) {
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            tree[edges[i][0]].add(edges[i][1]);
            tree[edges[i][1]].add(edges[i][0]);
        }
        return tree;
    }

    private boolean[] loadAllPrimes(int n) {
        boolean[] isPrimes = new boolean[n + 1];
        Arrays.fill(isPrimes, true);
        isPrimes[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrimes[i]) {
                for (int j = 2; i * j <= n; j++) {
                    isPrimes[j * i] = false;
                }
            }
        }
        return isPrimes;
    }
}

/**
 * 解法1中存在一个用合数值设置周围合数值的步骤，可以想到用并查集来代替
 */
class Solution2867_2 {
    class DisjointSet {
        private int count;
        private int[] parent;
        private int[] rank;
        private int[] family;

        DisjointSet(int N, boolean[] isPrimes) {
            this.count = N;
            this.parent = new int[N + 1];
            this.rank = new int[N + 1];
            this.family = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                this.parent[i] = i;
                this.rank[i] = 1;
                this.family[i] = isPrimes[i] ? 0 : 1;
            }
        }

        int count() {
            return this.count;
        }

        int find(int p) {
            while (parent[p] != p) {
                p = parent[p];
            }
            return p;
        }

        boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        int getFamily(int p) {
            // NOTE: 这里还可以考虑提前同步root的值到所有成员，这就要考虑到分布情况了
            int root = find(p);
            return family[root];
        }

        void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);

            if (qRoot == pRoot) {
                return;
            }
            if (rank[pRoot] < rank[qRoot]) {
                parent[pRoot] = qRoot;
                rank[qRoot] = rank[pRoot] + 1 <= rank[qRoot] ? rank[qRoot] : rank[pRoot] + 1;
                family[qRoot] += family[pRoot];
            } else {
                parent[qRoot] = pRoot;
                rank[pRoot] = rank[qRoot] + 1 <= rank[pRoot] ? rank[pRoot] : rank[qRoot] + 1;
                family[pRoot] += family[qRoot];
            }
            this.count--;
        }

    }

    public long countPaths(int n, int[][] edges) {
        boolean[] isPrimes = loadAllPrimes(n);
        ArrayList<Integer>[] tree = buildTree(n, edges);
        DisjointSet uf = new DisjointSet(n, isPrimes);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (!isPrimes[u] && !isPrimes[v]) {
                uf.union(u, v);
            }
        }
        long result = 0;
        for (int ind = 1; ind <= n; ind++) {
            if (isPrimes[ind]) {
                List<Integer> neighborCounts = new ArrayList<>();
                for (int neighbor : tree[ind]) {
                    if (!isPrimes[neighbor]) {
                        neighborCounts.add(uf.getFamily(neighbor));
                    }
                }
                int sum = 0;
                for (int i = 0; i < neighborCounts.size(); i++) {
                    result += neighborCounts.get(i);
                    sum += neighborCounts.get(i);
                }
                long temp = 0;
                for (int i = 0; i < neighborCounts.size(); i++) {
                    temp += (long) neighborCounts.get(i) * (sum - neighborCounts.get(i));
                }
                result += temp / 2;
            }
        }
        return result;
    }

    private ArrayList<Integer>[] buildTree(int n, int[][] edges) {
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            tree[edges[i][0]].add(edges[i][1]);
            tree[edges[i][1]].add(edges[i][0]);
        }
        return tree;
    }

    private boolean[] loadAllPrimes(int n) {
        boolean[] isPrimes = new boolean[n + 1];
        Arrays.fill(isPrimes, true);
        isPrimes[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrimes[i]) {
                for (int j = 2; i * j <= n; j++) {
                    isPrimes[j * i] = false;
                }
            }
        }
        return isPrimes;
    }
}