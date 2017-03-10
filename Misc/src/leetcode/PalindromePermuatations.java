package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePermuatations {
	
	public List<String> palindromePermutations(String s){
		
		List<String> res = new ArrayList<String>();
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i=0;i<s.length();i++){
			
			char c= s.charAt(i);
			
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);	
			}else
				map.put(c, 1);
			
		}
		boolean isFirst =false;
		StringBuffer cur = new StringBuffer();
		String singlechar ="";
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			
			if(entry.getValue()%2!=0){
				if(!isFirst){
					isFirst=true;
					singlechar+=entry.getKey();
				}
				else
					return res;
			}			
		for(int i=0;i<entry.getValue()/2;i++){
			cur.append(entry.getKey());	
				}
			
		}
		
		backtrack(res,new StringBuilder(),0,cur.length(),cur.toString(),singlechar,new boolean[cur.length()]);
		
		return res;
		
		
	}
	
	public void backtrack(List<String> res, StringBuilder sb,int start, int length,String cur,String singlechar,boolean[] used){
		
		if(sb.length()==length){
			StringBuilder temp = new StringBuilder();
			if(singlechar.length()!=0){	
				temp.append(sb.toString()).append(singlechar).append(sb.reverse().toString());	
			}else{
				temp.append(sb.toString()).append(sb.reverse().toString());	
			}
			res.add(temp.toString());
			
		}
		
		for(int i=0;i<cur.length();i++){
		if(used[i] || (i>0 && cur.charAt(i)==cur.charAt(i-1) && !used[i-1])) continue;
		used[i]=true;
		sb.append(cur.charAt(i));
		backtrack(res,sb,i,length,cur,singlechar,used);
		used[i]=false;
		sb.deleteCharAt(sb.length()-1);	
		}
		
	}
	
	public static void main(String[] args){
		
		PalindromePermuatations pp = new PalindromePermuatations();
		pp.palindromePermutations("aabbc");
		
	}

}
