import java.util.HashSet;

public class LeetCode287 {
    public static void main(String[] args) {
        // 输入：nums = [1,3,4,2,2]
        // 输出：2
        System.out.println(new Solution287_4().findDuplicate(new int[] { 1, 3, 4, 2, 2 }));

        // 输入：nums = [3,1,3,4,2]
        // 输出：3
        System.out.println(new Solution287_4().findDuplicate(new int[] { 3, 1, 3, 4, 2 }));
    }
}

class Solution287_1 {
    // NOTE: 这个只能解决某个值重复两次的情况
    public int findDuplicate(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum -= i;
        }
        return sum;
    }
}

class Solution287_2 {
    // NOTE: 时间复杂度为O(n^2)
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }
}

class Solution287_3 {
    // NOTE: 空间复杂度为O(n)
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return -1;
    }
}

class Solution287_4 {
    // NOTE: 快慢指针检测环
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
