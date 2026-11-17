class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int c = 0;
        int j = 0; 
        for(int i=0; i<g.length; i++){
            if(j<s.length && g[i]<=s[j]){
                c++; j++;
            } else {
                while(j<s.length && s[j] < g[i]) j++;
                if(j<s.length && g[i]<=s[j]){
                    c++; j++;
                }
            }
        }
        return c;
    }
}