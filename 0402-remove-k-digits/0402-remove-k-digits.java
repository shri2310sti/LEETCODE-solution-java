class Solution {
    public String removeKdigits(String nums, int k) {
        Stack <Character> st = new Stack<>();
        int count = 0;

        for(int i=0; i<nums.length(); i++){
            
            while(!st.isEmpty() && st.peek() > nums.charAt(i) && count < k) {
                st.pop();
                count++;
            }

            st.push(nums.charAt(i));

        }

        
        while(count < k) {
            st.pop();
            count++;
        }

        

        Stack <Character> stc = new Stack<>();
        
        while(!st.isEmpty()) stc.push(st.pop());
        
        int n = stc.size();

        while(!stc.isEmpty() && stc.get(n-1) - '0' == 0){
            stc.pop(); n--;
        } 
        
        if(stc.isEmpty()) return "0";

        String ans = "";
        int s = stc.size();

        for(int i = s - 1; i >= 0; i--){
            ans += stc.pop();
        }
        
        return ans;
    }
}