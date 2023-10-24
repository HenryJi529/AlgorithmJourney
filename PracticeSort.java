import java.util.Arrays;
import java.util.Random;

public class PracticeSort {

    private static int[] assist;

    public static void main(String[] args) {
        int[] arr = { 8, 6, 6, 5, 4, 3, 2, 1, 0, 6 };
        System.out.println("排序前的数组：");
        System.out.println(Arrays.toString(arr));

        int[] arr1 = bubbleSort(arr);
        System.out.println("冒泡排序后的数组：");
        printArray(arr1);

        int[] arr2 = selectionSort(arr);
        System.out.println("选择排序后的数组：");
        printArray(arr2);

        int[] arr3 = insertionSort(arr);
        System.out.println("插入排序后的数组：");
        printArray(arr3);

        int[] arr4 = shellSort(arr);
        System.out.println("希尔排序后的数组：");
        printArray(arr4);

        int[] arr5 = mergeSort(arr);
        System.out.println("归并排序后的数组：");
        printArray(arr5);

        // int[] longArr = new int[100000];
        // for (int i = 0; i < longArr.length; i++) {
        // longArr[i] = 10000 - i;
        // }
        int[] longArr = generateRandomNumbers(10000);
        int[] sortedLongArr = longArr.clone();
        Arrays.sort(sortedLongArr);
        boolean result;

        long start = System.currentTimeMillis();
        result = Arrays.equals(insertionSort(longArr), sortedLongArr);
        long end = System.currentTimeMillis();
        System.out.println(result + " 程序运行时间：" + (end - start) + " 毫秒");

        start = System.currentTimeMillis();
        result = Arrays.equals(shellSort(longArr), sortedLongArr);
        end = System.currentTimeMillis();
        System.out.println(result + " 程序运行时间：" + (end - start) + " 毫秒");

        start = System.currentTimeMillis();
        result = Arrays.equals(mergeSort(longArr), sortedLongArr);
        end = System.currentTimeMillis();
        System.out.println(result + " 程序运行时间：" + (end - start) + " 毫秒");
    }

    public static int[] bubbleSort(int[] arr) {
        int[] array = arr.clone();
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // 交换 array[j] 和 array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] selectionSort(int[] arr) {
        int[] array = arr.clone();
        int N = array.length;
        int min_index;
        for (int i = 0; i < N - 1; i++) {
            min_index = i;
            for (int j = i + 1; j < N; j++) {
                if (array[j] < array[min_index]) {
                    min_index = j;
                }
            }
            int temp = array[min_index];
            array[min_index] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static int[] insertionSort(int[] arr) {
        int[] array = arr.clone();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static int[] shellSort(int[] arr) {
        int[] array = arr.clone();
        int length = array.length;
        int gap = (length / 2);

        while (gap > 0) {
            for (int start = 0; start < gap; start++) {
                for (int i = start; i < length - gap; i = i + gap) {
                    for (int j = i + gap; j > start; j = j - gap) {
                        if (array[j - gap] > array[j]) {
                            int temp = array[j - gap];
                            array[j - gap] = array[j];
                            array[j] = temp;
                        } else {
                            break;
                        }
                    }
                }
            }
            gap = gap / 2;
        }
        return array;
    }

    public static int[] mergeSort(int[] arr) {
        int[] array = arr.clone();
        assist = new int[array.length];

        mergeSort_sort(array, 0, arr.length - 1);
        return array;
    }

    public static void mergeSort_sort(int[] array, int low, int high) {
        if (low > high) {
            return;
        }
        int mid = low + (high - low) / 2;
        if (!(low == mid)) {
            mergeSort_sort(array, low, mid);
        }
        if (!(mid + 1 == high)) {
            mergeSort_sort(array, mid + 1, high);
        }
        mergeSort_merge(array, low, mid, high);
    }

    public static void mergeSort_merge(int[] array, int low, int mid, int high) {
        int array1_low = low, array1_high = mid;
        int array2_low = mid + 1, array2_high = high;

        int p1 = array1_low;
        int p2 = array2_low;
        int p3 = low;

        while (true) {
            if (p1 > array1_high) {
                for (int i = 0; i <= high - p3; i++) {
                    assist[p3 + i] = array[p2 + i];
                }
                break;
            }
            if (p2 > array2_high) {
                for (int i = 0; i <= high - p3; i++) {
                    assist[p3 + i] = array[p1 + i];
                }
                break;
            }

            if (array[p2] < array[p1]) {
                assist[p3] = array[p2];
                p2 += 1;
            } else {
                assist[p3] = array[p1];
                p1 += 1;
            }
            p3 += 1;
        }

        for (int i = low; i <= high; i++) {
            array[i] = assist[i];
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] generateRandomNumbers(int count) {
        int[] numbers = new int[count];
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            numbers[i] = random.nextInt(10000);
        }

        return numbers;
    }
}
