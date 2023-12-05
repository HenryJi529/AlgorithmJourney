import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

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
        System.out.println("测试PrimMST...");
        PrimMST.test();
        System.out.println("===============================================================");
        System.out.println("测试KruskalMST...");
        KruskalMST.test();
        System.out.println("===============================================================");
        System.out.println("测试加权有向图...");
        WeightedDigraph.test();
        System.out.println("===============================================================");
        System.out.println("测试Dijkstra算法...");
        DijkstraSP.test();
        System.out.println("===============================================================");
    }
}

/* 基于PriorityQueue和HashMap的MinIndexPriorityQueue */
class MyMinIndexPriorityQueue<T extends Comparable<T>> {
    private PriorityQueue<Element> pq;
    private Map<Integer, Element> map;

    private class Element implements Comparable<Element> {
        public T value;
        public int key;

        Element(int key, T value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Element that) {
            return this.value.compareTo(that.value);
        }
    }

    MyMinIndexPriorityQueue() {
        this.pq = new PriorityQueue<Element>();
        this.map = new HashMap<>();
    }

    public boolean isEmpty() {
        return pq.isEmpty();
    }

    public T getValue(int key) {
        return map.get(key).value;
    }

    public boolean containsKey(int key) {
        return map.containsKey(key);
    }

    void insert(int key, T value) {
        Element ele = new Element(key, value);
        this.map.put(key, ele);
        this.pq.add(ele);
    }

    void update(int key, T value) {
        Element oldEle = this.map.get(key);
        Element newEle = new Element(key, value);
        this.pq.remove(oldEle);
        this.pq.add(newEle);
        this.map.put(key, newEle);
    }

    public T getMinValue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return pq.peek().value;
    }

    int delMin() {
        Element ele = this.pq.poll();
        this.map.remove(ele.key);
        return ele.key;
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
        E++;
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

        E++;
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

class PrimMST {
    public static void test() {
        WeightedGraph g = WeightedGraph.get_test_graph();
        PrimMST primMST = new PrimMST(g);
        System.out.println(primMST.edges());
    }

    private boolean[] marked;
    private MyMinIndexPriorityQueue<Edge> pq;
    private Queue<Edge> edges;

    PrimMST(WeightedGraph G) {
        this.edges = new LinkedList<Edge>();
        this.marked = new boolean[G.V()];
        this.pq = new MyMinIndexPriorityQueue<Edge>();

        visit(G, 0);
    }

    private void visit(WeightedGraph G, int v) {
        this.marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            double weight = e.weight();
            if (this.marked[w]) {
                // 代表已经加入到生成树中
                continue;
            } else {
                if (this.pq.containsKey(w)) {
                    if (this.pq.getValue(w).weight() > weight) {
                        this.pq.update(w, e);
                    }
                } else {
                    this.pq.insert(w, e);
                }
            }
        }
        if (this.pq.isEmpty()) {
            return;
        } else {
            this.edges.add(this.pq.getMinValue());
            visit(G, this.pq.delMin());
        }
    }

    public Queue<Edge> edges() {
        return edges;
    }
}

class KruskalMST {

    public static void test() {
        WeightedGraph g = WeightedGraph.get_test_graph();
        KruskalMST kruskalMST = new KruskalMST(g);
        System.out.println(kruskalMST.edges());
    }

    class UnionFind {
        private int count;
        private int[] parent;
        private int[] rank;

        UnionFind(int N) {
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

    private Queue<Edge> mst;
    private UnionFind uf;
    private PriorityQueue<Edge> pq;

    KruskalMST(WeightedGraph g) {
        this.mst = new LinkedList<Edge>();
        this.uf = new UnionFind(g.V());
        this.pq = new PriorityQueue<Edge>();

        for (Edge e : g.edges()) {
            pq.add(e);
        }

        while (uf.count() > 1) {
            Edge e = pq.poll();
            int v = e.either();
            int w = e.other(v);
            if (uf.connected(v, w)) {
                continue;
            } else {
                uf.union(v, w);
                mst.add(e);
            }
        }
    }

    public Queue<Edge> edges() {
        return mst;
    }

}

class DirectedEdge {
    private final int v;
    private final int w;
    private final double weight;

    DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    @Override
    public String toString() {
        return String.format("%d->%d(%.2f)", v, w, weight);
    }
}

class WeightedDigraph {
    public static void test() {
        WeightedDigraph g = new WeightedDigraph(5);
        g.addEdge(new DirectedEdge(0, 1, 0.2));
        g.addEdge(new DirectedEdge(1, 2, 0.24));
        g.addEdge(new DirectedEdge(3, 4, 0.3));
        System.out.println(g.edges());
    }

    public static WeightedDigraph get_test_graph() {
        WeightedDigraph g = new WeightedDigraph(8);
        g.addEdge(new DirectedEdge(4, 5, 0.35));
        g.addEdge(new DirectedEdge(5, 4, 0.35));
        g.addEdge(new DirectedEdge(4, 7, 0.37));
        g.addEdge(new DirectedEdge(5, 7, 0.28));
        g.addEdge(new DirectedEdge(7, 5, 0.28));
        g.addEdge(new DirectedEdge(5, 1, 0.32));
        g.addEdge(new DirectedEdge(0, 4, 0.38));
        g.addEdge(new DirectedEdge(0, 2, 0.26));
        g.addEdge(new DirectedEdge(7, 3, 0.39));
        g.addEdge(new DirectedEdge(1, 3, 0.29));
        g.addEdge(new DirectedEdge(2, 7, 0.34));
        g.addEdge(new DirectedEdge(6, 2, 0.40));
        g.addEdge(new DirectedEdge(3, 6, 0.52));
        g.addEdge(new DirectedEdge(6, 0, 0.58));
        g.addEdge(new DirectedEdge(6, 4, 0.93));
        return g;
    }

    private final int V;
    private int E;
    private Queue<DirectedEdge>[] adj;

    @SuppressWarnings("unchecked")
    WeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge e) {
        this.adj[e.from()].add(e);
        E++;
    }

    public Queue<DirectedEdge> adj(int v) {
        return this.adj[v];
    }

    public Queue<DirectedEdge> edges() {
        Queue<DirectedEdge> queue = new LinkedList<DirectedEdge>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : this.adj[v]) {
                queue.add(e);
            }
        }
        return queue;
    }
}

class DijkstraSP {
    public static void test() {
        WeightedDigraph graph = WeightedDigraph.get_test_graph();
        DijkstraSP sp = new DijkstraSP(graph, 0);
        System.out.println(sp.pathTo(6));
    }

    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private MyMinIndexPriorityQueue<Double> pq;

    public DijkstraSP(WeightedDigraph G, int s) {
        this.edgeTo = new DirectedEdge[G.V()];
        this.distTo = new double[G.V()];
        this.pq = new MyMinIndexPriorityQueue<Double>();
        for (int i = 0; i < G.V(); i++) {
            this.distTo[i] = Double.POSITIVE_INFINITY;
        }

        this.distTo[s] = 0;
        this.pq.insert(s, 0.0);
        while (!this.pq.isEmpty()) {
            relax(G, pq.delMin());
        }
    }

    private void relax(WeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            double weight = e.weight();
            if (this.distTo[w] > this.distTo[v] + weight) {
                // 说明新的路径优于旧的路径，需要松弛
                this.edgeTo[w] = e;
                this.distTo[w] = this.distTo[v] + weight;
                this.pq.update(w, this.distTo[v] + weight);
            }
        }
    }

    public double distTo(int v) {
        return this.distTo[v];
    }

    public boolean hasPathTo(int v) {
        return this.distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Queue<DirectedEdge> pathTo(int v) {
        Queue<DirectedEdge> path = new LinkedList<>();
        if (!hasPathTo(v)) {
            return null;
        }
        while (v != 0) {
            DirectedEdge edge = edgeTo[v];
            v = edge.from();
            path.add(edge);
        }
        return path;
    }
}