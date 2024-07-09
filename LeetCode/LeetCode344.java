import java.util.Arrays;

import util.PrintUtil;

public class LeetCode344 {
    public static void main(String[] args) {
        char[] s;
        // 输入：s = ["h","e","l","l","o"]
        // 输出：["o","l","l","e","h"]
        s = new char[] { 'h', 'e', 'l', 'l', 'o' };
        System.out.println(Arrays.toString(s));
        new Solution344().reverseString(s);
        System.out.println(Arrays.toString(s));
        PrintUtil.printDivider();

        // 输入：s = ["H","a","n","n","a","h"]
        // 输出：["h","a","n","n","a","H"]
        s = new char[] { 'H', 'a', 'n', 'n', 'a', 'h' };
        System.out.println(Arrays.toString(s));
        new Solution344().reverseString(s);
        System.out.println(Arrays.toString(s));
        PrintUtil.printDivider();
    }
}

class Solution344 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        char temp;
        while (left < right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}