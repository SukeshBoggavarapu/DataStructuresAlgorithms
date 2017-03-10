package strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {
	
	
	public int longestSubstringWithoutRepeatingChars(String s){
		
		if(s==null || s.length()==0)
			return 0;
		int startIndex =0;
		int endIndex;
		int max=0;
		Map<Character,Integer> map = new HashMap<Character,Integer>();	
		for(int i=0;i<s.length();++i){
			
			if(map.containsKey(s.charAt(i))){
				endIndex = map.get(s.charAt(i));
				startIndex = Math.max(startIndex,endIndex+1);
			}
			map.put(s.charAt(i), i);
			if(max<i-startIndex+1)
				max= i-startIndex+1;
			
		}
		return max;
	}
	

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingChars lswc = new LongestSubstringWithoutRepeatingChars();
		System.out.println(lswc.longestSubstringWithoutRepeatingChars("tmmzuxt"));
	}

}
