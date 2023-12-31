import java.util.List;
import java.util.ArrayList;

import util.PrintUtil;

public class LeetCode46 {
    public static void main(String[] args) {
        // 输入：nums = [1,2,3]
        // 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        PrintUtil.printNestedList(new Solution46().permute(new int[] { 1, 2, 3 }));

        // 输入：nums = [0,1]
        // 输出：[[0,1],[1,0]]
        PrintUtil.printNestedList(new Solution46().permute(new int[] { 0, 1 }));

        // 输入：nums = [1]
        // 输出：[[1]]
        PrintUtil.printNestedList(new Solution46().permute(new int[] { 1 }));
    }
}

class Solution46 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(0, new ArrayList<Integer>(), nums);
        return res;
    }

    public void dfs(int start, List<Integer> current, int[] nums) {
        if (start == nums.length) {
            res.add(new ArrayList<Integer>(current));
        }
        for (int i = start; i < nums.length; i++) {
            // System.out.println(Arrays.toString(current.toArray()));
            exch(start, i, nums);
            current.add(nums[start]);
            dfs(start + 1, current, nums);

            exch(start, i, nums);
            current.remove(current.size() - 1);
            // System.out.println(Arrays.toString(current.toArray()));

        }
    }

    public void exch(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}