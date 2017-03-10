package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak2 {
	
	public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<String>();
        Set<String> setDict = new HashSet<String>(wordDict);
        //Construct Table
        boolean[][] indexes = new boolean[s.length()][s.length()+1];
        int count=0;
        
        for(int i=0;i<indexes.length;i++){
        	
        	for(int j=i;j<indexes[0].length;j++){
        		
        		if(i==j || (setDict.contains(s.substring(i, j)))){
        			indexes[i][j]=true;
        			count++;
        		}
        	}
        
        }
    
        backtrack(res,new ArrayList<String>(),0,s.length(),s,indexes);
        return res; 
    }
	
	public void backtrack(List<String> res,List<String> temp,int start ,int end,String s,boolean[][] indexes){
		
		if(start==end){
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<temp.size();i++){
				sb.append(temp.get(i)+" ");
			}
			res.add(sb.toString().trim());
		}
		int i=start;
		for(int j=i+1;j<end+1;j++){
			
			if(!indexes[i][j]) continue;
			temp.add(s.substring(start,j));
			backtrack(res,temp,j,end,s,indexes);
			temp.remove(temp.size()-1);
			
		}
		
	}
	
	public List<String> wordBreakDFS(String s, List<String> wordDict){
		
		return dfs(s,wordDict,new HashMap<String,List<String>>());
	}
	
	public List<String> dfs(String s , List<String> wordDict, Map<String,List<String>> map){
		
		if(map.containsKey(s))
			return map.get(s);
		List<String> res = new ArrayList<String>();
		
		if(s.length()==0){
			res.add("");
			return res;
		}
		
		for(String word : wordDict){
			
			if(s.startsWith(word)){
				
				List<String> subList = dfs(s.substring(word.length()),wordDict,map);
				for(String sub : subList){
					
					res.add(word+(sub.length()==0 ? "": " ")+ sub);
					
				}
				
			}
			
		}
		
		map.put(s,res);
		
		return res;
		
		
	}
	
	public static void main(String[] args){
		
		WordBreak2 wb2 = new WordBreak2();
		List<String> result = wb2.wordBreakDFS("catsanddog", new ArrayList<String>(Arrays.asList("cat","cats","and","sand","dog")));
		System.out.println("Hai" + result);
	}

}
