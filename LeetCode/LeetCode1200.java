import java.util.List;
import java.util.ArrayList;

import util.PrintUtil;

public class LeetCode1200 {
    public static void main(String[] args) {
        // 输入：arr = [4,2,1,3]
        // 输出：[[1,2],[2,3],[3,4]]
        PrintUtil.printNestedList(new Solution1200().minimumAbsDifference(new int[] { 4, 2, 1, 3 }));

        // 输入：arr = [1,3,6,10,15]
        // 输出：[[1,3]]
        PrintUtil.printNestedList(new Solution1200().minimumAbsDifference(new int[] { 1, 3, 6, 10, 15 }));

        // 输入：arr = [3,8,-10,23,19,-4,-14,27]
        // 输出：[[-14,-10],[19,23],[23,27]]
        PrintUtil
                .printNestedList(new Solution1200().minimumAbsDifference(new int[] { 3, 8, -10, 23, 19, -4, -14, 27 }));

    }
}

class Solution1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        sort(arr, 0, arr.length - 1);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int min = arr[1] - arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            int cur = arr[i + 1] - arr[i];
            if (cur < min) {
                result.clear();
                min = cur;
            }
            if (cur == min) {
                result.add(List.of(arr[i], arr[i + 1]));
            }
        }
        return result;
    }

    public void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int partitionIndex = partition(arr, start, end);
        sort(arr, start, partitionIndex - 1);
        sort(arr, partitionIndex + 1, end);
    }

    public int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int left = start + 1;
        int right = end;
        int temp;
        while (true) {
            while (arr[left] <= pivot) {
                if (left == end) {
                    break;
                }
                left++;
            }
            while (arr[right] > pivot) {
                if (right == start) {
                    break;
                }
                right--;
            }

            if (left >= right) {
                break;
            }
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        temp = arr[right];
        arr[right] = arr[start];
        arr[start] = temp;
        return right;
    }
}