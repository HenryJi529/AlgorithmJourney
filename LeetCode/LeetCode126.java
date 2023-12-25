import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;

public class LeetCode126 {
    public static void main(String[] args) {
        // 输入：beginWord = "hit", endWord = "cog", wordList =
        // ["hot","dot","dog","lot","log","cog"]
        // 输出：[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
        System.out.println(new Solution126().findLadders("hit", "cog",
                new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log",
                        "cog"))));

        // 输入：beginWord = "hit", endWord = "cog", wordList =
        // ["hot","dot","dog","lot","log"]
        // 输出：[]
        System.out.println(new Solution126().findLadders("hit", "cog",
                new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log"))));

        // 输入：beginWord = "red", endWord = "tax", wordList =
        // ["ted","tex","red","tax","tad","den","rex","pee"]
        // 输出：[]
        System.out.println(new Solution126().findLadders("red", "tax",
                new ArrayList<String>(Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee"))));
    }
}

class Solution126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return new LinkedList<List<String>>();
        }
        HashMap<String, List<String>> graph = buildGraph(beginWord, wordList);
        HashMap<String, List<String>> records = new HashMap<String, List<String>>();
        HashSet<String> ended = new HashSet<String>();
        HashSet<String> started = new HashSet<String>();
        ended.add(beginWord);
        for (String word : wordList) {
            records.put(word, new ArrayList<String>());
        }
        records.put(beginWord, new ArrayList<String>());
        records.get(beginWord).add(beginWord);
        LinkedList<Edge> queue = new LinkedList<Edge>();
        for (String word : graph.get(beginWord)) {
            queue.offer(new Edge(beginWord, word));
        }
        started.add(beginWord);

        boolean ignore = false;
        int length = 1;
        while (queue.size() > 0) {
            if (ignore) {
                break;
            }
            length++;
            int size = queue.size();
            for (Edge edge : queue) {
                if (!ended.contains(edge.to)) {
                    ended.add(edge.to);
                }
            }
            for (int i = 0; i < size; i++) {
                Edge curEdge = queue.poll();
                String fromWord = curEdge.from;
                String toWord = curEdge.to;
                records.get(toWord).add(fromWord);
                if (toWord.equals(endWord)) {
                    ignore = true;
                }
                if (ignore) {
                    continue;
                }
                if (!started.contains(toWord)) {
                    for (String nextWord : graph.get(toWord)) {
                        if (!ended.contains(nextWord)) {
                            queue.add(new Edge(toWord, nextWord));
                        }
                    }
                    started.add(toWord);
                }
            }
        }
        // System.out.println(records);
        // System.out.println(length);
        if (records.get(endWord).isEmpty()) {
            return new LinkedList<List<String>>();
        } else {
            // NOTE: 其实这里用DFS来做更直观
            return buildPaths(records, length, beginWord, endWord);
        }
    }

    class Edge {
        String from;
        String to;

        Edge(String from, String to) {
            this.from = from;
            this.to = to;
        }

        public String toString() {
            return from + "->" + to;
        }
    }

    public HashMap<String, List<String>> buildGraph(String beginWord, List<String> wordList) {
        HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
        for (String word : wordList) {
            graph.put(word, new ArrayList<String>());
        }
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (similar(wordList.get(i), wordList.get(j))) {
                    graph.get(wordList.get(i)).add(wordList.get(j));
                    graph.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }
        graph.put(beginWord, new ArrayList<String>());
        for (String word : wordList) {
            if (similar(beginWord, word)) {
                graph.get(beginWord).add(word);
                graph.get(word).add(beginWord);
            }
        }
        return graph;
    }

    public boolean similar(String str1, String str2) {
        int length = str1.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                count++;
            }
        }
        return count == length - 1;
    }

    public List<List<String>> buildPaths(HashMap<String, List<String>> records, int length, String beginWord,
            String endWord) {
        List<String[]> pathArray = new ArrayList<>();
        pathArray.add(new String[length]);
        pathArray.get(0)[length - 1] = endWord;
        int i = 0;
        while (i < length) {
            int pathNum = pathArray.size();
            for (int j = 0; j < pathNum; j++) {
                String[] currentPath = pathArray.get(j);
                String currentString = currentPath[length - 1 - i];
                if (currentString.equals(beginWord)) {
                    break;
                }
                List<String> record = records.get(currentString);
                int currentSize = record.size();
                if (currentSize > 1) {
                    for (int k = 1; k < currentSize; k++) {
                        String[] newPath = Arrays.copyOf(currentPath, length);
                        newPath[length - 2 - i] = record.get(k);
                        pathArray.add(newPath);
                    }
                    currentPath[length - 2 - i] = record.get(0);
                } else {
                    currentPath[length - 2 - i] = record.get(0);
                }
            }
            i++;
        }

        List<List<String>> pathList = new ArrayList<>();

        for (String[] array : pathArray) {
            List<String> innerList = new ArrayList<>();
            for (String element : array) {
                innerList.add(element);
            }
            pathList.add(innerList);
        }

        return pathList;
    }
}