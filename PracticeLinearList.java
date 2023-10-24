import java.util.Iterator;

public class PracticeLinearList {
    public static void main(String[] args) {
        System.out.println("Test SequentialList...");
        SequentialList.test();
        System.out.println("================================================");
        System.out.println("Test LinkedList...");
        LinkedList.test();
        System.out.println("================================================");
        System.out.println("Test TwoWayLinkedList...");
        TwoWayLinkedList.test();
        System.out.println("================================================");
        System.out.println("Test Stack...");
        Stack.test();
        System.out.println("================================================");
        System.out.println("Test Queue...");
        Queue.test();
        System.out.println("================================================");
    }
}

class SequentialList<T> implements Iterable<T> {
    public static void test() {
        SequentialList<String> l1 = new SequentialList<>(7);
        l1.append("H");
        l1.append("L");
        l1.insert(1, "E");
        l1.append("L");
        String removed_ele = l1.remove(2);
        System.out.printf("removed_ele: %s\n", removed_ele);
        l1.append("L");
        l1.append("O");
        l1.append(" ");
        l1.append(" ");
        l1.append(" ");
        System.out.printf("indexOf: %s\n", l1.indexOf("O"));

        System.out.println(l1);
    }

    private T[] eles;
    private int N;

    @SuppressWarnings("unchecked")
    public T[] createArray(int capacity) {
        return (T[]) new Object[capacity];
    }

    public SequentialList(int capacity) {
        this.eles = createArray(capacity);
        this.N = 0;
    }

    public void resize(int newSize) {
        T[] temp = this.eles;

        this.eles = createArray(newSize);

        for (int i = 0; i < this.N; i++) {
            this.eles[i] = temp[i];
        }
    }

    public void clear() {
        this.N = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < this.N; i++) {
            sb.append(this.eles[i]);
            if (i < this.N - 1) {
                sb.append(", ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }

    public boolean isEmpty() {
        return this.N > 0;
    }

    public int length() {
        return this.N;
    }

    public T get(int index) {
        return this.eles[index];
    }

    public void append(T ele) {
        if (this.N == this.eles.length) {
            this.resize(N * 2);
        }
        this.eles[N] = ele;
        this.N++;
    }

    public void insert(int index, T ele) {
        if (this.N == this.eles.length) {
            this.resize(N * 2);
        }
        for (int i = index + 1; i <= N; i++) {
            this.eles[i] = this.eles[i - 1];
        }
        this.eles[index] = ele;
        this.N++;
    }

    public T remove(int index) {
        T removed_ele = this.eles[index];
        for (int i = index; i < N - 1; i++) {
            this.eles[i] = this.eles[i + 1];
        }
        this.N--;
        if (this.N < this.eles.length / 4) {
            this.resize(N / 2);
        }
        return removed_ele;
    }

    public int indexOf(T ele) {
        for (int i = 0; i < N; i++) {
            if (this.eles[i] == ele) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private int cursor;

        public MyIterator() {
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return this.cursor < N;
        }

        @Override
        public T next() {
            return eles[this.cursor++];
        }
    }

}

class LinkedList<T> implements Iterable<T> {

    public static void test() {
        LinkedList<String> l1 = new LinkedList<String>();
        l1.insert("h");
        l1.insert("l");
        l1.insert("l");
        l1.insert("l");
        l1.insert("o");
        l1.insert(1, "e");
        l1.remove(l1.indexOf("l"));
        System.out.println(String.format("长度是: %d", l1.length()));
        System.out.println(l1);
        for (String item : l1) {
            System.out.print(item);
        }
        System.out.println();
        l1.reverse();
        System.out.println(l1);
        System.out.println(String.format("中间值是%s", l1.getMid()));
    }

    class Node {
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node head;
    private int N;

    public LinkedList() {
        // 初始化头节点
        this.head = new Node(null, null);

        // 初始化元素个数
        this.N = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {

        private Node currentNode;

        public MyIterator() {
            this.currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return this.currentNode.next != null;
        }

        @Override
        public T next() {
            this.currentNode = currentNode.next;
            return this.currentNode.item;
        }
    }

    public T getMid() {
        Node fast = this.head.next;
        Node slow = this.head.next;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.item;
    }

    public void clear() {
        this.head.next = null;
        this.N = 0;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int length() {
        return this.N;
    }

    public T get(int i) {
        if (i >= this.N) {
            return null;
        }
        Node node = this.head;
        for (int index = 0; index <= i; index++) {
            node = node.next;
        }
        return node.item;
    }

    public void insert(T t) {
        // 找到当前最后一个节点
        Node node = this.head;
        while (node.next != null) {
            node = node.next;
        }
        // 创建新节点
        Node newNode = new Node(t, null);
        // 让当前最后一个节点指向新节点
        node.next = newNode;
        this.N++;
    }

    public void insert(int i, T t) {
        // 找到i位置前一个节点和i位置的节点
        Node node = this.head;
        for (int j = 0; j <= i - 1; j++) {
            node = node.next;
        }
        Node preNode = node;
        Node nextNode = node.next;
        // 创建新节点
        Node newNode = new Node(t, nextNode);
        // 链接新节点
        preNode.next = newNode;
        // 更新长度
        this.N++;
    }

    public T remove(int i) {
        // 获取i前后的节点
        Node node = this.head;
        for (int j = 0; j <= i - 1; j++) {
            node = node.next;
        }
        Node preNode = node;
        Node currentNode = preNode.next;
        Node nextNode = currentNode.next;

        // 链接pre与after
        preNode.next = nextNode;

        // 更新长度
        this.N = this.N - 1;
        return currentNode.item;

    }

    public int indexOf(T t) {
        Node node = this.head;
        for (int i = 0; node.next != null; i++) {
            node = node.next;
            if (node.item.equals(t)) {
                return i;
            }
        }
        return -1;
    }

    public void reverse() {
        if (this.isEmpty()) {
            return;
        }
        reverse(head.next);
    }

    private Node reverse(Node currentNode) {
        if (currentNode.next == null) {
            head.next = currentNode;
            return currentNode;
        }
        Node preNode = reverse(currentNode.next);
        preNode.next = currentNode;
        currentNode.next = null;
        return currentNode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node node = this.head;
        sb.append("[ ");
        for (int i = 0; i < this.N; i++) {
            node = node.next;
            sb.append(node.item);
            if (i < this.N - 1) {
                sb.append("->");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }

}

class TwoWayLinkedList<T> implements Iterable<T> {

    public static void test() {
        TwoWayLinkedList<String> l1 = new TwoWayLinkedList<String>();
        l1.insert("1");
        l1.insert("3");
        l1.insert("5");
        l1.insert("4");
        l1.insert(1, "2");
        l1.remove(3);
        System.out.println(l1);
        for (String item : l1) {
            System.out.print(item);
        }
        System.out.println();
    }

    class Node {
        public T item;
        public Node next;
        public Node pre;

        public Node(T item, Node next, Node pre) {
            this.item = item;
            this.next = next;
            this.pre = pre;
        }
    }

    private Node head;
    private Node last;
    private int N;

    public TwoWayLinkedList() {
        this.head = new Node(null, null, null);
        this.last = null;
        this.N = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private Node currentNode;

        public MyIterator() {
            this.currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return this.currentNode.next != null;
        }

        @Override
        public T next() {
            this.currentNode = currentNode.next;
            return this.currentNode.item;
        }
    }

    public void clear() {
        this.head.next = null;
        this.last = null;
        this.N = 0;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int length() {
        return this.N;
    }

    public T getFirst() {
        if (this.head.next == null) {
            return null;
        }
        return this.head.next.item;
    }

    public T getLast() {
        if (this.last == null) {
            return null;
        }
        return this.last.item;
    }

    public void insert(T item) {
        Node newNode = new Node(item, null, null);
        if (this.isEmpty()) {
            newNode.pre = this.head;
            this.head.next = newNode;
        } else {
            newNode.pre = this.last;
            this.last.next = newNode;
        }
        this.last = newNode;
        this.N++;
    }

    public void insert(int i, T item) {
        Node newNode = new Node(item, null, null);
        Node preNode = this.head;
        for (int j = 0; j < i; j++) {
            preNode = preNode.next;
        }

        Node nextNode = preNode.next;
        newNode.pre = preNode;
        preNode.next = newNode;
        nextNode.pre = newNode;
        newNode.next = nextNode;

        this.N++;
    }

    public T get(int i) {
        if (i >= this.N) {
            return null;
        }
        Node node = this.head;
        for (int index = 0; index <= i; index++) {
            node = node.next;
        }
        return node.item;
    }

    public int indexOf(T t) {
        Node node = this.head;
        for (int i = 0; node.next != null; i++) {
            node = node.next;
            if (node.item.equals(t)) {
                return i;
            }
        }
        return -1;
    }

    public T remove(int i) {
        if (i >= this.N) {
            return null;
        }
        Node node = this.head;
        for (int index = 0; index <= i; index++) {
            node = node.next;
        }
        Node preNode = node.pre;
        Node nextNode = node.next;

        preNode.next = nextNode;
        nextNode.pre = preNode;

        this.N--;

        return node.item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node node = this.head;
        sb.append("[ ");
        for (int i = 0; i < this.N; i++) {
            node = node.next;
            sb.append(node.item);
            if (i < this.N - 1) {
                sb.append("->");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }
}

class Stack<T> implements Iterable<T> {

    public static void test() {
        Stack<String> s1 = new Stack<String>();
        s1.push("1");
        s1.push("3");
        s1.pop();
        s1.push("3");
        s1.push("7");
        s1.pop();
        System.out.println(s1);
        for (String item : s1) {
            System.out.print(item);
        }
        System.out.println();
    }

    private int N;
    private Node head;

    private class Node {
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Stack() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private Node currentNode;

        public MyIterator() {
            this.currentNode = head;
        }

        public boolean hasNext() {
            return this.currentNode.next != null;
        }

        public T next() {
            this.currentNode = this.currentNode.next;
            return this.currentNode.item;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(T t) {
        Node newNode = new Node(t, null);
        if (this.head.next == null) {
            this.head.next = newNode;
        } else {
            Node topNode = this.head.next;
            this.head.next = newNode;
            newNode.next = topNode;
        }
        this.N++;
    }

    public T pop() {
        Node topNode = this.head.next;
        if (topNode == null) {
            return null;
        }
        this.head.next = topNode.next;
        this.N--;
        return topNode.item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node node = this.head;
        sb.append("[ ");
        for (int i = 0; i < this.N; i++) {
            node = node.next;
            sb.append(node.item);
            if (i < this.N - 1) {
                sb.append("->");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }
}

class Queue<T> implements Iterable<T> {
    public static void test() {
        Queue<Integer> q1 = new Queue<Integer>();
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        q1.dequeue();
        q1.enqueue(4);
        System.out.println(q1);
        for (int item : q1) {
            System.out.print(item);
        }
        System.out.println();
    }

    public class Node {
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node head;
    private Node last;
    private int N;

    public Queue() {
        this.head = new Node(null, null);
        this.last = null;
        this.N = 0;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int size() {
        return this.N;
    }

    public void enqueue(T t) {
        Node newNode = new Node(t, null);
        if (this.isEmpty()) {
            this.head.next = newNode;
            this.last = newNode;
        } else {
            Node oldLast = this.last;
            oldLast.next = newNode;
            this.last = newNode;
        }
        this.N++;
    }

    public T dequeue() {
        if (this.isEmpty()) {
            return null;
        }

        Node oldFirst = this.head.next;
        Node newFirst = oldFirst.next;

        this.head.next = newFirst;
        this.N--;
        return oldFirst.item;
    }

    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private Node node;

        public MyIterator() {
            this.node = head;
        }

        public boolean hasNext() {
            return this.node.next != null;
        }

        public T next() {
            node = node.next;
            return node.item;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = this.head;
        for (int i = 0; i < this.N; i++) {
            node = node.next;
            sb.append(node.item.toString());
            if (i < this.N - 1) {
                sb.append("->");
            }
        }
        return sb.toString();
    }
}