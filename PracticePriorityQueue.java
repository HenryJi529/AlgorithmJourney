public class PracticePriorityQueue {

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
