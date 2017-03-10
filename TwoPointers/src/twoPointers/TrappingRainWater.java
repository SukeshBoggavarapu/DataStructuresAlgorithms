package twoPointers;

public class TrappingRainWater {
	
	public int trappingRainWater(int[] nums){
		
		int res=0;
		int leftMax=0;
		int rightMax=0;
		int left =0;
		int right=nums.length-1;
		while(left<right){
			
			leftMax=Math.max(nums[left], leftMax);
			rightMax=Math.max(nums[right], rightMax);
			
			if(leftMax<rightMax){
				
				res = res + leftMax-nums[left];
				left++;
				
			}else{
				
				res= res+rightMax-nums[right];
				right--;
			}
			
			
		}
		return res;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
