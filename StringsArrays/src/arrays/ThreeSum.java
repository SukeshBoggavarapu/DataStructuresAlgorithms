package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
	public int[] temp ;
	public List<List<Integer>> threeSum(int[] nums){
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(nums==null || nums.length==0)
            return res;
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++){
			if(i==0 || (i>0 && nums[i]!=nums[i-1])){
			int fn = nums[i];
			int m = i+1;
			int n= nums.length-1;
			while(m<n){
				int sum = fn+nums[m]+nums[n];
				if(sum==0){
					List<Integer> cures = new ArrayList<Integer>(Arrays.asList(fn,nums[m],nums[n]));
					res.add(cures);
					while(m<n && nums[m]==nums[m+1])m++;
					while(m<n &&nums[n]==nums[n-1])n--;
					m++;n--;
				}else if(sum>0)
					n--;
				else if(sum<0)
					m++;
			}
		
			}
		}	
		return res;
	
        
    }
	
	public void sort(int[] nums){
		
		this.temp = new int[nums.length];
		mergeSort(nums,0,nums.length-1);
		
		
	}
	
	public int[] mergeSort(int[] nums,int startIndex,int endIndex){
		
		if(startIndex>=endIndex)
			return nums;
		
		int mid = startIndex + (endIndex-startIndex)/2;		
		mergeSort(nums,startIndex,mid);
		mergeSort(nums,mid+1,endIndex);
		
		return merge(nums,startIndex,mid,endIndex);
		
		
	}
	
	public int[] merge(int[] nums,int startIndex,int midIndex,int endIndex){
		
		for (int i=startIndex;i<=endIndex;i++){
			temp[i]=nums[i];
		}
		
		int i=startIndex;
		int j=midIndex+1;
		int k=startIndex;
		while(i<=midIndex && j<=endIndex){
			
			if(temp[i]<=temp[j]){
				
				nums[k]=temp[i];
				k++;
				i++;
				
			}else {
				
				nums[k]= temp[j];
				k++;
				j++;
				
			}	
		}
		
		if(i>midIndex){
			
			while(j<=endIndex){
				nums[k]= temp[j];
				k++;
				j++;
			}
			
		}else if(j>endIndex){
			
			while(i<=midIndex){
				nums[k]=temp[i];
				k++;
				i++;
			}
			
		}
		return nums;
		
	}
	

	public static void main(String[] args) {
		ThreeSum ts = new ThreeSum();
		ts.threeSum(new int[]{-2,0,0,2,2});
	}

}
