package dp;

public class JumpGame {
	
	public static boolean jumpGame(int[] nums){
		
		   int maxLocation =0;
	        
	        for(int i=0;i<nums.length;i++){
	            
	            if(maxLocation<i) return false;
	            maxLocation = (i+nums[i]>maxLocation ? i+nums[i] : maxLocation);
	            
	        }
	        
	        return true;
	}
	
	public static void main(String[] args){
		
		int[] vals = new int[]{3,2,1,0,4};
		System.out.println(jumpGame(vals));
		
	}

}
