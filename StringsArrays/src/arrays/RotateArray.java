package arrays;

public class RotateArray {
	
	public void rotate(int[] nums, int k) {
        
        if(nums==null || nums.length==0 || nums.length==1)
            return;
         k = k%(nums.length);
        reverse(nums,0,nums.length-k-1);
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums,0,nums.length-1);
        
    }
    
    public void reverse(int[] nums, int startIndex , int endIndex){
        
        if(startIndex<endIndex){
            
        
        int size = (endIndex-startIndex)/2;
        int temp=0;
        for(int i=0;i<=size;i++){
            
            temp=nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex]=temp;
            startIndex++;
            endIndex--;
            
        }
        
    }
    }

}
