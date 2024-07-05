import util.PrintUtil;

import java.util.List;
import java.util.ArrayList;

public class LeetCode51 {
    public static void main(String[] args) {
        // 输入：n = 4
        // 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
        PrintUtil.printNestedList(new Solution51().solveNQueens(4));

        // 输入：n = 1
        // 输出：[["Q"]]
        PrintUtil.printNestedList(new Solution51().solveNQueens(1));
    }
}

class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> solutions = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        boolean[] remain = new boolean[n];
        for (int i = 0; i < n; i++) {
            remain[i] = true;
        }
        dfs(solution, remain, solutions, n);
        return render(solutions);
    }

    public void dfs(List<Integer> solution, boolean[] remain, List<List<Integer>> solutions, int n) {
        if (solution.size() == n) {
            solutions.add(new ArrayList<>(solution));
        } else {
            for (int pos = 0; pos < n; pos++) {
                if (remain[pos]) {
                    if (suit(pos, solution)) {
                        remain[pos] = false;
                        solution.add(pos);
                        dfs(solution, remain, solutions, n);
                        solution.removeLast();
                        remain[pos] = true;
                    }
                }
            }
        }
    }

    public boolean suit(int pos, List<Integer> solution) {
        for (int x = 0; x < solution.size(); x++) {
            int y = solution.get(x);
            if (Math.abs(x - solution.size()) == Math.abs(y - pos)) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> render(List<List<Integer>> solutions) {
        List<List<String>> renderedSolutions = new ArrayList<List<String>>();
        for (List<Integer> solution : solutions) {
            List<String> renderedSolution = new ArrayList<String>();
            for (int i = 0; i < solution.size(); i++) {
                renderedSolution.add(getRow(solution.get(i), solution.size()));
            }
            renderedSolutions.add(renderedSolution);
        }
        return renderedSolutions;
    }

    public String getRow(int ind, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == ind) {
                sb.append('Q');
            } else {
                sb.append('.');
            }
        }
        return sb.toString();
    }
}