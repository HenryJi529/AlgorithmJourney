public class LeetCode1941 {
    public static void main(String[] args) {
        // 输入：s = "abacbc"
        // 输出：true
        System.out.println(new Solution1941().areOccurrencesEqual("abacbc"));

        // 输入：s = "aaabb"
        // 输出：false
        System.out.println(new Solution1941().areOccurrencesEqual("aaabb"));
    }
}

class Solution1941 {
    public boolean areOccurrencesEqual(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        // System.out.println(Arrays.toString(counts));
        int count = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                if (count == 0) {
                    count = counts[i];
                } else {
                    if (count != counts[i]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}