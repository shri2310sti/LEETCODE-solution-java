class Solution {
    public int totalNQueens(int n) {
        return solveNQueens(n);
    }
    
    private int solveNQueens(int n) {
        int[] count = new int[1];
        char[][] board = new char[n][n];
        
        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        // Start the backtracking from the first column
        solve(count, board, 0);
        
        return count[0];
    }
    
    private void solve(int[] count, char[][] board, int col) {
        if (col == board.length) {
            count[0]++;
            return;
        }
        
        for (int row = 0; row < board.length; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                solve(count, board, col + 1);
                board[row][col] = '.';  // Backtrack
            }
        }
    }
    
    private boolean isSafe(char[][] board, int row, int col) {
        // Check row on left side
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }
        
        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        // Check lower diagonal on left side
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        return true;
    }
}
