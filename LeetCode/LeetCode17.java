import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode17 {
    public static void main(String[] args) {
        // 输入：digits = "23"
        // 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(Arrays.toString(new Solution17().letterCombinations("23").toArray()));

        // 输入：digits = ""
        // 输出：[]
        System.out.println(Arrays.toString(new Solution17().letterCombinations("").toArray()));

        // 输入：digits = "2"
        // 输出：["a","b","c"]
        System.out.println(Arrays.toString(new Solution17().letterCombinations("2").toArray()));

    }
}

class Solution17 {
    @SuppressWarnings("unchecked")
    List<Character>[] map = new ArrayList[10];
    {
        map[2] = new ArrayList<Character>(List.of('a', 'b', 'c'));
        map[3] = new ArrayList<Character>(List.of('d', 'e', 'f'));
        map[4] = new ArrayList<Character>(List.of('g', 'h', 'i'));
        map[5] = new ArrayList<Character>(List.of('j', 'k', 'l'));
        map[6] = new ArrayList<Character>(List.of('m', 'n', 'o'));
        map[7] = new ArrayList<Character>(List.of('p', 'q', 'r', 's'));
        map[8] = new ArrayList<Character>(List.of('t', 'u', 'v'));
        map[9] = new ArrayList<Character>(List.of('w', 'x', 'y', 'z'));
    }

    List<String> solutions = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return solutions;
        }
        dfs(digits, 0, new StringBuilder());
        return solutions;
    }

    public void dfs(String digits, int ind, StringBuilder solution) {
        if (ind == digits.length()) {
            solutions.add(solution.toString());
            return;
        }
        for (Character c : map[digits.charAt(ind) - '0']) {
            solution.append(c);
            dfs(digits, ind + 1, solution);
            solution.deleteCharAt(solution.length() - 1);
        }
    }
}