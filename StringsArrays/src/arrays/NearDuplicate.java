package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NearDuplicate {
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        if(nums==null || nums.length==0)
            return false;
        
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        map.put(nums[0],0);
        
        for(int i=1;i<nums.length;i++){
            
            if(map.containsKey(nums[i])){
                
                if((i-map.get(nums[i]))<=k)
                    return true;
                else
                    map.put(nums[i],i);
            }else {
                map.put(nums[i],i);
            }
        }
        
        return false;
        
    }
	
	
	public boolean containsNearByDuplicate2(int[] nums ,int k){
		
		 if(nums==null || nums.length==0)
	            return false;
	        
	      Set<Integer> set = new HashSet<Integer>();
	      
	      for(int i=0;i<nums.length;i++){
	          
	          if(i>k){
	              set.remove(nums[i-k-1]);
	          }
	          if(!set.add(nums[i]))
	               return true;
	          
	      }
	      
	      return false;
	}

}
