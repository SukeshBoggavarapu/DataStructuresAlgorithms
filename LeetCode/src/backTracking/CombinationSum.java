package backTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	
	
	public List<List<Integer>> combinationSum(int[] nums , int target){
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		backtrack(res,new ArrayList<Integer>(),nums,target,0);
		return res;
		
	}
	
	public void backtrack(List<List<Integer>> res , List<Integer> tempList , int[] nums, int remain , int start){
		
		if(remain<0)
			return;
		if(remain==0){
				res.add(new ArrayList<Integer>(tempList));
				return;
		}
		for(int i=start;i<nums.length;i++){
			//if(i>0 && nums[i]==nums[i-1]) continue;
			tempList.add(nums[i]);
			backtrack(res,tempList,nums,remain-nums[i],i);
			tempList.remove(tempList.size()-1);
			
		}
		
		
	}

	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		cs.combinationSum(new int[]{2,3,4,5}, 6);
	}

}
