/* 
 * 问题描述: https://leetcode.cn/problems/restore-ip-addresses/
 */

import java.util.ArrayList;
import java.util.List;

public class LeetCode93 {
    public static void main(String[] args) {
        // 输入：s = "25525511135"
        // 输出：["255.255.11.135","255.255.111.35"]
        System.out.println(new Solution().restoreIpAddresses("25525511135"));

        // 输入：s = "0000"
        // 输出：["0.0.0.0"]
        System.out.println(new Solution().restoreIpAddresses("0000"));

        // 输入：s = "101023"
        // 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
        System.out.println(new Solution().restoreIpAddresses("101023"));
    }
}

class Solution {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> list = new ArrayList<String>();
        int N = s.length();
        if (N < 4) {
            return list;
        }

        for (int loc1 = 0; loc1 <= Math.min(2, N - 4); loc1++) {
            if (!isValid(s, -1, loc1)) {
                continue;
            }
            for (int loc2 = loc1 + 1; loc2 <= Math.min(5, N - 3); loc2++) {
                if (!isValid(s, loc1, loc2)) {
                    continue;
                }
                for (int loc3 = loc2 + 1; loc3 <= Math.min(8, N - 2); loc3++) {
                    if (!isValid(s, loc2, loc3)) {
                        continue;
                    }
                    if (!isValid(s, loc3, N - 1)) {
                        continue;
                    }
                    list.add(getIP(s, loc1, loc2, loc3));
                }
            }

        }

        return list;
    }

    private String getIP(String s, int loc1, int loc2, int loc3) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (i == loc1 || i == loc2 || i == loc3) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    private boolean isValid(String s, int start, int end) {
        int length = end - start;
        if (length > 1 && s.charAt(start + 1) == '0') {
            return false;
        }
        if (length > 0 && length < 3) {
            return true;
        } else if (length == 3) {
            char firstChar = s.charAt(start + 1);
            char secondChar = s.charAt(start + 2);
            char thirdChar = s.charAt(start + 3);

            if (firstChar < '2') {
                return true;
            } else if (firstChar > '2') {
                return false;
            } else {
                if (secondChar < '5') {
                    return true;
                } else if (secondChar > '5') {
                    return false;
                } else {
                    if (thirdChar <= '5') {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
    }
}