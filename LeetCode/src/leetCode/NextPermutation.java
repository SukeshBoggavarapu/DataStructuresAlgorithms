package leetCode;

public class NextPermutation {
	
	 public void nextPermutation(int[] nums) {
	        
	        if(nums==null || nums.length==0 || nums.length<2)
	            return;
	        
	        int n = nums.length-1;
	        int i=n;
	        
	        while(i>0 && nums[i]<=nums[i-1])
	            i--;
	        if(i==0){
	            reverse(nums,0,n);
	            return;
	        }
	        int j=n;
	        while(j>=i && nums[j]<=nums[i-1])
	            j--;
	        swap(nums,i-1,j);
	        reverse(nums,i,n);
	        System.out.println("");
	        
	    }
	 
	 public void swap(int[] nums ,int index1 ,int index2){
	        
	        int temp = nums[index1];
	        nums[index1]= nums[index2];
	        nums[index2]=temp;
	        
	    }
	    
	    public void reverse(int[] nums , int start , int end){
	        
	        int mid = start + (end-start)/2;
	        
	        for(int i=start ;i<=mid;i++){
	            swap(nums,i,start+end-i);
	        }
	        
	    }

	public static void main(String[] args) {
		NextPermutation np = new NextPermutation();
		int[] nums = new int[]{1,5,1};
		np.nextPermutation(nums);
		System.out.println();
	}

}
