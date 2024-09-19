import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        
        // Loop through each character in the expression
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            // If the character is an operator
            if (c == '+' || c == '-' || c == '*') {
                // Split the expression into two parts: left and right
                String leftPart = expression.substring(0, i);
                String rightPart = expression.substring(i + 1);
                
                // Recursively calculate the results for both parts
                List<Integer> leftResults = diffWaysToCompute(leftPart);
                List<Integer> rightResults = diffWaysToCompute(rightPart);
                
                // Combine the results using the current operator
                for (int left : leftResults) {
                    for (int right : rightResults) {
                        if (c == '+') {
                            result.add(left + right);
                        } else if (c == '-') {
                            result.add(left - right);
                        } else if (c == '*') {
                            result.add(left * right);
                        }
                    }
                }
            }
        }
        
        // If there are no operators, the expression is a number, return it as a single result
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        
        return result;
    }
}
