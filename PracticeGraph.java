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
        System.out.println("测试有向图...");
        Digraph.test();
        System.out.println("===============================================================");
        System.out.println("测试有向图环检测...");
        DirectedCycle.test();
        System.out.println("===============================================================");
        System.out.println("测试拓扑排序...");
        TopoLogicalOrder.test();
        System.out.println("===============================================================");
        System.out.println("测试加权无向图...");
        WeightedGraph.test();
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

class Digraph {
    public static void test() {
        Digraph g = new Digraph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 3);
        g.addEdge(1, 0);
        g.addEdge(4, 0);
        System.out.println("图中，从0开始的边为: " + g.adj(0));
        System.out.println("图中，从0结束的边为: " + g.reverse().adj(0));
    }

    private final int V;
    private int E;
    private Queue<Integer>[] adj;

    @SuppressWarnings("unchecked")
    Digraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new Queue[V];
        for (int i = 0; i < V; i++) {
            this.adj[i] = new LinkedList<Integer>();
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
    }

    public Queue<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph g_reverse = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj[v]) {
                g_reverse.adj[w].add(v);
            }
        }
        return g_reverse;
    }
}

class DirectedCycle {

    public static void test() {
        Digraph g = new Digraph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(4, 0);
        DirectedCycle cycle = new DirectedCycle(g);
        System.out.println("图中是否存在环: " + cycle.hasCycle);
    }

    private boolean[] marked;
    private boolean hasCycle;
    private boolean[] onStack;

    public DirectedCycle(Digraph g) {
        this.marked = new boolean[g.V()];
        this.onStack = new boolean[g.V()];
        this.hasCycle = false;

        for (int v = 0; v < g.V(); v++) {
            if (marked[v]) {
                continue;
            }
            dfs(g, v);
        }
    }

    private void dfs(Digraph g, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }

            if (onStack[w]) {
                hasCycle = true;
                break;
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}

/* 顶点排序 */
class DepthFirstOrder {
    private boolean[] marked;
    private Stack<Integer> reversePost;

    DepthFirstOrder(Digraph g) {
        this.marked = new boolean[g.V()];
        this.reversePost = new Stack<Integer>();

        for (int i = 0; i < g.V(); i++) {
            if (marked[i]) {
                continue;
            }
            dfs(g, i);
        }
    }

    private void dfs(Digraph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (marked[w]) {
                continue;
            }
            dfs(g, w);
        }
        reversePost.push(v);
    }

    public Stack<Integer> reversePost() {
        return reversePost;
    }
}

class TopoLogicalOrder {

    public static void test() {
        Digraph g = new Digraph(6);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(1, 3);
        TopoLogicalOrder order = new TopoLogicalOrder(g);
        System.out.println(order.order());
    }

    private Stack<Integer> order;

    TopoLogicalOrder(Digraph g) {
        DirectedCycle cycle = new DirectedCycle(g);
        if (!cycle.hasCycle()) {
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(g);
            order = depthFirstOrder.reversePost();
        }
    }

    public boolean isCycle() {
        return order == null;
    }

    public Stack<Integer> order() {
        return order;
    }
}

class Edge implements Comparable<Edge> {
    private final int v;
    private final int w;
    private final double weight;

    Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int either() {
        return v;
    }

    public int other(int vertex) {
        if (vertex == v) {
            return w;
        } else {
            return v;
        }

    }

    @Override
    public int compareTo(Edge that) {
        int cmp;
        if (this.weight > that.weight) {
            cmp = 1;
        } else if (this.weight < that.weight) {
            cmp = -1;
        } else {
            cmp = 0;
        }
        return cmp;
    }

    public String toString() {
        return String.format("(v=%d, w=%d, weight=%.2f)", v, w, weight);
    }

}

class WeightedGraph {

    public static void test() {
        WeightedGraph g1 = new WeightedGraph(5);
        g1.addEdge(new Edge(0, 1, 0.5));
        g1.addEdge(new Edge(0, 2, 2));
        g1.addEdge(new Edge(2, 4, 1));

        System.out.println("所有的边为: " + g1.edges());
    }

    public static WeightedGraph get_test_graph() {
        WeightedGraph g1 = new WeightedGraph(8);
        g1.addEdge(new Edge(4, 5, 0.35));
        g1.addEdge(new Edge(4, 7, 0.37));
        g1.addEdge(new Edge(5, 7, 0.28));
        g1.addEdge(new Edge(0, 7, 0.16));
        g1.addEdge(new Edge(1, 5, 0.32));
        g1.addEdge(new Edge(0, 4, 0.38));
        g1.addEdge(new Edge(2, 3, 0.17));
        g1.addEdge(new Edge(1, 7, 0.19));
        g1.addEdge(new Edge(0, 2, 0.26));
        g1.addEdge(new Edge(1, 2, 0.36));
        g1.addEdge(new Edge(1, 3, 0.29));
        g1.addEdge(new Edge(2, 7, 0.34));
        g1.addEdge(new Edge(6, 2, 0.40));
        g1.addEdge(new Edge(3, 6, 0.52));
        g1.addEdge(new Edge(6, 0, 0.58));
        g1.addEdge(new Edge(6, 4, 0.93));

        return g1;
    }

    private final int V;
    private int E;
    private Queue<Edge>[] adj;

    @SuppressWarnings("unchecked")
    WeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new Queue[V];
        for (int i = 0; i < V; i++) {
            this.adj[i] = new LinkedList<Edge>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);

        adj[v].add(e);
        adj[w].add(e);
    }

    public Queue<Edge> adj(int w) {
        return adj[w];
    }

    public Queue<Edge> edges() {
        Queue<Edge> allEdges = new LinkedList<Edge>();
        for (int v = 0; v < V; v++) {
            for (Edge e : adj(v)) {
                int w = e.other(v);
                if (w > v) {
                    allEdges.add(e);
                }
            }
        }
        return allEdges;
    }
}
