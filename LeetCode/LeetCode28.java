public class LeetCode28 {
    public static void main(String[] args) {
        // 输入：haystack = "sadbutsad", needle = "sad"
        // 输出：0
        System.out.println(new Solution28().strStr("sadbutsad", "sad"));

        // 输入：haystack = "leetcode", needle = "leeto"
        // 输出：-1
        System.out.println(new Solution28().strStr("leetcode", "leeto"));

        // 输入：haystack = "hello", needle = "ll"
        // 输出：2
        System.out.println(new Solution28().strStr("hello", "ll"));

        // 输入：haystack = "mississippi", needle = "issip"
        // 输出：4
        System.out.println(new Solution28().strStr("mississippi", "issip"));

    }
}

class Solution28 {
    public int strStr(String haystack, String needle) {
        int[] nextArray = getNextArray(needle);
        // System.out.println(Arrays.toString(nextArray));
        int index = 0;
        int j = 0;
        while (index < haystack.length()) {
            if (haystack.charAt(index) == needle.charAt(j)) {
                index++;
                j++;
                if (j == needle.length()) {
                    return index - needle.length();
                }
            } else {
                if (j == 0) {
                    index++;
                } else {
                    j = nextArray[j - 1];
                }
            }
        }
        return -1;
    }

    private int[] getNextArray(String needle) {
        int[] nextArray = new int[needle.length()];
        for (int i = 1; i < nextArray.length; i++) {
            int index = i - 1;
            char c = needle.charAt(i);
            while (true) {
                if (needle.charAt(nextArray[index]) == c) {
                    nextArray[i] = nextArray[index] + 1;
                    break;
                } else {
                    index = nextArray[index] - 1;
                    if (index <= 0) {
                        nextArray[i] = c == needle.charAt(0) ? 1 : 0;
                        break;
                    }
                }
            }

        }
        return nextArray;
    }
}