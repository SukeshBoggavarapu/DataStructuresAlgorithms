package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	
	
	public List<List<Integer>> fourSum(int[] nums,int target){
			List<List<Integer>> res = new ArrayList<List<Integer>>();
			  if(nums==null || nums.length==0)
	            return res;
			Arrays.sort(nums);
			
			for(int i=0;i<nums.length-3;i++){
				if(i==0 || nums[i]!=nums[i-1]){
				int fn=nums[i];
				
				//Three Sum
				for(int j=i+1;j<nums.length-2;j++){
			    	if(j==i+1 || nums[j]!=nums[j-1]){
					int sn = nums[j];
					int m=j+1;
					int n=nums.length-1;
					
					while(m<n){
						
						int sum = fn+sn+nums[m]+nums[n];
						if(sum==target){
							List<Integer> curList = new ArrayList<Integer>(Arrays.asList(fn,sn,nums[m],nums[n]));
							res.add(curList);
							while(m<n && nums[m]==nums[m+1])m++;
							while(m<n && nums[n]==nums[n-1])n--;
							m++;n--;
							
						}else if(sum>target){
							n--;
						}else
							m++;
					}
				}
				}
			}	
			}
			return res; 
	    }
	
	public static void main(String[] args){
		
		FourSum fs = new FourSum();
		fs.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
		
	}
 
}
