import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

import util.PrintUtil;

public class LeetCode332 {
    public static void main(String[] args) {
        List<List<String>> tickets;
        // 输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
        // 输出：["JFK","MUC","LHR","SFO","SJC"]
        tickets = new ArrayList<List<String>>();
        for (String[] ticket : new String[][] { { "MUC", "LHR" }, { "JFK", "MUC" }, { "SFO", "SJC" },
                { "LHR", "SFO" } }) {
            tickets.add(List.of(ticket[0], ticket[1]));
        }
        System.out.println(Arrays.deepToString(tickets.toArray()));
        System.out.println(new Solution332().findItinerary(tickets));
        PrintUtil.printDivider();

        // 输入：tickets =
        // [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        // 输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
        tickets = new ArrayList<List<String>>();
        for (String[] ticket : new String[][] { { "JFK", "SFO" }, { "JFK", "ATL" }, { "SFO", "ATL" }, { "ATL", "JFK" },
                { "ATL", "SFO" } }) {
            tickets.add(List.of(ticket));
        }
        System.out.println(Arrays.deepToString(tickets.toArray()));
        System.out.println(new Solution332().findItinerary(tickets));
        PrintUtil.printDivider();
    }
}

class Solution332 {
    HashMap<String, PriorityQueue<String>> graph;
    HashSet<String> visited = new HashSet<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        graph = buildGraph(tickets);
        List<String> res = new ArrayList<String>();

        dfs("JFK", res);

        for (int i = 0; i <= (res.size() - 1) / 2; i++) {
            String temp = res.get(i);
            res.set(i, res.get(res.size() - 1 - i));
            res.set(res.size() - 1 - i, temp);
        }
        return res;
    }

    public void dfs(String current, List<String> res) {
        if (graph.containsKey(current)) {
            PriorityQueue<String> pq = graph.get(current);
            while (pq.size() > 0) {
                String next = pq.poll();
                dfs(next, res);
            }
        }
        visited.add(current);
        res.add(current);
    }

    public HashMap<String, PriorityQueue<String>> buildGraph(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> graph = new HashMap<String, PriorityQueue<String>>();
        for (List<String> ticket : tickets) {
            if (!graph.containsKey(ticket.get(0))) {
                graph.put(ticket.get(0), new PriorityQueue<String>());
            }
            graph.get(ticket.get(0)).offer(ticket.get(1));
        }
        return graph;
    }
}