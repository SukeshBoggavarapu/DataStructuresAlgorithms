package leetCode;

import java.util.Arrays;

public class AssignCookies {
	
public static int findContentChildren(int[] g, int[] s) {
        
        Arrays.sort(g);
      Arrays.sort(s);
        
        
        
        int i=0; int j=0;int count=0;
        if(g.length==0 || s.length ==0){
            return 0;
        }
       
        while(i<g.length && j<s.length){
            
            if(g[i]<=s[j]){
                count++;
                i++;j++;
            }else if(g[i]>s[j]){
                j++;
            }
        }
        
        return count;
        
    }
    
   
	public static void main(String[] args) {
		int[] g= new int[]{1,2,3};
		int[] s= new int[]{3};
		System.out.println(findContentChildren(g, s));
	}

}
