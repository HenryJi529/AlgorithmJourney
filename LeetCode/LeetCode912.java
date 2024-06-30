import java.util.Arrays;

public class LeetCode912 {
    public static void main(String[] args) {
        // 输入：nums = [5,2,3,1]
        // 输出：[1,2,3,5]
        System.out.println(Arrays.toString(new Solution912().sortArray(new int[] { 5, 2, 3, 1 })));

        // 输入：nums = [5,1,1,2,0,0]
        // 输出：[0,0,1,1,2,5]
        System.out.println(Arrays.toString(new Solution912().sortArray(new int[] { 5, 1, 1, 2, 0, 0 })));
    }
}

class Solution912 {
    private int[] assist;

    public int[] sortArray(int[] nums) {
        int[] orderedNums = Arrays.copyOf(nums, nums.length);
        assist = new int[orderedNums.length];
        sort(orderedNums, 0, orderedNums.length - 1);
        return orderedNums;
    }

    public void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        sort(arr, start, mid);
        sort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public void merge(int[] arr, int low, int mid, int high) {
        int arr1_low = low;
        int arr1_high = mid;
        int arr2_low = mid + 1;
        int arr2_high = high;

        int p1 = arr1_low;
        int p2 = arr2_low;
        int p3 = low;

        while (true) {
            if (p1 > arr1_high) {
                for (int i = p3, j = p2; i <= high && j <= arr2_high; i++, j++) {
                    assist[i] = arr[j];
                }
                break;
            }
            if (p2 > arr2_high) {
                for (int i = p3, j = p1; i <= high && j <= arr1_high; i++, j++) {
                    assist[i] = arr[j];
                }
                break;
            }
            if (arr[p2] < arr[p1]) {
                assist[p3] = arr[p2];
                p2++;
            } else {
                assist[p3] = arr[p1];
                p1++;
            }
            p3++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = assist[i];
        }
    }
}