class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(result, "", 0, 0, n);
        return result;
    }
    
    private void generateParenthesisHelper(List<String> result, String current, int open, int close, int max) {
        // Base case: when the current string is complete
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        
        // Add an opening parenthesis if we haven't used up all `n` opening parentheses
        if (open < max) {
            generateParenthesisHelper(result, current + "(", open + 1, close, max);
        }
        
        // Add a closing parenthesis if it won't exceed the number of opening parentheses
        if (close < open) {
            generateParenthesisHelper(result, current + ")", open, close + 1, max);
        }
    }
}
