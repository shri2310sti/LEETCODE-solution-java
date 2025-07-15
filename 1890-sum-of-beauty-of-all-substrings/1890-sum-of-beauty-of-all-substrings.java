import java.util.*;

class Solution {
    public int beautySum(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            int[] arr = new int[26];

            for(int j = i; j < s.length(); j++){
                arr[s.charAt(j) - 'a']++;

                int maxFreq = Integer.MIN_VALUE, minFreq = Integer.MAX_VALUE;
                for(int k = 0; k < 26; k++){
                    if(arr[k] > 0){
                        maxFreq = Math.max(maxFreq, arr[k]);
                        minFreq = Math.min(minFreq, arr[k]);
                    }
                }

                if(maxFreq == Integer.MIN_VALUE || minFreq == Integer.MAX_VALUE) sum += 0; 
                else sum += (maxFreq - minFreq);
                
            }
        }
        return sum;
    }
}