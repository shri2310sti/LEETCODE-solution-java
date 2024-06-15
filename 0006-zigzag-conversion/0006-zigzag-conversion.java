class Solution {
    public String convert(String s, int numRows) {
         if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        
        int index = 0;
        int step = 1;
        
        for (char c : s.toCharArray()) {
            rows[index].append(c);
            
            if (index == 0) {
                step = 1;
            } else if (index == numRows - 1) {
                step = -1;
            }
            
            index += step;
        }
        
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String s1 = "PAYPALISHIRING";
        System.out.println(solution.convert(s1, 3));  // Output: "PAHNAPLSIIGYIR"

        String s2 = "PAYPALISHIRING";
        System.out.println(solution.convert(s2, 4));  // Output: "PINALSIGYAHRPI"

        String s3 = "A";
        System.out.println(solution.convert(s3, 1));  // Output: "A"
    }
}