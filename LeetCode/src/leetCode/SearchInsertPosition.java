package leetCode;

public class SearchInsertPosition {


    public int searchInsert(int[] nums, int target) {
        
        if(nums==null || nums.length==0)
            return -1;
        
        return searchInsertPos(nums,0,nums.length-1,target);
        
    }
    
    public int searchInsertPos(int[] nums ,int start,int end,int target){
 
        while(start<=end){
            
            int mid = start+(end-start)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                start=mid+1;
            else
                end = mid-1;
        }
        
        if(start<=nums.length-1){
           return nums[start]>target ? start : start+1; 
        }else 
            return start;
        
    }


}
