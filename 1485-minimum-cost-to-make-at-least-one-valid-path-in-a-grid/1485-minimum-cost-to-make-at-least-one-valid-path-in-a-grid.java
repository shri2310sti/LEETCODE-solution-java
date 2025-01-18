import java.util.*;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Directions: [1 → right, 2 → left, 3 → down, 4 → up]
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Deque<int[]> deque = new ArrayDeque<>();
        int[][] cost = new int[m][n];

        // Initialize cost array with a large value
        for (int[] row : cost) Arrays.fill(row, Integer.MAX_VALUE);
        cost[0][0] = 0;

        deque.offer(new int[]{0, 0}); // Start BFS from the top-left cell

        while (!deque.isEmpty()) {
            int[] cell = deque.poll();
            int x = cell[0], y = cell[1];

            for (int d = 0; d < 4; d++) {
                int newX = x + directions[d][0];
                int newY = y + directions[d][1];

                // Check if the new cell is within bounds
                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    // Calculate the new cost
                    int newCost = cost[x][y] + (grid[x][y] == d + 1 ? 0 : 1);

                    // If this path offers a lower cost, update and add to deque
                    if (newCost < cost[newX][newY]) {
                        cost[newX][newY] = newCost;
                        if (grid[x][y] == d + 1) {
                            deque.offerFirst(new int[]{newX, newY}); // Add to front if no cost
                        } else {
                            deque.offerLast(new int[]{newX, newY}); // Add to back if cost is 1
                        }
                    }
                }
            }
        }

        // Return the cost to reach the bottom-right corner
        return cost[m - 1][n - 1];
    }
}
