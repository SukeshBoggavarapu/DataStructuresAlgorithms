package leetCode;

import java.util.Map;
import java.util.TreeMap;

public class SingleNumber {
	
	public static int singleNumber(int[] nums) {
        
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        
        for(int i=0;i<nums.length;i++){
            
            if(!map.containsKey(nums[i])){
            	map.put(nums[i],1);
            }else {
            	map.remove(nums[i]);   	
            }
        }        
        return map.firstKey();
        
        
    }
	
	public static int singleNumber2(int[] nums) {
        
     int val = nums[0];
        for(int i=1;i<nums.length;i++){
            
           val = val^nums[i];
        }
        
        return val;
        
    }

	public static void main(String[] args) {
		
		int[] nums = new int[]{2,4,5,2,7,3,5,7,4};
		System.out.println(singleNumber(nums));
		
		
	}

}
