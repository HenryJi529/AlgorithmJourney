package util;

public class IndexMinPQ<T extends Comparable<T>> {
    private T[] items;
    private int[] pq;
    private int[] qp;
    private int N;

    @SuppressWarnings("unchecked")
    public IndexMinPQ(int capacity) {
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
