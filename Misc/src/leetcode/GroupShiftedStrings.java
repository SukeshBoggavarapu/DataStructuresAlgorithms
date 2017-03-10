package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
	
	public List<List<String>> groupShift(String[] words){
		
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		for(String word : words){
			
			int offset = word.charAt(0)-'a';
			String cur="";
			for(int i=0;i<word.length();i++){
				
				char c = (char) (word.charAt(i)-offset);
				if(c<'a')
					c+=26;
				cur+=c;
			}
			
			if(!map.containsKey(cur)){
				List<String> list = new ArrayList<String>();
				map.put(cur, list);
			}
			map.get(cur).add(word);
			
		}
		
		return new ArrayList<List<String>>(map.values());
		
	}
	
	public static void main(String[] args){
		
		GroupShiftedStrings gss = new GroupShiftedStrings();
		List<List<String>> result = gss.groupShift(new String[]{"abc","bcd","xyz","az","ba","acef","a","z"});
		System.out.println(result);
		
	}

}
