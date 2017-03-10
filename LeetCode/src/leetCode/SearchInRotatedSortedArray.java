package leetCode;

public class SearchInRotatedSortedArray {
	
	public int searchInRotatedSortedArray(int[] nums,int target){
        
        if(nums==null || nums.length==0)
            return -1;
		
		int breakIndex =searchBreakIndex(nums,0,nums.length-1);
		
		if(target==nums[breakIndex]) 
			return breakIndex;
		
		if(target<=nums[nums.length-1])
			return searchIndex(nums,breakIndex,nums.length-1,target);
		else
			return searchIndex(nums,0,breakIndex-1,target);
        
    }
	
	public int searchBreakIndex(int[] nums,int startIndex,int endIndex){
		
		/*if(startIndex>=endIndex)
			return startIndex==endIndex? startIndex : startIndex+1;
		
		int mid = startIndex + (endIndex-startIndex)/2;
		if(nums[mid]>nums[mid+1])
			return mid;
		else if(nums[mid]>nums[endIndex])
			return searchBreakIndex(nums,mid+1,endIndex);
		else if(nums[mid]<nums[endIndex])
			return searchBreakIndex(nums,startIndex,mid-1);
		return 0;*/
		
		while(startIndex<endIndex){
			
			int mid = startIndex+(endIndex-startIndex)/2;
			if(nums[mid]>nums[endIndex])
				startIndex=mid+1;
			else
				endIndex=mid;
			
		}
		return startIndex;
	}
	
	public int searchIndex(int[] nums,int start,int end,int target){
		
		/*if(start>end)
			return -1;
		
		int mid = start+(end-start)/2;
		
		if(nums[mid]==target)
			return mid;
		else if(nums[mid]<target)
			return searchIndex(nums,mid+1,end,target);
		else
			return searchIndex(nums,start,mid-1,target);*/
		
		while(start<=end){
			int mid =start+(end-start)/2;
			if(nums[mid]<target)
				start=mid+1;
			else if(nums[mid]>target)
				end=mid-1;
			else 
				return mid;
		}
		
		return -1;
		
	}

	public static void main(String[] args) {
		SearchInRotatedSortedArray ssa = new SearchInRotatedSortedArray();
		System.out.println(ssa.searchInRotatedSortedArray(new int[]{3,4,5,6,1,2},4));
	}

}
