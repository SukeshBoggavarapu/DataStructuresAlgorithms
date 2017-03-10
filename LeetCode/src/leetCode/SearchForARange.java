package leetCode;

public class SearchForARange {
	
	public int[] res = new int[2];
	
	public int[] searchRange(int[] nums,int target){
		
		searchForRange(nums,0,nums.length-1,target);
		return res;
		
	}
	
	public void searchForRange(int[] nums,int start,int end,int target){
		
		
		if(start>end)
			return;
		
		int mid = start+(end-start)/2;
		if(nums[mid]==target){
			if( mid==0 || nums[mid-1]!=target)
				res[0]=mid;
			if(mid == nums.length-1 || nums[mid+1]!=target)
				res[1]=mid;
			if(mid>=1 && nums[mid-1]==target)
				searchForRange(nums,start,mid-1,target);
			if(mid<=nums.length-2 && nums[mid+1]==target){
				searchForRange(nums,mid+1,end,target);
			}
			
		}else if(nums[mid]<target){
			searchForRange(nums,mid+1,end,target);
		}else 
			searchForRange(nums,start,mid-1,target);
		
	}

	public static void main(String[] args) {
		SearchForARange sfr = new SearchForARange();
		int[] result = sfr.searchRange(new int[]{2,2,2,2},2);
		System.out.println(result[0]+"--" +result[1]);
	}

}
