package arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	 public int[] twoSum(int[] nums, int target) {
	        
	        if(nums==null || nums.length==0)
	            return null;
	        
	        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	        int[] result = new int[2];
	        
	        map.put(nums[0],0);
	        
	        for(int i=1;i<nums.length;i++){
	            
	            if(map.containsKey(target-nums[i])){
	             result[0]= map.get(target-nums[i]);
	             result[1]=i;
	            }else {
	                map.put(nums[i],i);
	            }
	        }
	        
	        return result;
	        
	    }

}
