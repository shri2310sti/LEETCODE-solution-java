class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxFish = 0;

        // Iterate over all cells in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Start a DFS if the cell contains water and has not been visited
                if (grid[i][j] > 0 && !visited[i][j]) {
                    maxFish = Math.max(maxFish, dfs(grid, visited, i, j));
                }
            }
        }

        return maxFish;
    }

    // Helper method for DFS traversal
    private int dfs(int[][] grid, boolean[][] visited, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;

        // If the cell is out of bounds, is land (0), or already visited, return 0
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0 || visited[r][c]) {
            return 0;
        }

        // Mark the cell as visited
        visited[r][c] = true;

        // Initialize the total fish count with the current cell's value
        int totalFish = grid[r][c];

        // Explore all adjacent cells
        totalFish += dfs(grid, visited, r + 1, c); // Down
        totalFish += dfs(grid, visited, r - 1, c); // Up
        totalFish += dfs(grid, visited, r, c + 1); // Right
        totalFish += dfs(grid, visited, r, c - 1); // Left

        return totalFish;
    }
}
