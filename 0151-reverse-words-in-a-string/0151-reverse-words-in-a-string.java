class Solution {
    public String reverseWords(String s) {
         s = s.trim();
        ArrayList<String> arr = new ArrayList<>();
        String str = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                if(!str.isEmpty()){
                    arr.add(str);
                    str = "";
                }
            } else str += s.charAt(i);
        }
        if (!str.isEmpty()) { // Add the last word
            arr.add(str);
        }
        String ans = "";
        for(int i = arr.size() - 1; i >= 0; i--){
            ans += arr.get(i);
            if (i > 0) { // Add space only if not the last word
                ans += " ";
            }
        }
        return ans;
    }
}