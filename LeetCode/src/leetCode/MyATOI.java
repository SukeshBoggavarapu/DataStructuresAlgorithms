 package leetCode;

public class MyATOI {
	
	public int myAtoi(String str){
        if(str==null || str.length()==0)
            return 0;
        
        int res=0;
        str=str.trim();
        boolean isNegative = false;
        int i=0;
        if(str.charAt(0)=='+'){
        	i++;
         }
         else if(str.charAt(0) =='-'){
        	 i++;
             isNegative = true;
         }
        
        for(;i<str.length();i++){
            
        if(str.charAt(i)>='0' && str.charAt(i)<='9'){     
            int val = str.charAt(i) - '0';
            
            if(res>Integer.MAX_VALUE/10 || res == Integer.MAX_VALUE/10 && val >7){
               if(isNegative)
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }
            res= res *10 + val;
        }else
            break;
        }
        
        if(isNegative)
            res = -res;
        return res;
	}

	public static void main(String[] args) {
		MyATOI ma = new MyATOI();
		System.out.println(ma.myAtoi("214h78"));
	}

}
