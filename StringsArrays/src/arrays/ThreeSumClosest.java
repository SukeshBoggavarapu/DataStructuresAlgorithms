package arrays;

import java.util.Arrays;

public class ThreeSumClosest {

	public int threeSumClosest(int[] nums, int target) {
		int nearSum = Integer.MAX_VALUE;
		int res=0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length-2; i++) {

			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				
				int fn = nums[i];
				int m=i+1;
				int n= nums.length-1;
				while(m<n){
					
					int sum = fn+nums[m]+nums[n];
					if(sum==target){
						
						return target;
						
					}else if(sum>target){
						n--;
					}else if(sum<target)
						m++;
				int diff = Math.abs(target-sum);
					if(diff<nearSum){
						nearSum = diff;
						res=sum;
					}
				}

			}

		}

		return res;

	}

	public static void main(String[] args) {
		ThreeSumClosest tsc = new ThreeSumClosest();
		System.out.println(tsc.threeSumClosest(new int[]{-1,2,1,-4}, 1));
	}

}
