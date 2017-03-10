package project;

import java.util.Random;

public class Quicksort {
	
	
	public static void quickSort(int[] nums){
		
		if(nums==null || nums.length==0)
			return;
		sort(nums,0,nums.length-1);
	}
	
	public static void sort(int[] nums,int left,int right){
		
		//Without Insertion sort
		/*if(left<right){
		int partitionIndex = partition(nums,left,right);
		sort(nums,left,partitionIndex-1);
		sort(nums,partitionIndex+1,right);
		}*/
		
		//If InsertionSort has to be used for <10 elements
		if(left<right && right-left>=10){
			int partitionIndex = partition(nums,left,right);
			sort(nums,left,partitionIndex-1);
			sort(nums,partitionIndex+1,right);
		}else if(left<right && right-left<10){
			//InsertionSort
			insertionSort(nums,left,right);
		}
		
	}
	
	public static void insertionSort(int[] nums,int start,int end){
		
		for(int i=start+1;i<=end;i++){
			
			for(int j=i;j>start;j--){
				
				if(nums[j]<nums[j-1]){
					swap(nums,j,j-1);
				}
			}	
		}		
	}
	
	public static int partition(int[] nums,int left,int right){
		
		int pivot = nums[right];
		int pivotidx= left;
		int j=left;
		while(j<right){
			
			if(nums[j]>pivot){
				j++;		
			}else if(nums[j]<=pivot){
				swap(nums,pivotidx,j);
				pivotidx++;j++;
			}
		}
		
		swap(nums,pivotidx,j);
		
		return pivotidx;
	}
	
	public static void swap(int[] nums,int idx1,int idx2){
		
		int temp = nums[idx1];
		nums[idx1]=nums[idx2];
		nums[idx2]=temp;
		
	}
	
	

	public static void main(String[] args) {
		
		int[] nums = generateRandomArray(200);
		//int[] nums = new int[]{5, 0, 8, 8, 0, 7, 5, 2, 6, 5};
		quickSort(nums);
		for(int i=0;i<nums.length;i++){
			System.out.println(nums[i]);
		}
		System.out.println();
	}
	
	public static int[] generateRandomArray(int n){
		
		int[] vals = new int[n];
		Random random = new Random();
		
		for(int i=0;i<n;i++){			
			vals[i]=random.nextInt(n);
		}
		
		return vals;
	}

}
