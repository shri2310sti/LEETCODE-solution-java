class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
    
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{') stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                
                char lastEle = stack.pop();
                if((c == ')' && lastEle != '(') || (c == '}' && lastEle != '{') || (c == ']' && lastEle != '[')) return false;
            }
        }
        return stack.isEmpty();
    }
}