import java.util.HashSet;
import java.util.List;

public class LeetCode345 {
    public static void main(String[] args) {
        // 输入：s = "hello"
        // 输出："holle"
        System.out.println(new Solution345().reverseVowels("hello"));

        // 输入：s = "leetcode"
        // 输出："leotcede"
        System.out.println(new Solution345().reverseVowels("leetcode"));
    }
}

class Solution345 {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        HashSet<Character> set = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int p1 = 0;
        int p2 = s.length() - 1;
        while (p1 < p2) {
            while (p1 < p2 && !set.contains(str[p1])) {
                p1++;
            }
            while (p2 > p1 && !set.contains(str[p2])) {
                p2--;
            }
            if (p1 >= p2) {
                break;
            }
            // System.out.println(p1 + " " + p2);
            swap(str, p1, p2);
            p1++;
            p2--;
        }
        return new String(str);
    }

    public void swap(char[] str, int p1, int p2) {
        char c = str[p1];
        str[p1] = str[p2];
        str[p2] = c;
    }
}