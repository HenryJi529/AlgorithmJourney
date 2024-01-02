import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;

public class LeetCode399 {
    public static void main(String[] args) {
        // 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries =
        // [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
        // 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
        System.out.println(
                Arrays.toString(new Solution399().calcEquation(List.of(List.of("a", "b"), List.of("b", "c")),
                        new double[] { 2.0, 3.0 },
                        List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"),
                                List.of("x", "x")))));

        // 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0],
        // queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
        // 输出：[3.75000,0.40000,5.00000,0.20000]
        System.out.println(
                Arrays.toString(new Solution399().calcEquation(
                        List.of(List.of("a", "b"), List.of("b", "c"), List.of("bc", "cd")),
                        new double[] { 1.5, 2.5, 5.0 },
                        List.of(List.of("a", "c"), List.of("c", "b"), List.of("bc", "cd"),
                                List.of("cd", "bc")))));

        // 输入：equations = [["a","b"]], values = [0.5], queries =
        // [["a","b"],["b","a"],["a","c"],["x","y"]]
        // 输出：[0.50000,2.00000,-1.00000,-1.00000]
        System.out.println(
                Arrays.toString(new Solution399().calcEquation(List.of(List.of("a", "b")),
                        new double[] { 0.5 },
                        List.of(List.of("a", "b"), List.of("b", "a"), List.of("a", "c"), List.of("x",
                                "y")))));

        // 输入：equations = [["a","b"],["c","d"]], values = [1.0,1.0], queries =
        // [["a","c"],["b","d"],["b","a"],["d","c"]]
        // 输出：[-1.0,-1.0,1.0,1.0]
        System.out.println(
                Arrays.toString(new Solution399().calcEquation(List.of(List.of("a", "b"), List.of("c", "d")),
                        new double[] { 1.0, 1.0 },
                        List.of(List.of("a", "c"), List.of("b", "d"), List.of("b", "a"), List.of("d",
                                "c")))));
    }
}

class Solution399 {
    class Edge {
        String to;
        double cost;

        Edge(String to, double cost) {
            this.to = to;
            this.cost = cost;
        }

        public String toString() {
            return String.format("(%s, %f)", this.to, this.cost);
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Edge>> graph = buildGraph(equations, values);
        // System.out.println(graph);
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            result[i] = calcCost(query.get(0), query.get(1), graph);
        }
        return result;
    }

    public HashMap<String, List<Edge>> buildGraph(List<List<String>> equations, double[] values) {
        HashMap<String, List<Edge>> graph = new HashMap<String, List<Edge>>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double value = values[i];
            if (!graph.containsKey(equation.get(0))) {
                graph.put(equation.get(0), new ArrayList<Edge>());
            }
            if (!graph.containsKey(equation.get(1))) {
                graph.put(equation.get(1), new ArrayList<Edge>());
            }
            graph.get(equation.get(0)).add(new Edge(equation.get(1), value));
            graph.get(equation.get(1)).add(new Edge(equation.get(0), 1 / value));
        }
        return graph;
    }

    public double calcCost(String start, String end, HashMap<String, List<Edge>> graph) {
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return -1.0;
        }
        if (start.equals(end)) {
            return 1.0;
        }

        List<Edge> path = new ArrayList<Edge>();
        if (dfs(start, end, path, graph, new HashSet<String>())) {
            double cost = 1;
            for (Edge edge : path) {
                cost *= edge.cost;
            }
            return cost;
        } else {
            return -1.0;
        }
    }

    public boolean dfs(String currentNode, String endNode, List<Edge> currentPath,
            HashMap<String, List<Edge>> graph, HashSet<String> visited) {
        visited.add(currentNode);
        for (Edge edge : graph.get(currentNode)) {
            if (visited.contains(edge.to)) {
                continue;
            }
            currentPath.add(edge);
            if (edge.to.equals(endNode)) {
                return true;
            }
            if (dfs(edge.to, endNode, currentPath, graph, visited)) {
                return true;
            }
            currentPath.remove(currentPath.size() - 1);

        }
        visited.remove(currentNode);
        return false;
    }
}