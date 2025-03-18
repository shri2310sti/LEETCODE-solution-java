class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int marker = Integer.MIN_VALUE -10; 


        for(int i = 0; i<m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    setMatrix(matrix, i, j, m, n, marker);
                }
            }
        }
        for(int i = 0; i<m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == marker){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // public void setMatrix(int[][] matrix, int i1, int j2, int m, int n, int marker){
    //     for(int i = 0; i < n; i++){
    //         matrix[i1][i] = marker;
    //     }
    //     for(int i = 0; i < m; i++){
    //         matrix[i][j2] = marker;
    //     }
    // }

    public void setMatrix(int[][] matrix, int row, int col, int m, int n, int marker) {
        // Mark entire row
        for (int j = 0; j < n; j++) {
            if (matrix[row][j] != 0) { 
                matrix[row][j] = marker;
            }
        }

        // Mark entire column
        for (int i = 0; i < m; i++) {
            if (matrix[i][col] != 0) {
                matrix[i][col] = marker;
            }
        }
    }
}