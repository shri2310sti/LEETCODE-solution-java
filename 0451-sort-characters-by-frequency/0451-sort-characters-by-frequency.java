class Solution {
    public String frequencySort(String s) {
        
        Map <Character, Integer> mp = new HashMap<>();
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
           mp.put(c, mp.getOrDefault(c, 0) + 1); 
        }

        String ans = "";

        while (!mp.isEmpty()){
            int max = Integer.MIN_VALUE;
            char maxChar = ' ';
            for(char c : mp.keySet()){
                if(max < mp.get(c)){
                    max = mp.get(c);
                    maxChar = c;
                }
            }
            for(int i = 0; i < max; i++){
                ans += maxChar;
            }
            mp.remove(maxChar);
        }
        return ans;
    }
}