class Solution {
    public String reverseWords(String s) {
        s = s.trim();

        ArrayList <String> str = new ArrayList<>();

        String el = "";
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ') {
                if (!el.isEmpty()){
                    str.add(el);
                    el = "";
                }
            }
            else el += s.charAt(i);

        }
        str.add(el);

        Collections.reverse(str);
        String result = "";
        for(int i = 0; i < str.size(); i++){
            if(i == str.size() - 1) return  result += str.get(i);
            result += str.get(i) + " ";
        }
        return result;
    }
}