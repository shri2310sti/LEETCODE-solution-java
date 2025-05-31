import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] flattened = new int[n * n + 1]; // 1-based indexing

        // Flatten the board
        int index = 1;
        boolean leftToRight = true;
        for (int r = n - 1; r >= 0; r--) {
            if (leftToRight) {
                for (int c = 0; c < n; c++) {
                    flattened[index++] = board[r][c];
                }
            } else {
                for (int c = n - 1; c >= 0; c--) {
                    flattened[index++] = board[r][c];
                }
            }
            leftToRight = !leftToRight;
        }

        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // start at square 1
        visited[1] = true;

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n * n) return moves; // reached final square

                for (int next = curr + 1; next <= Math.min(curr + 6, n * n); next++) {
                    int dest = flattened[next] == -1 ? next : flattened[next];
                    if (!visited[dest]) {
                        visited[dest] = true;
                        queue.offer(dest);
                    }
                }
            }
            moves++;
        }

        return -1; // unreachable
    }
}
