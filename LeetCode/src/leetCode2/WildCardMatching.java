package leetCode2;

public class WildCardMatching {

    public boolean isMatch(String s, String p) {
        
        int i=0;int j=0;int strIndx=-1;int stringIndex=0;
        
        while(i<s.length()){
            
            if(j<p.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')){
                i++;
                j++;
            }else if(j<p.length() && p.charAt(j)=='*'){
                
                strIndx=j;
                stringIndex=i;
                j++;
                
            }else if(strIndx!=-1){
                
                j=strIndx+1;
                stringIndex++;
                i=stringIndex;
                
                
            }else 
                return false;
        }
        
        
            while(j<p.length()){
                if(p.charAt(j)!='*')
                    return false;
                j++;
            }
        
        
        return true;
        
    }



	public static void main(String[] args) {
		WildCardMatching rem = new WildCardMatching();
		System.out.println(rem.isMatch( "abefcdgiescdfimde", "ab*cd?i*de"));
	}

}
