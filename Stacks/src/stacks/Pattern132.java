package stacks;

import java.util.Stack;

public class Pattern132 {
	
	public boolean isPatternPresent(int[] nums){
		
		Stack<Pair> stack = new Stack<Pair>();
		
// We store each value as a min and max pair and store the min-max intervals whenever a new min is encountered		
		
		for(int i=0;i<nums.length;i++){
			
			if(stack.isEmpty() || nums[i]<=stack.peek().min){
				
				stack.push(new Pair(nums[i],nums[i]));
			} else {
				
				Pair pair = stack.pop();
				
				if(nums[i]<pair.max){
					return true;
				} else {
					
					pair.max = nums[i]; 
					
	//We remove all those intervals where the current max is greater than previous maxs.			
					
					while(!stack.isEmpty() && nums[i]>=stack.peek().max) {
						stack.pop();
					}
					
					if(!stack.isEmpty() && nums[i]>stack.peek().min) {
						return true;
					}
					
					stack.push(pair);
					
				}
			}
			
		}
		return false;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

	class Pair{
		
		int min;
		int max;
		
		public Pair(int min, int max){
			this.max=max;
			this.min=min;
		}
	}
