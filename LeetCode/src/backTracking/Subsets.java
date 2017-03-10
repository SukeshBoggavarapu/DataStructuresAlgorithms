package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	
	
	public List<List<Integer>> subsets(int[] nums){
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		//Arrays.sort(nums);
		backtrack(res,new ArrayList<Integer>(),nums,0);
		return res;
		
	}
	
	public void backtrack(List<List<Integer>> res, List<Integer> tempList , int[] nums , int start){
		if(tempList.size()==2)
			res.add(new ArrayList<Integer>(tempList));
		
		for(int i=start;i<nums.length;i++){
			//For Duplicates Nums should be sorted
			//if(i> start && nums[i]==nums[i-1]) continue;
			tempList.add(nums[i]);
			backtrack(res,tempList,nums,i+1);
			tempList.remove(tempList.size()-1);
			
		}
		
	}
	
	public static void main(String[] args) {
		Subsets ss = new Subsets();
		ss.subsets(new int[]{1,5,7,9});
	}

}
