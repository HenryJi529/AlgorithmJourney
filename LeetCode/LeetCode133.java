import java.util.Arrays;
import java.util.HashMap;

import util.Node;
import util.PrintUtil;
import util.GraphTool;

public class LeetCode133 {
    public static void main(String[] args) {
        Node[] nodes1, nodes2;
        int[][] adjList;
        // 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
        // 输出：[[2,4],[1,3],[2,4],[1,3]]
        adjList = new int[][] { { 2, 4 }, { 1, 3 }, { 2, 4 }, { 1, 3 } };
        System.out.println(Arrays.deepToString(adjList));
        nodes1 = GraphTool.getNodesFromAdjList(adjList);
        nodes2 = GraphTool.getNodesFromFirstNode(new Solution133().cloneGraph(nodes1[0]));
        System.out.println(Arrays.toString(nodes2));
        System.out.println(Arrays.deepToString(GraphTool
                .getAdjListFromNodes(nodes2)));
        PrintUtil.printDivider();

        // 输入：adjList = [[]]
        // 输出：[[]]
        adjList = new int[][] { {} };
        System.out.println(Arrays.deepToString(adjList));
        nodes1 = GraphTool.getNodesFromAdjList(adjList);
        nodes2 = GraphTool.getNodesFromFirstNode(new Solution133().cloneGraph(nodes1[0]));
        System.out.println(Arrays.toString(nodes2));
        System.out.println(Arrays.deepToString(GraphTool
                .getAdjListFromNodes(nodes2)));
        PrintUtil.printDivider();

        // 输入：adjList = []
        // 输出：[]
        adjList = new int[][] {};
        System.out.println(Arrays.deepToString(adjList));
        nodes1 = GraphTool.getNodesFromAdjList(adjList);
        nodes2 = GraphTool.getNodesFromFirstNode(new Solution133().cloneGraph(null));
        System.out.println(Arrays.toString(nodes2));
        System.out.println(Arrays.deepToString(GraphTool
                .getAdjListFromNodes(nodes2)));
        PrintUtil.printDivider();

        // 输入：adjList = [[2],[1]]
        // 输出：[[2],[1]]
        adjList = new int[][] { { 2 }, { 1 } };
        System.out.println(Arrays.deepToString(adjList));
        nodes1 = GraphTool.getNodesFromAdjList(adjList);
        nodes2 = GraphTool.getNodesFromFirstNode(new Solution133().cloneGraph(nodes1[0]));
        System.out.println(Arrays.toString(nodes2));
        System.out.println(Arrays.deepToString(GraphTool
                .getAdjListFromNodes(nodes2)));
        PrintUtil.printDivider();
    }
}

class Solution133 {
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node newNode = new Node(node.val);
        map.put(node.val, newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        return newNode;
    }
}