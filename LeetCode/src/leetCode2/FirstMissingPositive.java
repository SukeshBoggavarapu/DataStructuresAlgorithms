package leetCode2;

public class FirstMissingPositive {	

    public int firstMissingPositive(int[] nums) {
        
        if(nums==null || nums.length==0)
            return 1;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0 || nums[i]>nums.length)
                nums[i]=0;
        }
        
        for(int i=0;i<nums.length;i++){
            int val = Math.abs(nums[i]);
            if(val>=1 && val<=nums.length){
                
                if(nums[val-1]>0)
                    nums[val-1] = -nums[val-1];
                else if(nums[val-1]==0)
                    nums[val-1]=Integer.MIN_VALUE;
                
            }
            
        }
        
        for(int i=0;i<nums.length;i++){
            
            if(nums[i]>=0)
                return i+1;
        }
        
        return nums.length+1;
        
    }


}
