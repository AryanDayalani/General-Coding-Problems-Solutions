// Java implementation of BFS algorithm using Queue

import java.util.*;

public class BFS {
    public static void bfs(int start, List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];  // Maintain a visited array for keeping a track of visited nodes 
        Queue<Integer> q = new LinkedList<>();  // Queue needed to implement BFS

        visited[start] = true; // we always start by visiting start node
        q.add(start);   // main logic to follow - to explore a node, first mark it as visited and then add to queue


        while (!q.isEmpty()) {
            int node = q.poll(); // Pop the element from front
            System.out.println(node + " "); // Print the element

            for (int neighbour : graph.get(node)) {     // Check if every neighbour is explored
                if (!visited[neighbour]) {
                    visited[neighbour] = true;          // if not, visit and add to queue
                    q.add(neighbour);
                }
            }
        }
    }

    // Main code 
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            graph.add(new ArrayList<>());

        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(4);

        bfs(0, graph);
    }
}
