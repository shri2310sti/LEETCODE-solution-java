class Solution {
    public boolean canPartition(int[] nums) 
    {
        int sum=0;
        
        for(int i: nums)
        {
        	sum+=i;
        }
                
        if(sum%2==1) return false; // ODD sum
        
        int n = nums.length; 
        sum /= 2; // new Sum

        boolean dp[][] = new boolean[n+1][sum+1];

        for(int i=0;i<=n;i++) // first column
        {
            dp[i][0] = true;
        }


    //  for(int j=1;j<=sum;j++) // first row (default)
    //  {
    //      dp[0][j] = false;
    //  }

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(nums[i-1]>j)
                {
                    dp[i][j] = dp[i-1][j];
                }

                else if(nums[i-1]==j)
                {
                    dp[i][j] = true;
                }

                else 
                {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        } 

        return dp[n][sum];
    }
}