package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithGivenSum {
	
	public int[] subarrayWithSum(int[] nums,int target){
		
		if(nums==null || nums.length==0)
			return null;
		int start=-1;
		int sum=0;
		int end=-1;
		while(end<nums.length){
			if(sum>target){	
				++start;
				sum-=nums[start];
			}else if(sum<target){
				++end;
				sum+=nums[end];
			}else 
			{
				int[] res = new int[2];
				res[0]=start+1;
				res[1]=end;
				return res;
			}
		}
		return null;
		
	}
	
	//Handling Negative Integers
	public int[] subarrayWithSumNegs(int[] nums,int target){
		
		if(nums==null || nums.length==0)
			return null;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int cursum=0;
		for(int i=0;i<nums.length;i++){
			
			cursum+=nums[i];
			if(cursum==target){
				return new int[]{0,i};
			}
			
			if(map.containsKey(cursum-target))
				return new int[]{map.get(cursum-target),i};
			map.put(cursum, i);
			
		}
		return null;
		
	}

	public static void main(String[] args) {
		SubarrayWithGivenSum sgs = new SubarrayWithGivenSum();
		int[] res = new int[2];
		res = sgs.subarrayWithSumNegs(new int[]{10, 2, -2, -20, 10}, -10);
		System.out.println(res[0]+"  -- "+ res[1]);
	}

}
