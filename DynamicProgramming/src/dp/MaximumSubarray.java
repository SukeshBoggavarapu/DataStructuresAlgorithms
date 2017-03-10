package dp;

public class MaximumSubarray {

		  public int maxSubArray(int[] nums) {
		        if(nums==null || nums.length==0)
		            return -1;
		        int max=nums[0];
		        int runningMax=max;
		        
		        for(int i=1;i<nums.length;i++){
		            
		            max=Math.max(nums[i],nums[i]+max);
		            runningMax=Math.max(max,runningMax);
		            
		        }
		        
		        return runningMax;
		        
		    }
		
	
	

	public static void main(String[] args) {
		MaximumSubarray msa = new MaximumSubarray();
		System.out.println(msa.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
	}

}
