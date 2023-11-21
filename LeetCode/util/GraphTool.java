package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class GraphTool {
    public static Node[] getNodesFromAdjList(int[][] adjList) {
        Node[] nodes = new Node[adjList.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1);
        }
        for (int i = 0; i < nodes.length; i++) {
            nodes[i].neighbors = new ArrayList<Node>();
            for (int val : adjList[i]) {
                nodes[i].neighbors.add(nodes[val - 1]);
            }
        }
        return nodes;
    }

    public static int[][] getAdjListFromNodes(Node[] nodes) {
        int[][] adjList = new int[nodes.length][];
        for (Node node : nodes) {
            adjList[node.val - 1] = new int[node.neighbors.size()];
            for (int i = 0; i < node.neighbors.size(); i++) {
                adjList[node.val - 1][i] = node.neighbors.get(i).val;
            }
        }
        return adjList;
    }

    public static Node[] getNodesFromFirstNode(Node firstNode) {
        if (firstNode == null) {
            return new Node[] {};
        }
        HashSet<Node> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        Node node;

        set.add(firstNode);
        queue.add(firstNode);
        while (!queue.isEmpty()) {
            node = queue.poll();
            for (Node neighbor : node.neighbors) {
                if (set.contains(neighbor)) {
                    continue;
                } else {
                    set.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        Node[] nodes = set.toArray(new Node[set.size()]);
        Arrays.sort(nodes);

        return nodes;
    }
}
