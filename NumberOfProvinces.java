// Leetcode problem 547 that finds the number of provinces (group of directly/indirectly connected cities)


class FindProvince {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int provinces = 0;

        for (int i = 0; i<isConnected.length; i++) {
            if(!visited[i]) {
                provinces++;
                dfs(i, visited, isConnected);
            }
        }

        return provinces;
    }

    public void dfs(int node, boolean[] visited, int[][] graph) {
        visited[node] = true;
        for (int neighbour = 0; neighbour < graph.length; neighbour++) {
            if (!visited[neighbour] && graph[node][neighbour] == 1) {
                dfs(neighbour, visited, graph);
            }
        }
    }
}

public class NumberOfProvinces {

    public static void main(String[] args) {
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        FindProvince solution = new FindProvince();
        int result = solution.findCircleNum(isConnected);
        System.out.println("Number of provinces: " + result);
    }
}