class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) 
    {
        int n = nums.length;
        List<Integer> res = new ArrayList<Integer>();
        
        Arrays.sort(nums);
        
        int dp[] = new int[n+1];
        
        Arrays.fill(dp, 1);
        
        int max=1;
        
        for(int i=1;i<n;i++)
        {
        	for(int j=0;j<i;j++)
        	{
        		if(nums[i]%nums[j]==0 && dp[i]<1+dp[j])
        		{
        			dp[i] = 1+dp[j];
        		}
        	}
        	if(max<dp[i]) max=dp[i];        	
        }
        
        int prev=-1;
        
        for(int i=n-1;i>=0;i--)
        {
        	if(dp[i]==max && (prev%nums[i]==0 || prev==-1))
        	{
        		res.add(nums[i]);
        		max-=1;
        		prev=nums[i];
        	}
        }
        
        return res;     
    }
}