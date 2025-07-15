import java.util.*;

class Solution {
    public int beautySum(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j <= s.length(); j++){
                sum += beauty(s.substring(i, j));
            }
        }
        return sum;
    }
    private static int beauty(String s){
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a']++;
        }
        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;

        for(int i = 0; i < 26; i++){
            if(arr[i] > 0){
                maxFreq = Math.max(maxFreq, arr[i]);
                minFreq = Math.min(minFreq, arr[i]);
            }
        }
        if(maxFreq == Integer.MIN_VALUE || minFreq == Integer.MAX_VALUE) return 0;
        return (maxFreq - minFreq);
    }
}