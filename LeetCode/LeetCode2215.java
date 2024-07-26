import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import util.PrintUtil;

public class LeetCode2215 {
    public static void main(String[] args) {
        // 输入：nums1 = [1,2,3], nums2 = [2,4,6]
        // 输出：[[1,3],[4,6]]
        PrintUtil.printNestedList(new Solution2215().findDifference(new int[] { 1, 2, 3 }, new int[] { 2, 4, 6 }));

        // 输入：nums1 = [1,2,3,3], nums2 = [1,1,2,2]
        // 输出：[[3],[]]
        PrintUtil
                .printNestedList(new Solution2215().findDifference(new int[] { 1, 2, 3, 3 }, new int[] { 1, 1, 2, 2 }));
    }
}

class Solution2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());

        for (int ele : set1) {
            if (!set2.contains(ele)) {
                ans.get(0).add(ele);
            }
        }
        for (int ele : set2) {
            if (!set1.contains(ele)) {
                ans.get(1).add(ele);
            }
        }
        return ans;
    }
}