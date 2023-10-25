
public class PracticeHeap {
    public static void main(String[] args) {
        System.out.println("Test Heap");
        Heap.test();
        System.out.println("================================================");
    }
}

class Heap<T extends Comparable<T>> {

    public static void test() {
        Heap<String> h1 = new Heap<String>(10);

        h1.insert("A");
        h1.insert("B");
        h1.insert("C");
        h1.insert("D");
        h1.insert("E");
        h1.insert("F");
        h1.insert("G");

        while (h1.size() > 0) {
            System.out.print(h1.delMax() + " ");
        }
        System.out.println();

    }

    private T[] items;
    private int N;

    @SuppressWarnings("unchecked")
    public Heap(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    public int size() {
        return N;
    }

    private void exch(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    private void swim(int k) {
        while (k > 1) {
            if (less(k / 2, k)) {
                exch(k / 2, k);
            } else {
                break;
            }
            k = k / 2;
        }
    }

    public T delMax() {
        T maxValue = items[1];

        exch(N, 1);
        this.items[N] = null;
        this.N--;

        sink(1);
        return maxValue;
    }

    private void sink(int k) {
        while (2 * k <= this.N) {
            // 找出最大的子节点索引
            int largerValueIndex;
            if (2 * k + 1 > N) {
                largerValueIndex = 2 * k;
            } else {
                if (less(2 * k, 2 * k + 1)) {
                    largerValueIndex = 2 * k + 1;
                } else {
                    largerValueIndex = 2 * k;
                }
            }
            // 根据大小决定是否交换
            if (less(k, largerValueIndex)) {
                exch(k, largerValueIndex);
            } else {
                break;
            }
            k = largerValueIndex;
        }
    }
}