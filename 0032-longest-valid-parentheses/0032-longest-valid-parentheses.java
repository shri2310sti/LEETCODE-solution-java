class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Push -1 onto the stack to act as a base for the valid substring

        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i); // Push index of '(' onto the stack
            } else {
                stack.pop(); // Pop the top element if current character is ')'
                if (stack.isEmpty()) {
                    stack.push(i); // If stack becomes empty, push current index onto stack to act as base
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek()); // Calculate the length of valid substring
                }
            }
        }
        return maxLen;
    }
}