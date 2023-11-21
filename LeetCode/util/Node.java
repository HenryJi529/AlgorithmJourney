package util;

import java.util.List;
import java.util.ArrayList;

public class Node implements Comparable<Node> {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }

    @Override
    public int compareTo(Node other) {
        if (this.val < other.val) {
            return -1;
        } else if (this.val == other.val) {
            return 0;
        } else {
            return 1;
        }
    }

}
