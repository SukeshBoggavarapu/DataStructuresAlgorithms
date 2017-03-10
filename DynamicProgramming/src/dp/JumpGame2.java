package dp;

public class JumpGame2 {
	
	public int jumpGame2(int[] nums){
		
		 int last_jump_max=0;
	        int cur_jump_max=0;
	        int step_count=0;
	        for(int i=0;i<nums.length-1;i++){
	            
	            cur_jump_max = Math.max(cur_jump_max,i+nums[i]);
	            if(i==last_jump_max){
	                step_count++;
	                last_jump_max=cur_jump_max;
	                
	            }
	            
	        }
	        
	        return step_count;
	}

}
