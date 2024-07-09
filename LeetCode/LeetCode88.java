import java.util.Arrays;

import util.PrintUtil;

public class LeetCode88 {
    public static void main(String[] args) {
        int[] nums1, nums2;
        int m, n;
        // 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        // 输出：[1,2,2,3,5,6]
        nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
        nums2 = new int[] { 2, 5, 6 };
        m = 3;
        n = 3;
        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("nums2: " + Arrays.toString(nums2));
        new Solution88().merge(nums1, m, nums2, n);
        System.out.println("nums1: " + Arrays.toString(nums1));
        PrintUtil.printDivider();

        // 输入：nums1 = [1], m = 1, nums2 = [], n = 0
        // 输出：[1]
        nums1 = new int[] { 1 };
        nums2 = new int[] {};
        m = 1;
        n = 0;
        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("nums2: " + Arrays.toString(nums2));
        new Solution88().merge(nums1, m, nums2, n);
        System.out.println("nums1: " + Arrays.toString(nums1));
        PrintUtil.printDivider();

        // 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
        // 输出：[1]
        nums1 = new int[] { 0 };
        nums2 = new int[] { 1 };
        m = 0;
        n = 1;
        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("nums2: " + Arrays.toString(nums2));
        new Solution88().merge(nums1, m, nums2, n);
        System.out.println("nums1: " + Arrays.toString(nums1));
        PrintUtil.printDivider();
    }
}

class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p3 = m + n - 1;
        while (p3 >= 0) {
            if (p1 >= 0 && p2 < 0) {
                nums1[p3] = nums1[p1];
                p1--;
            } else if (p1 < 0 && p2 >= 0) {
                nums1[p3] = nums2[p2];
                p2--;
            } else {
                if (nums1[p1] >= nums2[p2]) {
                    nums1[p3] = nums1[p1];
                    p1--;
                } else {
                    nums1[p3] = nums2[p2];
                    p2--;
                }
            }
            p3--;
        }
    }
}