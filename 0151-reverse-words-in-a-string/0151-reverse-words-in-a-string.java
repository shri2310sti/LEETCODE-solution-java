class Solution {
    public String reverseWords(String s) {
    //    String[] words = s.split("\\s+");
    //     StringBuilder res = new StringBuilder();

    //     for (int i = words.length - 1; i >= 0; i--) {
    //         res.append(words[i]);
    //         if (i != 0) {
    //             res.append(" ");
    //         }
    //     }

    //     return res.toString().trim();

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

        
        String result = "";
        for(int i = str.size() - 1; i >= 0; i--){
            if(i == 0) return  result += str.get(i);
            result += str.get(i) + " ";
        }
        return result;
    
    }

    
}