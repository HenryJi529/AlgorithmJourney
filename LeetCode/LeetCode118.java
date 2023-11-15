/* 
 * 问题描述: https://leetcode.cn/problems/pascals-triangle/description/
 */

import util.PrintUtil;

import java.util.List;
import java.util.ArrayList;

public class LeetCode118 {
    public static void main(String[] args) {
        List<List<Integer>> nestedList;
        // 输入: numRows = 5
        // 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        nestedList = new Solution().generate(5);
        PrintUtil.printNestedArray(nestedList);
        // 输入: numRows = 1
        // 输出: [[1]]
        nestedList = new Solution().generate(1);
        PrintUtil.printNestedArray(nestedList);
    }
}

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> nestedList = new ArrayList<List<Integer>>();
        List<Integer> row;
        for (int i = 0; i < numRows; i++) {
            row = new ArrayList<Integer>();
            if (i == 0) {
                row.add(1);
            } else {
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0 || j == i) {
                        row.add(1);
                    } else {
                        row.add(nestedList.get(i - 1).get(j - 1) + nestedList.get(i - 1).get(j));
                    }
                }
            }
            nestedList.add(row);
        }
        return nestedList;
    }
}