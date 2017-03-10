package project;

import java.util.Random;

public class QuickSortRandomPivot {
	
	public static void quickSortRandomPivot(int[] nums){
		
		if(nums==null || nums.length==0)
			return;
		sort(nums,0,nums.length-1);
		
	}
	
	public static void sort(int[] nums,int left,int right){
		
		if(left<right){		
			int partIdx = partition(nums,left,right);
			sort(nums,left,partIdx-1);
			sort(nums,partIdx+1,right);		
		}
		
		//If InsertionSort has to be used for <10 elements
				/*if(left<right && right-left>=10){
					int partitionIndex = partition(nums,left,right);
					sort(nums,left,partitionIndex-1);
					sort(nums,partitionIndex+1,right);
				}else if(left<right && right-left<10){
					//InsertionSort
					Quicksort.insertionSort(nums,left,right);
				}*/
	}
	
	public static int partition(int[] nums,int left,int right){
		
		Random rand = new Random();
		int pvtidx = rand.nextInt(right-left)+left;
		int pivot = nums[pvtidx];
		Quicksort.swap(nums,pvtidx,right);
		int pivotIdx =left;
		int j=left;
		while(j<right){
			
			if(nums[j]>pivot){
				j++;
			}else if(nums[j]<=pivot){			
			Quicksort.swap(nums, pivotIdx, j);
			pivotIdx++;
			j++;			
			}
		}
		
		Quicksort.swap(nums,j,pivotIdx);		
		return pivotIdx;
	}
	
	

	public static void main(String[] args) {
		
		int[] nums = Quicksort.generateRandomArray(20);
		//int[] nums = new int[]{5, 0, 8, 8, 0, 7, 5, 2, 6, 5};
		quickSortRandomPivot(nums);
		for(int i=0;i<nums.length;i++){
			System.out.println(nums[i]);
		}
		System.out.println();

	}

}
