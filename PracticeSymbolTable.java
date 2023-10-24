public class PracticeSymbolTable {
    public static void main(String[] args) {
        System.out.println("Test SimpleSymbolTable...");
        SimpleSymbolTable.test();
        System.out.println("================================================");
        System.out.println("Test OrderedSymbolTable...");
        OrderedSymbolTable.test();
        System.out.println("================================================");
    }
}

class SimpleSymbolTable<Key, Value> {
    public static void test() {
        SimpleSymbolTable<Integer, String> s1 = new SimpleSymbolTable<Integer, String>();
        s1.put(1, "1");
        s1.put(2, "2");
        s1.delete(1);
        s1.put(2, "3");
        s1.put(-2, "3");
        s1.put(9, "10");
        System.out.println(s1);
        System.out.println(s1.size());
        System.out.println(s1.get(2));
    }

    protected class Node {
        protected Key key;
        protected Value value;
        protected Node next;

        protected Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    protected Node head;
    protected int N;

    public SimpleSymbolTable() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    public int size() {
        return this.N;
    }

    public Value get(Key key) {
        Node node = this.head;
        while (node.next != null) {
            node = node.next;
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        // NOTE: 需要判断是否已经存在这个key
        Node node = this.head;
        while (node.next != null) {
            node = node.next;
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        // NOTE: 新插入的节点要放在链表的头部
        Node newNode = new Node(key, value, null);
        Node oldFirst = this.head.next;
        newNode.next = oldFirst;
        this.head.next = newNode;
        this.N++;
        return;
    }

    public void delete(Key key) {
        Node node = this.head;
        while (node.next != null) {
            if (node.next.key.equals(key)) {
                node.next = node.next.next;
                this.N--;
                return;
            }
            node = node.next;
        }
        return;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        Node node = this.head;
        for (int i = 0; i < this.N; i++) {
            node = node.next;
            sb.append(String.format("%s: %s", node.key.toString(), node.value.toString()));
            if (i != this.N - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

}

class OrderedSymbolTable<Key extends Comparable<Key>, Value> extends SimpleSymbolTable<Key, Value> {
    public static void test() {
        OrderedSymbolTable<Integer, String> s1 = new OrderedSymbolTable<Integer, String>();
        s1.put(1, "1");
        s1.put(2, "2");
        s1.delete(1);
        s1.put(2, "3");
        s1.put(-2, "3");
        s1.put(9, "10");
        System.out.println(s1);
        System.out.println(s1.size());
        System.out.println(s1.get(2));
    }

    @Override
    public void put(Key key, Value value) {
        Node currentNode = head.next;
        Node preNode = head;
        // 遍历到currentNode的key大于等于输入的key或者遍历结束
        while (currentNode != null && key.compareTo(currentNode.key) > 0) {
            preNode = currentNode;
            currentNode = currentNode.next;
        }
        if (currentNode != null && currentNode.key.compareTo(key) == 0) {
            currentNode.value = value;
            return;
        }
        Node newNode = new Node(key, value, null);
        preNode.next = newNode;
        newNode.next = currentNode;
        this.N++;
        return;
    }
}