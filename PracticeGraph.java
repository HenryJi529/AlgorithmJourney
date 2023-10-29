import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class PracticeGraph {
    public static void main(String[] args) {
        System.out.println("测试图的基本功能...");
        Graph.test();
        System.out.println("===============================================================");
        System.out.println("测试图的深度优先搜索...");
        DepthFirstSearch.test();
        System.out.println("===============================================================");
        System.out.println("测试图的广度优先搜索...");
        BreadthFirstSearch.test();
        System.out.println("===============================================================");
        System.out.println("测试图的广度优先搜索...");
        DepthFirstPaths.test();
        System.out.println("===============================================================");
    }
}

class Graph {
    private final int V;
    private int E;
    private Queue<Integer>[] adj;

    public static void test() {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        System.out.println(String.format("当前的图有%d个节点和%d条边", g1.V(), g1.E()));
    }

    @SuppressWarnings("unchecked")
    Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        this.E++;
    }

    public Queue<Integer> adj(int v) {
        return adj[v];
    }
}

class DepthFirstSearch {

    public static void test() {
        Graph g1 = new Graph(10);
        g1.addEdge(0, 2);
        g1.addEdge(0, 3);
        g1.addEdge(1, 2);
        g1.addEdge(8, 4);
        g1.addEdge(2, 9);

        DepthFirstSearch s = new DepthFirstSearch(g1, 0);
        System.out.println("节点5是否与节点0连通: " + s.marked(5));

    }

    private boolean[] marked;
    private int count;

    DepthFirstSearch(Graph G, int s) {
        this.marked = new boolean[G.V()];
        this.count = 0;
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        System.out.println("搜索到: " + v);
        for (int w : G.adj(v)) {
            if (marked(w)) {
                continue;
            } else {
                dfs(G, w);
            }
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
}

class BreadthFirstSearch {

    public static void test() {
        Graph g1 = new Graph(10);
        g1.addEdge(0, 2);
        g1.addEdge(0, 3);
        g1.addEdge(1, 2);
        g1.addEdge(8, 4);
        g1.addEdge(2, 9);

        BreadthFirstSearch s = new BreadthFirstSearch(g1, 0);
        System.out.println("节点5是否与节点0连通: " + s.marked(5));

    }

    private boolean[] marked;
    private int count;
    private Queue<Integer> waitSearch;

    BreadthFirstSearch(Graph g, int s) {
        this.marked = new boolean[g.V()];
        this.count = 0;
        this.waitSearch = new LinkedList<Integer>();

        bfs(g, s);
    }

    private void bfs(Graph g, int v) {
        waitSearch.add(v);
        while (true) {
            v = waitSearch.remove();
            marked[v] = true;
            count++;
            System.out.println("搜索到: " + v);
            for (int w : g.adj(v)) {
                if (marked(w)) {
                    continue;
                } else {
                    waitSearch.add(w);
                }
            }
            if (waitSearch.size() == 0) {
                break;
            }
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return this.count;
    }
}

class DepthFirstPaths {

    public static void test() {
        Graph g1 = new Graph(10);
        g1.addEdge(0, 2);
        g1.addEdge(0, 3);
        g1.addEdge(1, 2);
        g1.addEdge(8, 4);
        g1.addEdge(2, 9);

        DepthFirstPaths s = new DepthFirstPaths(g1, 0);
        System.out.println("从0到1的路径: ");
        Stack<Integer> path = s.pathTo(1);
        while (!path.isEmpty()) {
            System.out.print(path.pop());
        }
        System.out.println();
    }

    private boolean[] marked;
    // private int s;
    private int[] edgeTo;

    DepthFirstPaths(Graph g, int s) {
        this.marked = new boolean[g.V()];
        // this.s = s;
        this.edgeTo = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            if (i == s) {
                this.edgeTo[i] = i;
                continue;
            }
            this.edgeTo[i] = -1;
        }

        this.dfs(g, s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;

        for (int w : g.adj(v)) {
            if (marked[w] == true) {
                continue;
            } else {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }

    private boolean hasPathTo(int v) {
        return marked[v];
    }

    public Stack<Integer> pathTo(int v) {
        if (hasPathTo(v)) {
            Stack<Integer> path = new Stack<Integer>();
            while (true) {
                path.push(Integer.valueOf(v));
                if (edgeTo[v] == v) {
                    break;
                }
                v = edgeTo[v];
            }
            return path;
        } else {
            return null;
        }
    }

}