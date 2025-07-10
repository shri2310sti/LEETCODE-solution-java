class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> mp = Map.of('M', 1000, 'D', 500, 'C', 100, 'L', 50, 'X', 10, 'V', 5, 'I', 1);

        int preV = 0;
        int ans = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            int curr = mp.get(s.charAt(i));

            if(preV > curr) ans -= curr;
            else ans += curr;
            preV = curr;
        }
        return ans ;
    }
}