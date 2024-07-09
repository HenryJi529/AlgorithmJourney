import util.PrintUtil;

public class LeetCode168 {
    public static void main(String[] args) {
        // 输入：columnNumber = 1
        // 输出："A"
        System.out.println("A");
        System.out.println(new Solution168().convertToTitle(1));
        PrintUtil.printDivider();

        // 输入：columnNumber = 28
        // 输出："AB"
        System.out.println("AB");
        System.out.println(new Solution168().convertToTitle(28));
        PrintUtil.printDivider();

        // 输入：columnNumber = 701
        // 输出："ZY"
        System.out.println("ZY");
        System.out.println(new Solution168().convertToTitle(701));
        PrintUtil.printDivider();

        // 输入：columnNumber = 2147483647
        // 输出："FXSHRXW"
        System.out.println("FXSHRXW");
        System.out.println(new Solution168().convertToTitle(2147483647));
        PrintUtil.printDivider();

        // 输入：columnNumber = 52
        // 输出："AZ"
        System.out.println("AZ");
        System.out.println(new Solution168().convertToTitle(52));
        PrintUtil.printDivider();
    }
}

class Solution168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (true) {
            int i = columnNumber % 26 != 0 ? columnNumber % 26 : 26;
            sb.append(((char) ('A' + i - 1)));
            if (columnNumber <= 26) {
                break;
            }
            columnNumber = (columnNumber - i) / 26;
        }

        return sb.reverse().toString();
    }
}