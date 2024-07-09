import java.util.List;
import java.util.ArrayList;

import util.TreeNode;
import util.PrintUtil;

public class LeetCode2476 {
    public static void main(String[] args) {
        // 输入：root = [6,2,13,1,4,9,15,null,null,null,null,null,null,14],
        // queries = [2,5,16]
        // 输出：[[2,2],[4,6],[15,-1]]
        PrintUtil.printNestedList(new Solution2476_2().closestNodes(
                TreeNode.buildTree(
                        new Integer[] { 6, 2, 13, 1, 4, 9, 15, null, null, null, null, null, null, 14 }),
                List.of(2, 5, 16)));

        // 输入：root = [4,null,9], queries = [3]
        // 输出：[[-1,4]]
        PrintUtil.printNestedList(new Solution2476_2().closestNodes(
                TreeNode.buildTree(
                        new Integer[] { 4, null, 9 }),
                List.of(3)));
    }
}

class Solution2476_1 {
    // NOTE: 这个算法在树相对平衡的情况下没有问题
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (Integer query : queries) {
            int min = -1, max = -1;
            TreeNode node = root;
            do {
                System.out.println(String.format("value: %d; min = %d, max = %d", root.val, min, max));
                if (node.val == query) {
                    min = query;
                    max = query;
                    break;
                } else {
                    if (node.val < query) {
                        min = node.val;
                        if (node.right != null) {
                            node = node.right;
                        } else {
                            min = node.val;
                            break;
                        }
                    } else {
                        max = node.val;
                        if (node.left != null) {
                            node = node.left;
                        } else {
                            max = node.val;
                            break;
                        }
                    }
                }
            } while (true);
            result.add(List.of(min, max));
        }
        return result;
    }
}

class Solution2476_2 {
    // NOTE: 这个先按序排列，后二分，可以避免极端情况
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> arr = new ArrayList<Integer>();
        dfs(root, arr);

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int val : queries) {
            int maxVal = -1, minVal = -1;
            int idx = binarySearch(arr, val);
            if (idx != arr.size()) {
                maxVal = arr.get(idx);
                if (arr.get(idx) == val) {
                    minVal = val;
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(minVal);
                    list.add(maxVal);
                    res.add(list);
                    continue;
                }
            }
            if (idx > 0) {
                minVal = arr.get(idx - 1);
            }
            List<Integer> list2 = new ArrayList<Integer>();
            list2.add(minVal);
            list2.add(maxVal);
            res.add(list2);
        }
        return res;
    }

    public void dfs(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        dfs(root.left, arr);
        arr.add(root.val);
        dfs(root.right, arr);
    }

    public int binarySearch(List<Integer> arr, int target) {
        int low = 0, high = arr.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
