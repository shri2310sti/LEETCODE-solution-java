class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int max = 0;
        for(int i=0; i<k; i++){
            sum += cardPoints[i];
        }
        max = Math.max(max,sum);
        int i=k-1, j = cardPoints.length-1;
        while(i<j && i>=0){
            sum -= cardPoints[i];
            i--;
            sum+= cardPoints[j];
            j--;
            max = Math.max(max,sum);
        }
        return max;
    }
}