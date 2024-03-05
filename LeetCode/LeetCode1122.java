import java.util.Arrays;
import java.util.HashMap;

public class LeetCode1122 {
    public static void main(String[] args) {
        // 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
        // 输出：[2,2,2,1,4,3,3,9,6,7,19]
        System.out.println(Arrays
                .toString(new Solution1022().relativeSortArray(new int[] { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 },
                        new int[] { 2, 1, 4, 3, 9, 6 })));

        // 输入：arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
        // 输出：[22,28,8,6,17,44]
        System.out.println(Arrays
                .toString(new Solution1022().relativeSortArray(new int[] { 28, 6, 22, 8, 44, 17 },
                        new int[] { 22, 28, 8, 6 })));
    }
}

class Solution1022 {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        sort(arr1, 0, arr1.length - 1);
        return arr1;
    }

    public int getValue(int key) {
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            return key + map.size();
        }
    }

    public int partition(int[] array, int start, int end) {
        int pivot = getValue(array[start]);
        int left = start + 1;
        int right = end;
        int temp;
        while (true) {
            if (getValue(array[left]) <= pivot) {
                if (left == end) {
                    break;
                }
                left += 1;
                continue;
            }
            if (getValue(array[right]) > pivot) {
                if (right == start) {
                    break;
                }
                right -= 1;
                continue;
            }

            if (right < left) {
                break;
            }

            temp = array[right];
            array[right] = array[left];
            array[left] = temp;
        }
        temp = array[start];
        array[start] = array[right];
        array[right] = temp;
        return right;
    }

    public void sort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int partitionIndex = partition(array, start, end);
        sort(array, start, partitionIndex - 1);
        sort(array, partitionIndex + 1, end);
    }
}
