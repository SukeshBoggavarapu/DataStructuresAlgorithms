package leetCode2;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	
	public boolean wordPattern(String pattern,String str){
		
		String[] strs = str.split(" ");
		Map index = new HashMap();
		if(pattern.length()!=strs.length) return false;
		for(Integer i=0;i<pattern.length();i++){
			Integer val1 = (Integer) index.put(pattern.charAt(i),i);
			Integer val2 = (Integer) index.put(strs[i],i);
			if(val1!= val2) {
				System.out.println();
				return false;
			}
				
			
		}
		
		return true;
		
	}

	public static void main(String[] args) {
		WordPattern wp = new WordPattern();
		System.out.println(wp.wordPattern("abbba", "a c c c a"));
	}

}
