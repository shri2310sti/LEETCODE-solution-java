import java.util.HashMap;

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        // Map each number in the matrix to its (row, col) position
        HashMap<Integer, int[]> positionMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                positionMap.put(mat[i][j], new int[]{i, j});
            }
        }
        
        // Track the painted cells in each row and column
        int[] rowPaintCount = new int[m];
        int[] colPaintCount = new int[n];
        
        // Iterate through arr and simulate the painting process
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int[] position = positionMap.get(num);
            int row = position[0];
            int col = position[1];
            
            // Paint the cell by updating the row and column counts
            rowPaintCount[row]++;
            colPaintCount[col]++;
            
            // Check if the current row or column is fully painted
            if (rowPaintCount[row] == n || colPaintCount[col] == m) {
                return i;
            }
        }
        
        // If no row or column is completely painted, return -1 (should not happen with given constraints)
        return -1;
    }
}
