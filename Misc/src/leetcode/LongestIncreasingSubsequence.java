package leetcode;

public class LongestIncreasingSubsequence {
	
	
	public int longestIncSubs(int[] nums){
		
		if(nums==null || nums.length ==0)
			return 0;
		if(nums.length==1)
			return 1;
		
		int[] dp = new int[nums.length];
		for(int i=0;i<dp.length;i++)
			dp[i]=1;
		int maxlength=Integer.MIN_VALUE;
		for(int i=1;i<dp.length;i++){
			
			for(int j=i-1;j>=0;j--){
				
				if(nums[i]>nums[j]){
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
				
			}
			maxlength = (Math.max(dp[i], maxlength));
			
		}
		
		return maxlength;
		
	}

	public static void main(String[] args) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		System.out.println(lis.longestIncSubs(new int[]{3}));
	}

}
