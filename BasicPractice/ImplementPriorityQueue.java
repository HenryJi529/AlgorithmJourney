public class ImplementPriorityQueue {
    public static void main(String[] args) {
        MaxPriorityQueue<String> q_max = new MaxPriorityQueue<String>(10);
        MinPriorityQueue<String> q_min = new MinPriorityQueue<String>(10);

        for (char c : "CFDGBADE".toCharArray()) {
            q_max.insert(String.valueOf(c));
            q_min.insert(String.valueOf(c));
        }

        System.out.println("Test MaxPriorityQueue...");
        while (!q_max.isEmpty()) {
            System.out.print(q_max.popTopPriority() + " ");
        }
        System.out.println("\n================================================");

        System.out.println("Test MinPriorityQueue...");
        while (!q_min.isEmpty()) {
            System.out.print(q_min.popTopPriority() + " ");
        }
        System.out.println("\n================================================");

        MinIndexPriorityQueue<String> q1 = new MinIndexPriorityQueue<String>(10);
        q1.insert(0, "0");
        q1.insert(2, "2");
        q1.insert(4, "4");
        q1.insert(1, "1");
        q1.changeItem(0, "9");
        q1.delete(2);

        System.out.println("Test MinIndexPriorityQueue...");
        while (!q1.isEmpty()) {
            System.out.print(q1.delMin() + " ");
        }
        System.out.println("\n================================================");

    }
}

abstract class PriorityQueue<T extends Comparable<T>> {

    protected int N;
    protected T[] items;

    @SuppressWarnings("unchecked")
    public PriorityQueue(int capacity) {
        this.N = 0;
        this.items = (T[]) new Comparable[capacity + 1];
    }

    public T popTopPriority() {
        T topPriority = this.items[1];
        exchange(N, 1);
        this.items[N] = null;
        N--;
        sink(1);
        return topPriority;
    }

    public void insert(T t) {
        this.items[++N] = t;
        swim(N);
    }

    protected abstract boolean prioritize(int i, int j);

    protected void exchange(int i, int j) {
        T temp = this.items[i];
        this.items[i] = this.items[j];
        this.items[j] = temp;
    }

    protected void swim(int k) {
        while (k > 1) {
            if (prioritize(k, k / 2)) {
                exchange(k, k / 2);
            } else {
                break;
            }
            k = k / 2;
        }
    }

    protected void sink(int k) {
        int prioriterIndex;
        while (2 * k <= N) {
            // 获取子节点中优先的一个
            if (2 * k + 1 > N) {
                prioriterIndex = 2 * k;
            } else {
                prioriterIndex = prioritize(2 * k, 2 * k + 1) ? 2 * k : 2 * k + 1;
            }

            // 判断叫优节点是否优于父节点
            if (prioritize(prioriterIndex, k)) {
                exchange(prioriterIndex, k);
            } else {
                break;
            }

            k = prioriterIndex;

        }
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }
}

class MaxPriorityQueue<T extends Comparable<T>> extends PriorityQueue<T> {
    public MaxPriorityQueue(int capacity) {
        super(capacity);
    }

    @Override
    protected boolean prioritize(int i, int j) {
        return this.items[i].compareTo(this.items[j]) >= 0;
    }
}

class MinPriorityQueue<T extends Comparable<T>> extends PriorityQueue<T> {
    public MinPriorityQueue(int capacity) {
        super(capacity);
    }

    @Override
    protected boolean prioritize(int i, int j) {
        return this.items[i].compareTo(this.items[j]) <= 0;
    }
}

class MinIndexPriorityQueue<T extends Comparable<T>> {
    private T[] items;
    private int[] pq;
    private int[] qp;
    private int N;

    @SuppressWarnings("unchecked")
    public MinIndexPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity];
        this.pq = new int[capacity + 1];
        this.qp = new int[capacity];
        this.N = 0;

        for (int i = 0; i < qp.length; i++) {
            this.qp[i] = -1;
        }
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean contains(int k) {
        return this.qp[k] != -1;
    }

    private boolean less(int i, int j) {
        /* 比较两索引对应元素的值 */
        return items[pq[i]].compareTo(items[pq[j]]) < 0;
    }

    private void exch(int i, int j) {
        // 交换pq中的元素
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;

        // 更新对应的qp
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private void swim(int k) {
        while (k > 1) {
            if (this.less(k, k / 2)) {
                exch(k, k / 2);
            } else {
                break;
            }
            k = k / 2;
        }
    }

    private void sink(int k) {
        int priorierIndex;
        while (2 * k <= N) {
            if (2 * k + 1 > N) {
                priorierIndex = 2 * k;
            } else {
                if (less(2 * k, 2 * k + 1)) {
                    priorierIndex = 2 * k;
                } else {
                    priorierIndex = 2 * k + 1;
                }
            }
            if (less(priorierIndex, k)) {
                exch(k, priorierIndex);
            } else {
                break;
            }
            k = priorierIndex;
        }
    }

    public int delMin() {
        // 获取最小元素的索引
        int minIndex = this.pq[1];

        // 删除最小的元素并更新pq, qp
        this.items[minIndex] = null;
        this.qp[minIndex] = -1;
        this.pq[1] = this.pq[this.N];
        this.N--;
        this.qp[this.pq[this.N]] = 1;

        sink(1);
        return minIndex;
    }

    public void insert(int i, T t) {
        // 判断insert的位置是否有元素
        if (this.contains(i)) {
            System.out.print("Error: already contains...");
            return;
        }
        // 更新items
        this.items[i] = t;
        // 更新pq
        this.pq[++N] = i;
        // 更新qp
        this.qp[i] = N;

        swim(N);
    }

    public void changeItem(int i, T t) {
        // 更新items
        this.items[i] = t;
        // 更新堆结构
        sink(this.qp[i]);
        swim(this.qp[i]);
    }

    public int minIndex() {
        return this.pq[1];
    }

    public void delete(int i) {
        this.items[i] = null;
        int delIndex = this.qp[i];
        this.pq[i] = this.pq[N];
        N--;
        this.qp[i] = -1;
        this.sink(delIndex);
        this.swim(delIndex);
    }
}