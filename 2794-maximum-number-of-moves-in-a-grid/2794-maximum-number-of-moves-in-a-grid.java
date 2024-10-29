class Solution {
    private int[][] directions = {{-1, 1}, {0, 1}, {1, 1}};
    private int[][] memo;
    
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        memo = new int[m][n];
        
        int maxMoves = 0;
        // Start DFS from each cell in the first column
        for (int row = 0; row < m; row++) {
            maxMoves = Math.max(maxMoves, dfs(grid, row, 0));
        }
        return maxMoves;
    }
    
    private int dfs(int[][] grid, int row, int col) {
        int m = grid.length, n = grid[0].length;
        
        // If already computed, return the memoized result
        if (memo[row][col] != 0) return memo[row][col];
        
        int maxMoveFromHere = 0;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            // Check if within bounds and if the move is valid
            if (newRow >= 0 && newRow < m && newCol < n && grid[newRow][newCol] > grid[row][col]) {
                maxMoveFromHere = Math.max(maxMoveFromHere, 1 + dfs(grid, newRow, newCol));
            }
        }
        
        memo[row][col] = maxMoveFromHere;
        return maxMoveFromHere;
    }
}
