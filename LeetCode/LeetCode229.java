import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode229 {
    public static void main(String[] args) {
        // 输入：nums = [3,2,3]
        // 输出：[3]
        System.out.println(Arrays.toString(new Solution229().majorityElement(new int[] { 3, 2, 3 }).toArray()));

        // 输入：nums = [1]
        // 输出：[1]
        System.out.println(Arrays.toString(new Solution229().majorityElement(new int[] { 1 }).toArray()));

        // 输入：nums = [1,2]
        // 输出：[1,2]
        System.out.println(Arrays.toString(new Solution229().majorityElement(new int[] { 1, 2 }).toArray()));

    }
}

class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        int length = nums.length;
        int onethird = length / 3;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (map.get(nums[i]) + length - i > onethird) {
                    map.put(nums[i], map.get(nums[i]) + 1);
                } else {
                    map.remove(nums[i]);
                }
            } else {
                if (length - i > onethird) {
                    map.put(nums[i], 1);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (Integer item : map.keySet()) {
            if (map.get(item) > onethird) {
                result.add(item);
            }
        }
        return result;
    }
}