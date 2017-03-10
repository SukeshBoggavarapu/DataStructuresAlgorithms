package leetCode;

public class ReverseInteger {
	
	
	    public int reverse(int x) {
	        
	        if(x==0)
	            return 0;
	        
	       
	            return reverseNumber(x);
	       
	        
	    }
	    
	    public int reverseNumber(int x){
	        
	    	   
	    	int returnVal =0;
	    	int finalVal=0;
	    	
	        while(x!=0){
	            int val = x%10;
	            finalVal = returnVal*10+val;
	            if((finalVal-val)/10!=returnVal)
	                return 0;
	            x=x/10;
	            returnVal=finalVal;
	        }
	      
	        return returnVal;
	        
	    }
	public static void main(String[] args) {
		ReverseInteger ri = new ReverseInteger();
		System.out.println(ri.reverse(1563847412));
	}

}
