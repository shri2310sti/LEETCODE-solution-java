import java.util.*;

class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] cost = new int[m][n];
        for (int[] row : cost) Arrays.fill(row, Integer.MAX_VALUE);
        cost[0][0] = 0;

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0}); // {row, col}

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int x = current[0], y = current[1];

            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    int newCost = cost[x][y] + grid[nx][ny];
                    if (newCost < cost[nx][ny]) {
                        cost[nx][ny] = newCost;
                        if (grid[nx][ny] == 0) {
                            deque.addFirst(new int[]{nx, ny}); // Priority: move to empty cells first
                        } else {
                            deque.addLast(new int[]{nx, ny}); // Move to obstacle cells later
                        }
                    }
                }
            }
        }

        return cost[m - 1][n - 1];
    }
}
