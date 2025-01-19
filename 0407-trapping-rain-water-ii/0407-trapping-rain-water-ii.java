import java.util.PriorityQueue;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height - b.height);
        
        // Add all boundary cells to the priority queue
        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }
        
        // Directions for moving in 4 possible ways (up, down, left, right)
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int trappedWater = 0;
        
        // Process cells in the priority queue
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            
            for (int[] dir : directions) {
                int x = cell.row + dir[0];
                int y = cell.col + dir[1];
                
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    // Calculate trapped water at this cell
                    trappedWater += Math.max(0, cell.height - heightMap[x][y]);
                    
                    // Update the height of the boundary
                    pq.offer(new Cell(x, y, Math.max(cell.height, heightMap[x][y])));
                    visited[x][y] = true;
                }
            }
        }
        
        return trappedWater;
    }
    
    // Helper class to represent a cell in the heightMap
    static class Cell {
        int row, col, height;
        
        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}
