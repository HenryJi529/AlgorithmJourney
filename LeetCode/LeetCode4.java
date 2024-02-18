public class LeetCode4 {
    public static void main(String[] args) {
        // 输入：nums1 = [1,3], nums2 = [2]
        // 输出：2.00000
        // 解释：合并数组 = [1,2,3] ，中位数 2
        System.out.println(new Solution4().findMedianSortedArrays(new int[] { 1, 3 },
                new int[] { 2 }));

        // 输入：nums1 = [1,2], nums2 = [3,4]
        // 输出：2.50000
        // 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
        System.out.println(new Solution4().findMedianSortedArrays(new int[] { 1, 2 },
                new int[] { 3, 4 }));
    }
}

class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        Integer cur = null;
        Integer pre = null;
        while (true) {
            // System.out.println(pre + " " + cur);
            pre = cur;
            if (p1 == nums1.length) {
                cur = nums2[p2];
                p2++;
            } else if (p2 == nums2.length) {
                cur = nums1[p1];
                p1++;
            } else {
                if (nums1[p1] < nums2[p2]) {
                    cur = nums1[p1];
                    p1++;
                } else {
                    cur = nums2[p2];
                    p2++;
                }
            }
            // p1 + p2 代表已经访问过的元素总数
            if ((nums1.length + nums2.length) % 2 == 0) {
                // 总数为偶数
                if (p1 + p2 == (nums1.length + nums2.length) / 2 + 1) {
                    return (cur + pre) / 2.0;
                }
            } else {
                // 总数为奇数
                if (p1 + p2 == (nums1.length + nums2.length) / 2 + 1) {
                    return cur;
                }
            }
        }
    }
}