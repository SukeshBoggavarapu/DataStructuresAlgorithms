package dpCTC;

public class MagicIndex {
	
	
	public int magicIndex(int[] nums,int start , int end){
		
		if(start>end)
			return -1;
		
		int mid = start + ((end-start)/2) ;
		
		if(nums[mid]>mid){
			return magicIndex(nums,start,mid-1);
		}else if(nums[mid]<mid){
			return magicIndex(nums,mid+1,end);
		}else if(nums[mid] ==mid){
			return mid;
		}
		
		return -1;
		
	}
	
	public int magicIndex2(int[] nums , int start , int end){
		
			if(start>end)
				return -1;
		
			int mid = start+ (end-start)/2;
		
			if(nums[mid]==mid){
				return mid;
			}	
			int min = Math.min(nums[mid], mid-1);
			//leftside
			int val1= magicIndex2(nums,start,min);
			if(val1>=0){
				return val1;
			}
			//rightside
			
			int max = Math.max(nums[mid],mid+1);
			//right side
			int val2 = magicIndex2(nums,max,end);
			if(val2>=0){
				return val2;

		}
		
		return -1;
		
	}

	public static void main(String[] args) {
		
		
		MagicIndex mi = new MagicIndex();
		int[] nums = new int[]{-4,1,3,4,5,7,8,9};
		System.out.println(mi.magicIndex(nums, 0, 7));
		System.out.println(mi.magicIndex2(nums, 0, 7));
	}

}
