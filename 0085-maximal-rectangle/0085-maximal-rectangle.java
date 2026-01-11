class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols]; // Heights of bars in histogram
        
        int maxArea = 0;
        
        for (int i = 0; i < rows; i++) {
            // Update heights of bars in the histogram
            for (int j = 0; j < cols; j++) {
                heights[j] = (matrix[i][j] == '1') ? heights[j] + 1 : 0;
            }
            
            // Calculate the largest rectangle in the histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        
        return maxArea;
    }
    
    // Function to calculate the largest rectangle in a histogram
    private int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        int[] left = new int[n]; // Indices of the first smaller bar to the left
        int[] right = new int[n]; // Indices of the first smaller bar to the right
        
        Stack<Integer> stack = new Stack<>();
        
        // Fill left array
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        // Clear stack for reuse
        stack.clear();
        
        // Fill right array
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        // Calculate the area of each rectangle and update maxArea
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] - 1));
        }
        
        return maxArea;
    }
}