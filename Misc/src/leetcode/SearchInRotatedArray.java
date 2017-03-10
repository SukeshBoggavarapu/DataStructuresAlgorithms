package leetcode;

public class SearchInRotatedArray {
	
	public int searchInRotatedArr(int[] nums , int target){
		if(target==nums[0] || target==nums[nums.length-1])
			return target==nums[0] ? 0 : nums.length-1;
		
		int minIndex = search(nums,0,nums.length-1);
		if(target==nums[minIndex])
			return minIndex;
		if(target>nums[0]){
			return searchIndex(nums,0,minIndex-1,target);
		}else
			return searchIndex(nums,minIndex+1,nums.length-1,target);
		
	}
	
	public int searchIndex(int[] nums,int start ,int end,int target){
		
		if(start>end)
			return -1;
		while(start<end){
			
			int mid = start +(end-start)/2;
			if(target<nums[mid]){
				end=mid-1;
			}else
				start=mid;
			
		}
		
		return start;
		
	}
	
	public int search(int[] nums,int start,int end){
		
		if(start>end)
			return -1;
		while(start<end){
			int mid = start+(end-start)/2;
			
			if(nums[mid]>nums[end])
				start=mid+1;
			else
				end=mid;
		}
		return end;
	}


}
