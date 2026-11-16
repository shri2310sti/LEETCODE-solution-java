class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int c = 0;
        int j = 0;
        for(int i = 0; i<g.length; i++){         
            if(j<s.length && g[i] <= s[j]){
                c++; j++;
            } 
            else if(j<s.length && g[i] > s[j]) {
                int sum = 0;
                while(j<s.length && sum < g[i]){
                    sum = s[j];
                    j++;
                }
                if(g[i] <= sum ) c++;
            }
        }
        return c;
    }
}