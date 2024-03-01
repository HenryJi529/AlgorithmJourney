import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class LeetCode594 {
    public static void main(String[] args) {
        // 输入：nums = [1,3,2,2,5,2,3,7]
        // 输出：5
        System.out.println(new Solution594_2().findLHS(new int[] { 1, 3, 2, 2, 5, 2, 3, 7 }));

        // 输入：nums = [1,2,3,4]
        // 输出：2
        System.out.println(new Solution594_2().findLHS(new int[] { 1, 2, 3, 4 }));

        // 输入：nums = [1,1,1,1]
        // 输出：0
        System.out.println(new Solution594_2().findLHS(new int[] { 1, 1, 1, 1 }));
    }
}

class Solution594_1 {
    // NOTE: 哈希表 + 记数
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        if (map.size() > 1) {
            // 可以找到两个
            ArrayList<Integer> keys = new ArrayList<>(map.keySet());
            Collections.sort(keys);
            int result = 0;
            for (int i = 0; i < keys.size() - 1; i++) {
                if (keys.get(i) + 1 == keys.get(i + 1)) {
                    result = Math.max(result, map.get(keys.get(i)) + map.get(keys.get(i + 1)));
                }
            }
            return result;
        } else {
            // 只能找到一个
            return 0;
        }
    }
}

class Solution594_2 {
    // NOTE: 排序 + 滑动窗口
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int begin = 0;
        int res = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while ((nums[i] - nums[begin]) > 1) {
                begin++;
            }
            if ((nums[i] - nums[begin]) == 1) {
                res = Math.max(res, i - begin + 1);
            }
        }
        return res;
    }
}