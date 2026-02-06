// Java implementation to count number of islands in a 2D grid

class IslandCounter {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int count_islands = 0;

        // for each element in grid, first find a '1'
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    count_islands++;    // if found, we increment the island count
                    dfs(grid, i, j);     // we recursively go to all it neighbouring land pieces and mark them '0' so that they act as water and do not get counted the next time we find another piece of separate land (new piece of land is new i,j such that grid[i][j] == '1')
                }
            }
        }
        return count_islands;
    }

    public void dfs(char[][]grid, int r, int c) {
        // for out of bounds indices, we return and find next land mass using the parent for loop
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != '1') {
            return;
        }
        grid[r][c] = '0';  // mark as water
        dfs(grid, r+1, c);  // search in all 4 directions
        dfs(grid, r-1, c);
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
    }
}

public class NumberOfIslands {
    public static void main(String[] args) {
        IslandCounter counter = new IslandCounter();
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        int result = counter.numIslands(grid);
        System.out.println("Number of islands: " + result); // Output: 3
    }
}
