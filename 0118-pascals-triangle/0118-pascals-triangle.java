class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        // Base case: numRows = 0
        if (numRows == 0) {
            return triangle;
        }
        
        // First row always contains 1
        triangle.add(Arrays.asList(1));
        
        // Iterate for each row
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> row = new ArrayList<>();
            
            // First element of the row is always 1
            row.add(1);
            
            // Calculate elements between the first and last
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            
            // Last element of the row is always 1
            row.add(1);
            
            triangle.add(row);
        }
        
        return triangle;
    }
}
