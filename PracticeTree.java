import java.util.Queue;
import java.util.LinkedList;

public class PracticeTree {
    public static void main(String[] args) {
        System.out.println("Test BinarySearchTree...");
        BinarySearchTree.test();
        System.out.println("================================================");
    }
}

class BinarySearchTree<Key extends Comparable<Key>, Value> {

    public static void test() {
        BinarySearchTree<Integer, String> t1 = new BinarySearchTree<Integer, String>();
        t1.put(1, "1");
        t1.put(2, "2");
        t1.put(3, "3");
        System.out.println("插入完成后元素的个数: " + t1.size());
        System.out.println("key2对应的元素是: " + t1.get(2));
        t1.delete(3);
        System.out.println("插入完成后元素的个数: " + t1.size());
        System.out.println("key3对应的元素是: " + t1.get(3));
        t1.put(-3, "-3");
        System.out.println("最小的key为: " + t1.min());
        System.out.println("最大的key为: " + t1.max());

        BinarySearchTree<String, String> t2 = new BinarySearchTree<String, String>();
        t2.put("E", "5");
        t2.put("B", "2");
        t2.put("G", "3");
        t2.put("A", "1");
        t2.put("D", "4");
        t2.put("F", "6");
        t2.put("H", "8");
        t2.put("C", "3");
        System.out.println("前序遍历: " + t2.preErgodic());
        System.out.println("中序遍历: " + t2.midErgodic());
        System.out.println("后序遍历: " + t2.afterErgodic());
        System.out.println("层序遍历: " + t2.layerErgodic());
        System.out.println("最大深度: " + t2.maxDepth());
    }

    class Node {
        protected Node left;
        protected Node right;
        protected Key key;
        protected Value value;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    protected Node root;
    private int N;

    public BinarySearchTree() {
        this.root = null;
        this.N = 0;
    }

    public void put(Key key, Value value) {
        root = this.put(root, key, value);
    }

    protected Node put(Node x, Key key, Value value) {
        if (x == null) {
            this.N++;
            return new Node(key, value, null, null);
        }
        int cmp = key.compareTo(x.key);

        if (cmp > 0) {
            // key > x.key
            x.right = this.put(x.right, key, value);
        } else if (cmp < 0) {
            // key < x.key
            x.left = this.put(x.left, key, value);
        } else {
            // key == x.key
            x.value = value;
        }

        return x;
    }

    public Value get(Key key) {
        return this.get(this.root, key);
    }

    protected Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            // key > x.key
            return this.get(x.right, key);
        } else if (cmp < 0) {
            // key < x.key
            return this.get(x.left, key);
        } else {
            // key == x.key
            return x.value;
        }
    }

    public void delete(Key key) {
        this.delete(this.root, key);
    }

    protected Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            // key > x.key
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            // key < x.key
            x.left = delete(x.left, key);
        } else {
            // key == x.key
            if (x.right == null) {
                this.N--;
                return x.left;
            }
            if (x.left == null) {
                this.N--;
                return x.right;
            }
            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }

            Node node = x.right;
            while (node.left != null) {
                if (node.left.left == null) {
                    node.left = null;
                } else {
                    node = node.left;
                }
            }
            x.key = minNode.key;
            x.value = minNode.value;
            this.N--;
        }

        return x;
    }

    public int size() {
        return this.N;
    }

    public Key min() {
        return min(root).key;
    }

    protected Node min(Node x) {
        Node node = x;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public Key max() {
        return max(root).key;
    }

    protected Node max(Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }

    public Queue<Key> preErgodic() {
        Queue<Key> keys = new LinkedList<Key>();
        preErgodic(root, keys);
        return keys;
    }

    protected void preErgodic(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }

        keys.add(x.key);

        if (x.left != null) {
            preErgodic(x.left, keys);
        }

        if (x.right != null) {
            preErgodic(x.right, keys);
        }
    }

    public Queue<Key> midErgodic() {
        Queue<Key> keys = new LinkedList<Key>();
        midErgodic(root, keys);
        return keys;
    }

    protected void midErgodic(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }

        if (x.left != null) {
            midErgodic(x.left, keys);
        }

        keys.add(x.key);

        if (x.right != null) {
            midErgodic(x.right, keys);
        }
    }

    public Queue<Key> afterErgodic() {
        Queue<Key> keys = new LinkedList<Key>();
        afterErgodic(root, keys);
        return keys;
    }

    protected void afterErgodic(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }

        if (x.left != null) {
            afterErgodic(x.left, keys);
        }

        if (x.right != null) {
            afterErgodic(x.right, keys);
        }

        keys.add(x.key);
    }

    public Queue<Key> layerErgodic() {
        Queue<Node> q1 = new LinkedList<Node>();
        Queue<Key> q2 = new LinkedList<Key>();
        q1.add(root);
        while (q1.size() > 0) {
            layerErgodic(q1, q2);
        }
        return q2;
    }

    protected void layerErgodic(Queue<Node> q1, Queue<Key> q2) {
        Node firstNode = q1.remove();
        q2.add(firstNode.key);
        if (firstNode.left != null) {
            q1.add(firstNode.left);
        }
        if (firstNode.right != null) {
            q1.add(firstNode.right);
        }
    }

    public int maxDepth() {
        return maxDepth(root);
    }

    protected int maxDepth(Node x) {
        int leftMaxDepth = 0;
        int rightMaxDepth = 0;

        if (x.left != null) {
            leftMaxDepth = maxDepth(x.left);
        }

        if (x.right != null) {
            rightMaxDepth = maxDepth(x.right);
        }

        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }
}
