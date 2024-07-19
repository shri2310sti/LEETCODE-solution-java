import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Step 1: Find the minimum values in each row
        for (int i = 0; i < rows; i++) {
            int minValue = matrix[i][0];
            int minColIndex = 0;
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] < minValue) {
                    minValue = matrix[i][j];
                    minColIndex = j;
                }
            }
            
            // Step 2: Check if this minimum value is the maximum in its column
            boolean isMaxInColumn = true;
            for (int k = 0; k < rows; k++) {
                if (matrix[k][minColIndex] > minValue) {
                    isMaxInColumn = false;
                    break;
                }
            }
            
            // Step 3: If it is, add it to the result list
            if (isMaxInColumn) {
                luckyNumbers.add(minValue);
            }
        }
        
        return luckyNumbers;
    }
}
