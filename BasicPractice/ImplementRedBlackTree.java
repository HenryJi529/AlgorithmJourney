public class ImplementRedBlackTree {
    public static void main(String[] args) {
        System.out.println("Test RedBlackTree...");
        RedBlackTree<Integer, String> tree = new RedBlackTree<>();
        tree.put(0, "0");
        tree.put(1, "1");
        tree.put(2, "2");
        tree.put(3, "3");
        System.out.println("tree[0] = " + tree.get(0));
        System.out.println("tree[1] = " + tree.get(1));
        System.out.println("tree[2] = " + tree.get(2));
        System.out.println("tree[3] = " + tree.get(3));
        System.err.println("================================================");
    }
}

class RedBlackTree<Key extends Comparable<Key>, Value> {

    class Node {
        public Key key;
        public Value value;
        public Node left;
        public Node right;
        public boolean color;

        Node(Key key, Value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }

    private Node root;
    private int N;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public RedBlackTree() {
        this.root = null;
        this.N = 0;
    }

    public int size() {
        return N;
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h) {
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
        h.color = !h.color;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val) {
        if (h == null) {
            N++;
            return new Node(key, val, null, null, RED);
        }
        int cmp = key.compareTo(h.key);
        if (cmp > 0) {
            h.right = put(h.right, key, val);
        } else if (cmp < 0) {
            h.left = put(h.left, key, val);
        } else {
            h.value = val;
        }

        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }

        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }

        if (isRed(h.right) && isRed(h.left)) {
            flipColors(h);
        }

        return h;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            return get(x.right, key);
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return x.value;
        }
    }

}