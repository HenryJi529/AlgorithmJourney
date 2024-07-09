import java.util.LinkedList;

import util.PrintUtil;

public class LeetCode67 {
    public static void main(String[] args) {
        String a;
        String b;
        // 输入:a = "11", b = "1"
        // 输出："100"
        a = "11";
        b = "1";
        System.out.println(a + " " + b);
        System.out.println(new Solution67_2().addBinary(a, b));
        PrintUtil.printDivider();

        // 输入：a = "1010", b = "1011"
        // 输出："10101"
        a = "1010";
        b = "1011";
        System.out.println(a + " " + b);
        System.out.println(new Solution67_2().addBinary(a, b));
        PrintUtil.printDivider();
    }
}

class Solution67_1 {
    // NOTE: 这个版本过于复杂，其实可以同时使用i和j来索引
    public String addBinary(String a, String b) {
        boolean carry = false;
        LinkedList<Character> list = new LinkedList<Character>();
        StringBuilder sb = new StringBuilder();
        int length1 = a.length();
        int length2 = b.length();
        for (int i = Math.max(length1, length2) - 1; i >= 0; i--) {
            char s1, s2;
            // 先获得每个索引对应的字符，长度不够默认为'0'
            if (length1 == length2) {
                s1 = a.charAt(i);
                s2 = b.charAt(i);
            } else if (length1 < length2) {
                if (i - (length2 - length1) >= 0) {
                    s1 = a.charAt(i - (length2 - length1));
                    s2 = b.charAt(i);
                } else {
                    s1 = '0';
                    s2 = b.charAt(i);
                }
            } else {
                if (i - (length1 - length2) >= 0) {
                    s1 = a.charAt(i);
                    s2 = b.charAt(i - (length1 - length2));
                } else {
                    s1 = a.charAt(i);
                    s2 = '0';
                }
            }
            // System.out.println(String.format("s1: %c s2: %c carry: %b", s1, s2, carry));

            if (carry) {
                if (s1 == '0' && s2 == '0') {
                    list.addFirst('1');
                    carry = false;
                } else if (s1 == '1' && s2 == '1') {
                    list.addFirst('1');
                    carry = true;
                } else {
                    list.addFirst('0');
                    carry = true;
                }
            } else {
                if (s1 == '0' && s2 == '0') {
                    list.addFirst('0');
                    carry = false;
                } else if (s1 == '1' && s2 == '1') {
                    list.addFirst('0');
                    carry = true;
                } else {
                    list.addFirst('1');
                    carry = false;
                }
            }
        }

        if (carry) {
            list.addFirst('1');
        }
        for (Character c : list) {
            sb.append(c);
        }
        // NOTE: 也可以直接使用sb的reverse()函数

        return sb.toString();
    }
}

class Solution67_2 {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int c1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int c2 = j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append((c1 + c2 + carry) % 2);
            carry = (c1 + c2 + carry) / 2;
        }
        ans.append(carry == 1 ? '1' : "");
        return ans.reverse().toString();
    }
}
