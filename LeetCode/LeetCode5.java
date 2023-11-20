/* 
 * 问题描述: https://leetcode.cn/problems/longest-palindromic-substring/
 */

import java.util.HashMap;

public class LeetCode5 {
    public static void main(String[] args) {
        String S1, S2;
        // 输入：s = "babad"
        // 输出："bab"
        S1 = "babad";
        System.out.println(S1);
        S2 = new Solution5_2().longestPalindrome(S1);
        System.out.println(S2);
        System.out.println("================================================================");

        // 输入：s = "cbbd"
        // 输出："bb"
        S1 = "cbbd";
        System.out.println(S1);
        S2 = new Solution5_2().longestPalindrome(S1);
        System.out.println(S2);
        System.out.println("================================================================");

        // 输入：s = "a"
        // 输出："a"
        S1 = "a";
        System.out.println(S1);
        S2 = new Solution5_2().longestPalindrome(S1);
        System.out.println(S2);
        System.out.println("================================================================");

        // 输入：s =
        // 输出：
        S1 = "twbiqwtafgjbtolwprpdnymaatlbuacrmzzwhkpvuwdtyfjsbsqxrlxxtqkjlpkvpxmlajdmnyepsmczmmfdtjfbyybotpoebilayqzvqztqgddpcgpelwmriwmoeeilpetbxoyktizwcqeeivzgxacuotnlzutdowiudwuqnghjgoeyojikjhlmcsrctvnahnoapmkcrqmwixpbtirkasbyajenknuccojooxfwdeflmxoueasvuovcayisflogtpxtbvcxfmydjupwihnxlpuxxcclbhvutvvshcaikuedhyuksbwwjsnssizoedjkbybwndxpkwcdxaexagazztuiuxphxcedqstahmevkwlayktrubjypzpaiwexkwbxcrqhkpqevhxbyipkmlqmmmogrnexsztsbkvebjgybrolttvnidnntpgvsawgaobycfaaviljsvyuaanguhohsepbthgjyqkicyaxkytshqmtxhilcjxdpcbmvnpippdrpggyohwyswuydyrhczlxyyzregpvxyfwpzvmjuukswcgpenygmnfwdlryobeginxwqjhxtmbpnccwdaylhvtkgjpeyydkxcqarkwvrmwbxeetmhyoudfuuwxcviabkqyhrvxbjmqcqgjjepmalyppymatylhdrazxytixtwwqqqlrcusxyxzymrnryyernrxbgrphsioxrxhmxwzsytmhnosnrpwtphaunprdtbpwapgjjqcnykgspjsxslxztfsuflijbeebwyyowjzpsbjcdabxmxhtweppffglvhfloprfavduzbgkw";
        System.out.println(S1);
        S2 = new Solution5_2().longestPalindrome(S1);
        System.out.println(S2);
        System.out.println("================================================================");
    }
}

class Solution5_1 {
    // NOTE: 实际上还是不够快
    HashMap<String, Boolean> map = new HashMap<String, Boolean>();

    public boolean isPalindrome(String s, int start, int end) {
        if (map.containsKey(start + "-" + end)) {
            return map.get(start + "-" + end);
        }
        if (s.charAt(start) == s.charAt(end)) {
            if (start + 1 == end || start + 2 == end) {
                map.put(start + "-" + end, true);
                return true;
            } else {
                boolean result = isPalindrome(s, start + 1, end - 1);
                map.put(start + "-" + end, result);
                return result;
            }
        } else {
            map.put(start + "-" + end, false);
            return false;
        }
    }

    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int length = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.length() - i <= length) {
                continue;
            }
            for (int j = i + 1; j < s.length(); j++) {
                if (j - i + 1 <= length) {
                    continue;
                }
                if (isPalindrome(s, i, j)) {
                    if (j - i + 1 > length) {
                        start = i;
                        end = j;
                        length = j - i + 1;

                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}

class Solution5_2 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
}
