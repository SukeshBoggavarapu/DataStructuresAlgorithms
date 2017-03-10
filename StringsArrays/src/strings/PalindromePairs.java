package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {
	
	public List<List<Integer>> palindromePairs(String[] words){
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(int i=0;i<words.length;i++){
			
			map.put(words[i],i);
		}
		
		for(int i=0;i<words.length;i++){
			
			for(int j=0;j<=words[i].length();j++){
				
				String s1 = words[i].substring(0, j);
				String s2 = words[i].substring(j);
				
				if(isPalindrome(s1)){
					
					String strRev = reverse(s2);
					if(map.containsKey(strRev)){
						if(map.get(strRev)!=i){
						List<Integer> list = new ArrayList<Integer>();
						list.add(map.get(strRev));
						list.add(i);			
						res.add(list);
						}			
					}	
				}
				
				if(isPalindrome(s2)){
					
					String strRev = reverse(s1);
					if(map.containsKey(strRev) && s2.length()!=0){
						if(map.get(strRev)!=i){
						List<Integer> list = new ArrayList<Integer>();
						list.add(i);
						list.add(map.get(strRev));			
						res.add(list);
						}
						
					}
					
				}
				
			}
			
		}
		
		return res;
		
	}
	
	public boolean isPalindrome(String word){
		
		
		int i=0;
		int j= word.length()-1;
		while(i<j){
			if(word.charAt(i)!=word.charAt(j))
				return false;
			i++;
			j--;
		}
		
		return true;
		
	}
	
	public String reverse(String word){
		
		char[] wordArr = word.toCharArray();
		
		int i=0;
		int j=word.length()-1;
		char temp;
		while(i<j){
			
			temp = wordArr[i];
			wordArr[i]=wordArr[j];
			wordArr[j]=temp;
			i++;
			j--;
			
		}
		
		return new String(wordArr);
		
	}
	

	public static void main(String[] args) {
		
		PalindromePairs pp = new PalindromePairs();
		pp.palindromePairs(new String[]{"a",""});
	}

}
