import util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class LeetCode39 {
    public static void main(String[] args) {
        // 输入：candidates = [2,3,6,7], target = 7
        // 输出：[[2,2,3],[7]]
        PrintUtil.printNestedList(new Solution39().combinationSum(new int[] { 2, 3, 6, 7 }, 7));

        // 输入: candidates = [2,3,5], target = 8
        // 输出: [[2,2,2,2],[2,3,3],[3,5]]
        PrintUtil.printNestedList(new Solution39().combinationSum(new int[] { 2, 3, 5
        }, 8));

        // 输入: candidates = [2], target = 1
        // 输出: []
        PrintUtil.printNestedList(new Solution39().combinationSum(new int[] { 2 },
                1));
    }
}

class Solution39 {
    private List<List<Integer>> records = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        dfs(candidates, target, new ArrayList<>(), 0);
        return records;
    }

    public void dfs(int[] candidates, int target, List<Integer> record, int candidateIndex) {
        if (target == 0) {
            records.add(new ArrayList<>(record));
            return;
        }
        if (candidateIndex == candidates.length) {
            return;
        }
        int candidate = candidates[candidateIndex];
        for (int count = 0; count <= target / candidate; count++) {
            // System.out.println(candidate + ": " + count);
            for (int i = 0; i < count; i++) {
                record.add(candidate);
            }
            dfs(candidates, target - count * candidate, record, candidateIndex + 1);
            for (int i = 0; i < count; i++) {
                record.removeLast();
            }
        }
    }
}
