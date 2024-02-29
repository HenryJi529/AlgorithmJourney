import java.util.Arrays;
import java.util.ArrayList;

public class LeetCode349 {
    public static void main(String[] args) {
        // 输入：nums1 = [1,2,2,1], nums2 = [2,2]
        // 输出：[2]
        System.out
                .println(Arrays.toString(new Solution349().intersection(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 })));

        // 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        // 输出：[9,4]
        System.out.println(
                Arrays.toString(new Solution349().intersection(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 })));

    }
}

class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        ArrayList<Integer> record = new ArrayList<Integer>();
        while (p1 < nums1.length && p2 < nums2.length) {
            while (p1 + 1 < nums1.length && nums1[p1] == nums1[p1 + 1]) {
                p1++;
            }
            while (p2 + 1 < nums2.length && nums2[p2] == nums2[p2 + 1]) {
                p2++;
            }
            if (nums1[p1] == nums2[p2]) {
                record.add(nums1[p1]);
                p1++;
                p2++;
            } else {
                if (nums1[p1] < nums2[p2]) {
                    p1++;
                } else {
                    p2++;
                }
            }
        }
        int[] result = new int[record.size()];
        for (int i = 0; i < record.size(); i++) {
            result[i] = record.get(i);
        }

        return result;
    }
}