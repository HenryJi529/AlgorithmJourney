import java.util.Deque;
import java.util.ArrayDeque;

public class LeetCode71 {
    public static void main(String[] args) {
        // 输入：path = "/home/"
        // 输出："/home"
        // 解释：注意，最后一个目录名后面没有斜杠。
        System.out.println(new Solution71().simplifyPath("/home/"));

        // 输入：path = "/../"
        // 输出："/"
        // 解释：从根目录向上一级是不可行的，因为根目录是你可以到达的最高级。
        System.out.println(new Solution71().simplifyPath("/../"));

        // 输入：path = "/home//foo/"
        // 输出："/home/foo"
        // 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
        System.out.println(new Solution71().simplifyPath("/home//foo/"));

        // 输入：path = "/a/./b/../../c/"
        // 输出："/c"
        // System.out.println(new Solution71().simplifyPath("/a/./b/../../c/"));

        // 输入：path = "/a/../../b/../c//.//"
        // 输出："/c"
        System.out.println(new Solution71().simplifyPath("/a/../../b/../c//.//"));

        // 输入：path = "/a//b////c/d//././/.."
        // 输出："/a/b/c"
        System.out.println(new Solution71().simplifyPath("/a//b////c/d//././/.."));

        // 输入：path = "/hello../world"
        // 输出："/hello../world"
        System.out.println(new Solution71().simplifyPath("/hello../world"));
    }
}

class Solution71 {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Deque<String> stack = new ArrayDeque<String>();
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (paths[i].equals(".") || paths[i].equals("")) {
            } else {
                stack.push(paths[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/");
            sb.append(stack.pollLast());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}