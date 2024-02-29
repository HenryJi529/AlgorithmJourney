import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode49 {
    public static void main(String[] args) {
        // 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
        // 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
        System.out.println(new Solution49_2().groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));

        // 输入: strs = [""]
        // 输出: [[""]]
        System.out.println(new Solution49_2().groupAnagrams(new String[] { "" }));

        // 输入: strs = ["a"]
        // 输出: [["a"]]
        System.out.println(new Solution49_2().groupAnagrams(new String[] { "a" }));
    }
}

class Solution49_1 {
    // 暴力计算，也能PASS
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        for (String str : strs) {
            boolean flag = false;
            for (List<String> anagrams : result) {
                if (isAnagram(anagrams.get(0), str)) {
                    anagrams.add(str);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                result.add(new ArrayList<String>(List.of(str)));
            }
        }
        return result;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            counts[t.charAt(i) - 'a']--;
            if (counts[t.charAt(i) - 'a'] == -1) {
                return false;
            }
        }
        return true;
    }
}

class Solution49_2 {
    // 对string构成的char[]排序
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

class Solution49_3 {
    // 用counts作为HashMap的Key
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
