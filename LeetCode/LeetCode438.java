import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class LeetCode438 {
    public static void main(String[] args) {
        // 输入: s = "cbaebabacd", p = "abc"
        // 输出: [0,6]
        System.out.println(Arrays.toString((new Solution438_1().findAnagrams("cbaebabacd", "abc")).toArray()));

        // 输入: s = "abab", p = "ab"
        // 输出: [0,1,2]
        System.out.println(Arrays.toString((new Solution438_1().findAnagrams("abab", "ab")).toArray()));
    }
}

/**
 * 使用一个数组作滑动窗口记录字符数，一个集合记录存在问题的字符位置(用来避免逐个对比)
 */
class Solution438_1 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<Integer>();
        int[] counts = new int[26]; // 记录需要处理的各字符数量
        HashSet<Integer> toFixed = new HashSet<Integer>(); // 记录存在问题的字符数
        // 初始化counts
        for (int i = 0; i < p.length(); i++) {
            counts[p.charAt(i) - 'a']++;
        }
        // 更新counts状态到第一次长度满足要求
        for (int i = 0; i < p.length(); i++) {
            counts[s.charAt(i) - 'a']--;
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                toFixed.add(i);
            }
        }
        if (toFixed.size() == 0) {
            // 判断是否直接满足要求
            result.add(0);
        }
        for (int i = p.length(); i < s.length(); i++) {
            counts[s.charAt(i) - 'a']--;
            counts[s.charAt(i - p.length()) - 'a']++;
            if (counts[s.charAt(i) - 'a'] == 0 && toFixed.contains(s.charAt(i) - 'a')) {
                toFixed.remove(s.charAt(i) - 'a');
            } else {
                toFixed.add(s.charAt(i) - 'a');
            }
            if (counts[s.charAt(i - p.length()) - 'a'] == 0 && toFixed.contains(s.charAt(i - p.length()) - 'a')) {
                toFixed.remove(s.charAt(i - p.length()) - 'a');
            } else {
                toFixed.add(s.charAt(i - p.length()) - 'a');
            }
            if (toFixed.size() == 0) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}

/**
 * 直接使用两个滑动数组，通过逐个对比确定结果
 */
class Solution438_2 {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        List<Integer> ans = new ArrayList<Integer>();

        if (sLen < pLen) {
            return ans;
        }

        // 分别记录数组p和滑动窗口中各个字母出现的次数
        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        // 窗口开始滑动
        for (int i = 0; i < sLen - pLen; i++) {
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + pLen) - 'a']++;

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}