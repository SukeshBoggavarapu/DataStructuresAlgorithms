package leetcode;

public class MoveZeroes {
	
	public void moveZeroes(int[] nums){
		
		int i=0;
		int j=nums.length-1;
		
		while(i<j){
			
			while(i<j && nums[i]!=0)
				i++;
			while(i<j && nums[j]==0)
				j--;
			swap(nums,i,j);
			
		}
		
	}
	
	public void moveZeroesOrder(int[] nums){
		
		int count=0;
		for(int i=0;i<nums.length;i++){
			
			if(nums[i]!=0){
				
				if(count!=i){		
					swap(nums,i,count);
				}
				count++;
			}
			
		}
		
		
	}
	
	public void swap(int[] nums,int pos1 ,int pos2){
		
		int temp =nums[pos1];
		nums[pos1]=nums[pos2];
		nums[pos2]=temp;
		
	}

	public static void main(String[] args) {
		MoveZeroes mz = new MoveZeroes();
		int[] nums = new int[]{2,0,5,7,0,0,4,6,0};
		mz.moveZeroesOrder(nums);
		System.out.println();
	}

}
