class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 1; i <= numRows; i++){
            List<Integer> ansRow = new ArrayList<>();
            for(int j = 1; j <= i; j++){
                ansRow.add(nCr(i-1,j-1));
            }
            ans.add(ansRow);
        }
        return ans;
    }
    public int nCr(int n, int r){
        int result = 1; // 4C2
        for(int i = 0; i < r; i++){
            result = result * (n-i); // 1 4 3 
            result = result / (i+1); 
        }
        return result;
    }
}