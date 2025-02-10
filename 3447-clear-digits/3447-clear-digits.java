class Solution {
    public String clearDigits(String s) {
        StringBuilder stack = new StringBuilder(); // Using StringBuilder as a stack
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Remove the closest non-digit character to its left
                if (stack.length() > 0) {
                    stack.deleteCharAt(stack.length() - 1);
                }
            } else {
                // Push non-digit characters onto the stack
                stack.append(ch);
            }
        }
        
        return stack.toString();
    }
}
