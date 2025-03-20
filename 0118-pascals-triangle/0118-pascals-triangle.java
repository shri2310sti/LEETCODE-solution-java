class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        // for(int i = 1; i <= numRows; i++){
        //     List<Integer> ansRow = new ArrayList<>();
        //     for(int j = 1; j <= i; j++){
        //         ansRow.add(nCr(i-1,j-1));
        //     }
        //     ans.add(ansRow);
        // }
        for(int i = 1; i <= numRows; i++){
            ans.add(generateRow(i));
        }
        return ans;
    }

    public List<Integer> generateRow(int n){
        List<Integer> result = new ArrayList<>();
        int ans = 1;
        result.add(ans);
        for(int i = 1; i < n; i++){
            ans = ans * (n-i);
            ans = ans / i;
            result.add(ans);
        }
        return result;

    }
    // public int nCr(int n, int r){
    //     int result = 1; // 4C2 -> element(5,3)
    //     for(int i = 0; i < r; i++){
    //         result = result * (n-i); // 4 3 
    //         result = result / (i+1); // 1 2
    //     }
    //     return result;
    // }
}