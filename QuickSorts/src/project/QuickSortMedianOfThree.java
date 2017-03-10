package project;

public class QuickSortMedianOfThree {
	
	public static void quickSortMedianOfThree(int[] nums){
		
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
		
		//Choosing pivot
		int mid = left+(right-left)/2;
		sortThreeElements(nums,left,mid,right);
		int pivot = nums[mid];
		Quicksort.swap(nums,mid,right);
		int pivotIdx=left;
		int j=left;
		while(j<right){
			
			if(nums[j]>pivot)
				j++;
			else if(nums[j]<=pivot){				
				Quicksort.swap(nums,pivotIdx,j);
				pivotIdx++;j++;
			}	
		}
		Quicksort.swap(nums,right,pivotIdx);
		return pivotIdx;
		
	}
	
	public static void sortThreeElements(int[] nums,int left,int mid,int right){
		
		if(nums[left]>nums[right])
			Quicksort.swap(nums, left, right);
		if(nums[left]>nums[mid])
			Quicksort.swap(nums, left, mid);
		if(nums[mid]>nums[right])
			Quicksort.swap(nums, right, mid);
		
	}
	
	

	public static void main(String[] args) {
		int[] nums = Quicksort.generateRandomArray(20);
		quickSortMedianOfThree(nums);
		for(int i=0;i<nums.length;i++){
			System.out.println(nums[i]);
		}
		System.out.println();
	}

}
