class Solution {
    private static final int[] DIRS = {-1, 0, 1, 0, -1};
    
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int maxIsland = 0;
        int islandId = 2; // Start island IDs from 2
        Map<Integer, Integer> islandSizes = new HashMap<>();
        
        // Step 1: Identify islands and store their sizes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, islandId);
                    islandSizes.put(islandId, size);
                    maxIsland = Math.max(maxIsland, size);
                    islandId++;
                }
            }
        }
        
        // Step 2: Check all 0s and try converting them to 1 to find the largest island
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> connectedIslands = new HashSet<>();
                    for (int d = 0; d < 4; d++) {
                        int ni = i + DIRS[d], nj = j + DIRS[d + 1];
                        if (ni >= 0 && nj >= 0 && ni < n && nj < n && grid[ni][nj] > 1) {
                            connectedIslands.add(grid[ni][nj]);
                        }
                    }
                    
                    int newSize = 1; // Include the changed cell
                    for (int id : connectedIslands) {
                        newSize += islandSizes.get(id);
                    }
                    maxIsland = Math.max(maxIsland, newSize);
                }
            }
        }
        
        return maxIsland;
    }
    
    private int dfs(int[][] grid, int i, int j, int id) {
        int n = grid.length;
        if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] != 1) return 0;
        
        grid[i][j] = id;
        int size = 1;
        
        for (int d = 0; d < 4; d++) {
            size += dfs(grid, i + DIRS[d], j + DIRS[d + 1], id);
        }
        
        return size;
    }
}
