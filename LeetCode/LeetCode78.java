import java.util.List;
import java.util.ArrayList;

public class LeetCode78 {
    public static void main(String[] args) {
        // 输入：nums = [1,2,3]
        // 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        System.out.println(new Solution78().subsets(new int[] { 1, 2, 3 }));

        // 输入：nums = [0]
        // 输出：[[],[0]]
        System.out.println(new Solution78().subsets(new int[] { 0 }));
    }
}

class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        dfs(new ArrayList<Integer>(), 1, nums, res);
        return res;
    }

    public void dfs(List<Integer> currentList, int index, int[] nums, List<List<Integer>> res) {
        if (index >= (int) Math.pow(2, nums.length)) {
            res.add(currentList);
            return;
        }
        int currentNum = getCurrentNum(index, nums);
        // NOTE: 这里增加了很多复杂度，可以改进
        List<Integer> currentListLeft = new ArrayList<Integer>(currentList);
        List<Integer> currentListRight = new ArrayList<Integer>(currentList);
        currentListRight.add(currentNum);
        dfs(currentListLeft, 2 * index, nums, res);
        dfs(currentListRight, 2 * index + 1, nums, res);
    }

    // NOTE: 其实也可以直接用需要处理的numIndex作为index
    public int getCurrentNum(int index, int[] nums) {
        int numIndex = 0;
        while (index / 2 > 0) {
            numIndex++;
            index /= 2;
        }
        return nums[numIndex];
    }
}