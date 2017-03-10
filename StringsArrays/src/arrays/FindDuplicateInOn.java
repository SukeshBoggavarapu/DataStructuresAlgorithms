package arrays;

public class FindDuplicateInOn {
	
    public int findDuplicate(int[] nums) {
        
        if(nums==null || nums.length==0)
            return -1;
        
        int slow = nums[0];
        int fast = nums[nums[0]];
        
        while(slow!=fast){
            
            slow=nums[slow];
            fast= nums[nums[fast]];
        }
        fast =0;
        while(slow!=fast){
            
            slow=nums[slow];
            fast=nums[fast];
        }
        
        return slow;
        
    }
    
    
    public int findDuplicateBinarySearch(int[] nums){
    	
    	
    	int low = 1;
    	int high = nums.length-1;
    	
    	while(low<high){
    		
    		int mid = low + (high-low)/2;
    		
    		int count=0;
    		
    		for (int i=0;i<nums.length;i++){
    			
    			if(nums[i]<=mid)
    				count++;
    			
    		}
    		
    		if(count>mid){
    			high=mid;
    		}else{
    			low=mid+1;
    		}
    		
    		
    		
    	}
    	
    	return low;
    	
    }
    
    
    public static void main(String[] args){
    	
    	FindDuplicateInOn fn = new FindDuplicateInOn();
    	fn.findDuplicateBinarySearch(new int[]{4,5,2,6,3,1,3});
    	
    }
    
}
