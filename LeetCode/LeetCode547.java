public class LeetCode547 {
    public static void main(String[] args) {
        int[][] isConnected;

        // 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
        // 输出：2
        isConnected = new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println(new Solution547().findCircleNum(isConnected));

        // 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
        // 输出：3
        isConnected = new int[][] { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
        System.out.println(new Solution547().findCircleNum(isConnected));

        // 输入：isConnected = [[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
        // 输出：1
        isConnected = new int[][] { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } };
        System.out.println(new Solution547().findCircleNum(isConnected));
    }
}

class Solution547 {
    int[] parents;
    int[] ranks;
    int count;

    public int findCircleNum(int[][] isConnected) {
        int nodeNum = isConnected.length;
        // 初始化
        count = nodeNum;
        parents = new int[nodeNum];
        ranks = new int[nodeNum];
        for (int i = 0; i < nodeNum; i++) {
            ranks[i] = 1;
            parents[i] = i;
        }
        // 并查
        for (int i = 0; i < nodeNum; i++) {
            for (int j = i + 1; j < nodeNum; j++) {
                if (isConnected[j][i] == 1) {
                    union(i, j);
                }
            }
        }
        return count;
    }

    private int find(int p) {
        while (parents[p] != p) {
            p = parents[p];
        }
        return p;
    }

    private void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (qRoot == pRoot) {
            return;
        }
        if (ranks[pRoot] < ranks[qRoot]) {
            parents[pRoot] = qRoot;
            ranks[qRoot] = ranks[pRoot] + 1 <= ranks[qRoot] ? ranks[qRoot] : ranks[pRoot] + 1;
        } else {
            parents[qRoot] = pRoot;
            ranks[pRoot] = ranks[qRoot] + 1 <= ranks[pRoot] ? ranks[pRoot] : ranks[qRoot] + 1;
        }
        count--;
        // System.out.println(String.format("合并%d和%d, count变为%d", p, q, count));
    }
}