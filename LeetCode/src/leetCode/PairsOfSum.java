package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairsOfSum {
	
	public List<List<Integer>> pairsOfSum(int[] nums , int target){

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	
		for(int i=0;i<nums.length;i++){
			if(map.containsKey(nums[i]))
				map.put(nums[i], map.get(nums[i])+1);
			else
				map.put(nums[i], 1);	
		}
		int count=0;
		for(int i=0;i<nums.length;i++){
			
			if(map.containsKey(target-nums[i])){
				count++;
			}
			
		}
		
		
		return res;
		
	}

	public static void main(String[] args) {
		
		PairsOfSum ps = new PairsOfSum();
		ps.pairsOfSum(new int[]{1,1,1}, 2);
		
	}

}
