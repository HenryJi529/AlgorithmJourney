import java.util.HashMap;

public class LeetCode5 {
    public static void main(String[] args) {
        String S1, S2;
        // 输入：s = "babad"
        // 输出："bab"
        S1 = "babad";
        System.out.println(S1);
        S2 = new Solution5_3().longestPalindrome(S1);
        System.out.println(S2);
        System.out.println("================================================================");

        // 输入：s = "cbbd"
        // 输出："bb"
        S1 = "cbbd";
        System.out.println(S1);
        S2 = new Solution5_3().longestPalindrome(S1);
        System.out.println(S2);
        System.out.println("================================================================");

        // 输入：s = "a"
        // 输出："a"
        S1 = "a";
        System.out.println(S1);
        S2 = new Solution5_3().longestPalindrome(S1);
        System.out.println(S2);
        System.out.println("================================================================");

        // 输入：s =
        // 输出：
        S1 = "twbiqwtafgjbtolwprpdnymaatlbuacrmzzwhkpvuwdtyfjsbsqxrlxxtqkjlpkvpxmlajdmnyepsmczmmfdtjfbyybotpoebilayqzvqztqgddpcgpelwmriwmoeeilpetbxoyktizwcqeeivzgxacuotnlzutdowiudwuqnghjgoeyojikjhlmcsrctvnahnoapmkcrqmwixpbtirkasbyajenknuccojooxfwdeflmxoueasvuovcayisflogtpxtbvcxfmydjupwihnxlpuxxcclbhvutvvshcaikuedhyuksbwwjsnssizoedjkbybwndxpkwcdxaexagazztuiuxphxcedqstahmevkwlayktrubjypzpaiwexkwbxcrqhkpqevhxbyipkmlqmmmogrnexsztsbkvebjgybrolttvnidnntpgvsawgaobycfaaviljsvyuaanguhohsepbthgjyqkicyaxkytshqmtxhilcjxdpcbmvnpippdrpggyohwyswuydyrhczlxyyzregpvxyfwpzvmjuukswcgpenygmnfwdlryobeginxwqjhxtmbpnccwdaylhvtkgjpeyydkxcqarkwvrmwbxeetmhyoudfuuwxcviabkqyhrvxbjmqcqgjjepmalyppymatylhdrazxytixtwwqqqlrcusxyxzymrnryyernrxbgrphsioxrxhmxwzsytmhnosnrpwtphaunprdtbpwapgjjqcnykgspjsxslxztfsuflijbeebwyyowjzpsbjcdabxmxhtweppffglvhfloprfavduzbgkw";
        System.out.println(S1);
        S2 = new Solution5_3().longestPalindrome(S1);
        System.out.println(S2);
        System.out.println("================================================================");
    }
}

class Solution5_1 {
    // NOTE: 时间复杂度还是高，根源在于搜索的顺序问题
    HashMap<String, Boolean> map = new HashMap<String, Boolean>();

    public boolean isPalindrome(String s, int start, int end) {
        if (map.containsKey(start + "-" + end)) {
            return map.get(start + "-" + end);
        }

        boolean res;
        if (s.charAt(start) == s.charAt(end)) {
            if (start + 1 == end || start + 2 == end) {
                res = true;
            } else {
                res = isPalindrome(s, start + 1, end - 1);
            }
        } else {
            res = false;
        }
        map.put(start + "-" + end, res);
        return res;
    }

    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int length = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (i + length >= s.length()) {
                // 不可能存在满足长度的回文子串
                continue;
            }
            for (int j = i + 1; j < s.length(); j++) {
                if (j - i + 1 <= length) {
                    continue;
                } else {
                    if (isPalindrome(s, i, j)) {
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
    // NOTE: 遍历节点(中心展开)
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

class Solution5_3 {
    String result = "";
    Boolean[][] memo;

    public String longestPalindrome(String s) {
        memo = new Boolean[s.length()][s.length()];
        dp(0, s.length() - 1, s);
        return this.result;
    }

    public boolean dp(int start, int end, String s) {
        // System.out.println(start + " " + end);
        if (memo[start][end] != null) {
            return memo[start][end];
        }

        boolean res = false;
        if (s.charAt(start) == s.charAt(end)) {
            if (start == end || start + 1 == end || start + 2 == end) {
                res = true;
            } else {
                if (dp(start + 1, end - 1, s)) {
                    res = true;
                } else {

                }
            }
        }
        memo[start][end] = res;
        if (res == false) {
            dp(start, end - 1, s);
            dp(start + 1, end, s);
        } else {
            if (end - start + 1 > this.result.length()) {
                this.result = s.substring(start, end + 1);
            }
        }
        return res;
    }
}

class Solution5_4 {
    // NOTE: 正向DP: 按照长度、开始点填表
}