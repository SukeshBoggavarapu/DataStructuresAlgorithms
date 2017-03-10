package leetcode;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinations {
	
	String[] combs = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public List<String> letterCombinations(String input){
		
		LinkedList<String> res = new LinkedList<String>();
		res.offer("");
		for(int i=0;i<input.length();i++){
			
			int val = Character.getNumericValue(input.charAt(i));
			char[] letters = combs[val].toCharArray();
			while(res.peek().length()==i){
				String alpha = res.remove();
				for(char c: letters){
					res.add(alpha+c);
				}
			}
			
			
		}
		
		return res;
	}

}
