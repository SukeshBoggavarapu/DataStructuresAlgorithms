package leetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindorme {
	
	 public int longestPalindrome(String s) {
	        
	        Map<Character,Integer> map = new HashMap<Character,Integer>();
	        
	        for(char c: s.toCharArray()){
	            
	            if(!map.containsKey(c)){
	                
	                map.put(c,1);
	            }else {
	                map.put(c,map.get(c)+1);
	            }
	        }
	        int count =0;
	        int val=0;
	        for (char h : map.keySet()){
	            
	            val = (int) map.get(h);
	            
	            if(val%2 ==0){
	                count=count+val;
	            }else {
	                count =count+(val-1);
	            }
	            
	        }
	        
	        if(count<s.length()){
	            count++;
	        }
	        
	        return count;
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
