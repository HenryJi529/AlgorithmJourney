import java.util.Arrays;

public class PracticeHeap {
    public static void main(String[] args) {
        System.out.println("Test Heap...");
        Heap.test();
        System.out.println("================================================");
        System.out.println("Test HeapSort...");
        HeapSort.test();
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

class HeapSort {

    public static void test() {
        Integer[] source = { 8, 2, 3, 4, 1, 6 };
        System.out.println(Arrays.toString(source));
        System.out.println(Arrays.toString(sort(source)));
    }

    public static <T extends Comparable<T>> T[] sort(T[] source) {
        T[] result = source.clone();

        // 构建堆
        T[] heap = createHeap(source);

        /* 交换最大元素和首元素，并进行有范围的下沉 */
        int maxUnsortedIndex = heap.length - 1; // 定义一个未排序部分最大元素的索引
        while (maxUnsortedIndex > 1) {
            exch(heap, maxUnsortedIndex, 1);
            sink(heap, 1, maxUnsortedIndex - 1);
            maxUnsortedIndex--;
        }

        System.arraycopy(heap, 1, result, 0, source.length);
        return result;
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> T[] createHeap(T[] source) {
        T[] heap = (T[]) new Comparable[source.length + 1];
        System.arraycopy(source, 0, heap, 1, source.length);

        for (int i = source.length / 2; i >= 1; i--) {
            sink(heap, i, heap.length - 1);
        }
        return heap;
    }

    private static <T extends Comparable<T>> boolean less(T[] heap, int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    private static <T extends Comparable<T>> void exch(T[] heap, int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private static <T extends Comparable<T>> void sink(T[] heap, int target, int range) {
        while (2 * target <= range) {
            // 找出最大的子节点索引
            int largerValueIndex;
            if (2 * target + 1 > range) {
                largerValueIndex = 2 * target;
            } else {
                if (less(heap, 2 * target, 2 * target + 1)) {
                    largerValueIndex = 2 * target + 1;
                } else {
                    largerValueIndex = 2 * target;
                }
            }
            // 根据大小决定是否交换
            if (less(heap, target, largerValueIndex)) {
                exch(heap, target, largerValueIndex);
            } else {
                break;
            }
            target = largerValueIndex;
        }
    }

}