package leetCode;

public class HammingDistance {

   public void sol(int[] nums){ 
    int count =0;
        
        for(int i=0;i<nums.length;i++){
            
            for(int j=i+1;j<nums.length;j++){
                
                int val = nums[i] ^ nums[j];
                  while(val>0){
                   val = val & (val-1);
                   count++;
                    }
            }
        }
        
       System.out.println(count);
   } 
   
   public static void main(String[] args){
	   
	   
	   HammingDistance hd = new HammingDistance();
	   hd.sol(new int[]{4,14,2});
   }


}
