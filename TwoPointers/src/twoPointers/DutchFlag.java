package twoPointers;

public class DutchFlag {
	
	public int[] dutchFlag(int[] nums){
		
		int sp =0; 
		int fp= 1;

		for(int j=0;j<1;j++){
		while(sp!=fp && fp<nums.length){
		
			if(nums[fp]==j && nums[sp]!=j){
				int temp = nums[fp];
				nums[fp]=nums[sp];
				nums[sp]=temp;
				sp++;
				fp++;
			}else if(nums[sp]==j){
				sp++;
				fp++;
			}else {
				fp++;
			}
			
		}
		fp=sp+1;
		}
		
		return nums;
		
	}
	
	public void sortThreeValues(int[] nums){
		
		//All zeroes are between 0 and Low
		int low =0;
		//All ones between low+1 and mid-1
		int mid =0;
		//All numbers between mid and high are unknown
		int high =nums.length-1;
		//All numbers between high+1 and nums.length-1 are 2's
		
		while(mid<=high){
			
			int val = nums[mid];
			
			/*switch(val){
			
			case 0 :
				int temp = nums[mid];
				nums[mid] = nums[low];
				nums[low]=temp;
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				int tempVal = nums[mid];
				nums[mid]=nums[high];
				nums[high]=tempVal;
				high--;
				break;
			default:
				break;	
			}*/
			
			
			//For three partitions
			if(val<=4){
				int temp = nums[mid];
				nums[mid] = nums[low];
				nums[low]=temp;
				low++;
				mid++;
			
			}else if (val>4 && val<=6){
				mid++;
			
			}else if(val>6){
				int tempVal = nums[mid];
				nums[mid]=nums[high];
				nums[high]=tempVal;
				high--;
			}
			
			
		}
		
	}

	public static void main(String[] args){
		
		DutchFlag df = new DutchFlag();
		int[] nums = new int[]{2,1,2,0,1,2,1,0,0,2,1};
		int[] nums2 = new int[]{2,7,3,9,6,1,8,0,4,5};
		//df.dutchFlag(nums);
		df.sortThreeValues(nums2);
		System.out.println();
	}
}
