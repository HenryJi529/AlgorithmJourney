import java.util.Scanner;

public class PracticeDisjointSet {
    public static void main(String[] args) {
        // 创建并查集附象
        DisjointSet uf = new DisjointSet(5);
        System.out.println("默认情况下，并查集中有：" + uf.count() + "个分组");

        // 从控制台录人两个要合并的元素，调用union方法合并，观察合并后并查集中的分组是否威少
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请输入第一个要合并的元素：");
            int p = sc.nextInt();
            System.out.println("请输入第二个要合并的元素：");
            int q = sc.nextInt();

            if (q >= 5 || p >= 5) {
                sc.close();
                break;
            }

            // 判断这两个元素是否已经在同一组了

            if (uf.connected(p, q)) {
                System.out.println(p + "元素和" + p + "元素已经在同一个组中了");
                continue;
            } else {
                uf.union(p, q);
                System.out.println("当前并查集中还有：" + uf.count() + "个分组");
            }
        }

    }

}

class DisjointSet {
    private int count;
    private int[] parent;
    private int[] rank;

    DisjointSet(int N) {
        this.count = N;
        this.parent = new int[N];
        this.rank = new int[N];

        for (int i = 0; i < N; i++) {
            this.parent[i] = i;
            this.rank[i] = 1;
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

    void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (qRoot == pRoot) {
            return;
        }

        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
            rank[qRoot] = rank[pRoot] + 1 <= rank[qRoot] ? rank[qRoot] : rank[pRoot] + 1;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] = rank[qRoot] + 1 <= rank[pRoot] ? rank[pRoot] : rank[qRoot] + 1;
        }
        this.count--;
    }
}
