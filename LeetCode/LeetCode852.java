/* 
 * 问题描述: https://leetcode.cn/problems/peak-index-in-a-mountain-array/
 */

public class LeetCode852 {
    public static void main(String[] args) {
        // 输入：arr = [0,1,0]
        // 输出：1
        System.out.println(new Solution852().peakIndexInMountainArray(new int[] { 0,
                1, 0 }));

        // 输入：arr = [0,2,1,0]
        // 输出：1
        System.out.println(new Solution852().peakIndexInMountainArray(new int[] { 0,
                2, 1, 0 }));

        // 输入：arr = [0,10,5,2]
        // 输出：1
        System.out.println(new Solution852().peakIndexInMountainArray(new int[] { 0,
                10, 5, 2 }));
    }
}

class Solution852 {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int mid = -1;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
            // System.out.println(String.format("[l]: %d; [r]: %d; [mid]: %d", arr[l],
            // arr[r], arr[mid]));
        }
        return l;
    }
}