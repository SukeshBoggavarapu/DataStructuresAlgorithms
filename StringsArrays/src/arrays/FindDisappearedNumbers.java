package arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
	
public List<Integer> findDisappearedNumbers(int[] nums) {
        
        if(nums==null || nums.length==0)
            return null;
        
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=0;i<nums.length;i++){
            
            if(nums[Math.abs(nums[i])-1]>0)
                 nums[Math.abs(nums[i])-1]=-nums[Math.abs(nums[i])-1];
            
            
        }
        
        for(int i=0;i<nums.length;i++){
            
            if(nums[i]>0){
                list.add(i+1);
            }
        }
        
        return list;
        
    }

	public static void main(String[] args){
		
		
		FindDisappearedNumbers fn = new FindDisappearedNumbers();
		fn.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
	}

}
