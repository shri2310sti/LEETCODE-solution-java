class Solution {
    
    // Function to check if the grid is disconnected
    public int minDays(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // Check if the grid is already disconnected
        if (countIslands(grid) != 1) return 0;
        
        // Try removing each land cell and check if it disconnects the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0; // Temporarily remove land cell
                    if (countIslands(grid) != 1) return 1;
                    grid[i][j] = 1; // Restore the land cell
                }
            }
        }
        
        // If we cannot disconnect the grid by removing one cell, return 2
        return 2;
    }
    
    // Function to count the number of islands in the grid
    private int countIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int islands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    islands++;
                    dfs(grid, visited, i, j);
                }
            }
        }

        return islands;
    }
    
    // DFS to explore the grid and mark visited cells
    private void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length, n = grid[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i, j - 1);
    }
}
