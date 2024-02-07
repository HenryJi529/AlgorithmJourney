import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;

import util.PrintUtil;

public class LeetCode15 {

    public static void main(String[] args) {
        // 输入：nums = [-1,0,1,2,-1,-4]
        // 输出：[[-1,-1,2],[-1,0,1]]
        PrintUtil.printNestedList(new Solution15().threeSum(new int[] { -1, 0, 1, 2,
                -1, -4 }));

        // 输入：nums = [0,1,1]
        // 输出：[]
        PrintUtil.printNestedList(new Solution15().threeSum(new int[] { 0, 1, 1 }));

        // 输入：nums = [0,0,0]
        // 输出：[[0,0,0]]
        PrintUtil.printNestedList(new Solution15().threeSum(new int[] { 0, 0, 0 }));

        // 输入：nums = [-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0]
        // 输出：[[-5,1,4],[-4,0,4],[-4,1,3],[-2,-2,4],[-2,1,1],[0,0,0]]
        PrintUtil.printNestedList(
                new Solution15().threeSum(new int[] { -4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0,
                        -2, 3, 1, -5, 0 }));

        // 输入：nums = [-5,0,-2,3,-2,1,1,3,0,-5,3,3,0,-1]
        // 输出：[[-2,-1,3],[-2,1,1],[-1,0,1],[0,0,0]]
        PrintUtil.printNestedList(
                new Solution15().threeSum(new int[] { -5, 0, -2, 3, -2, 1, 1, 3, 0, -5, 3, 3, 0, -1 }));
    }
}

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> seconds = new HashSet<Integer>();
        HashSet<String> records = new HashSet<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (seconds.contains(0 - nums[i] - nums[j])) {
                    List<Integer> list = List.of(nums[i], 0 - nums[i] - nums[j], nums[j]);
                    // NOTE: 去重很重要
                    String s = String.format("%d|%d|%d", nums[i], 0 - nums[i] - nums[j], nums[j]);
                    if (!records.contains(s)) {
                        result.add(list);
                        records.add(s);
                    }
                }
                seconds.add(nums[j]);
            }
            seconds.clear();
        }
        return result;
    }
}