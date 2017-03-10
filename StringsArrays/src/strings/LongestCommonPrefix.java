package strings;

public class LongestCommonPrefix {
	
public String longestCommonPrefix(String[] strs) {
        
        if(strs==null || strs.length==0)
            return "";
            
        if(strs.length==1)
            return strs[0];
        int minLen = Integer.MAX_VALUE;
        String minStr ="";
            
        for(int i=0;i<strs.length;i++){
            
            if(strs[i].length()<minLen){
                minLen = strs[i].length();
                minStr = strs[i];
            }
            
        }
        StringBuffer sb = new StringBuffer();
        boolean isEnd= false;
        for(int k=0;k<minStr.length();k++){
            
            int i=0;
            int j=strs.length-1;
            while(i<=j){
                
                if(strs[i].charAt(k)!=strs[j].charAt(k)){
                    isEnd=true;
                    break;
                }
                i++;j--;
                
            }
            if(strs[--i].charAt(k)!=strs[j].charAt(k))
            	isEnd=true;
            
            	
            if(isEnd)
                break;
            sb.append(strs[i].charAt(k));
            
        }
        
        return sb.toString();
        
    }
	

	public static void main(String[] args) {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		System.out.println(lcp.longestCommonPrefix(new String[]{"c","acc","ccc"}));
	}

}
