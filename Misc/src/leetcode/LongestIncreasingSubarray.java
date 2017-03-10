package leetcode;

public class LongestIncreasingSubarray {
	
	
	public int longestIncreasingSubarray(int[] nums){
		
		if(nums==null || nums.length==0)
			return 0;
		if(nums.length==1)
			return 1;
		int start =0;
		int maxstart=0,maxend=0;
		int end=0;
		int i=1;
		int maxlength=Integer.MIN_VALUE;
		int length=0;
		while(i<nums.length){
			
			if(nums[i]>nums[i-1]){
				i++;		
			}else{
				length = i-1-start+1;
				if(length>maxlength){
					maxlength=length;
					maxstart=start;
					maxend=i-1;
				}
				start=i;
				i++;			
			}
		}
		
		length=i-1-start+1;
		if(length>maxlength){
			maxlength=length;
			maxstart=start;
			maxend=i-1;
		}
		
		return maxlength;
	}
	
	public static void main(String[] args){
		
		LongestIncreasingSubarray lis = new LongestIncreasingSubarray();
		lis.longestIncreasingSubarray(new int[]{1, 56, 58, 57, 90, 92, 94, 93, 91, 4});
	}

}
