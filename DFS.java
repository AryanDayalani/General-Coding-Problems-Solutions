// Java implementation of DFS using recursion

import java.util.*;

public class DFS {
    public static void dfs(int node, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true; // Visit a node
        System.out.print(node + " "); // Print it out

        for (int neighbour : graph.get(node)) { // For every neighbour, if it is unvisited, recursiely DFS on it
            if (!visited[neighbour]) {
                dfs(neighbour, visited, graph);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(4);

        boolean[] visited = new boolean[5];
        dfs(0, visited, graph);
    }
}
