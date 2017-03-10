package leetCode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupAnagrams {
	

    public List<List<String>> groupAnagrams(String[] strs) {
        
        Set<String> set = new HashSet<String>(Arrays.asList(strs));
        List<List<String>> res = new ArrayList<List<String>>();
        for(int i=0;i<strs.length;i++){
            
            if(!set.contains(strs[i])) continue;
            List<String> list =generatePermutations(strs[i]);
            List<String> curList = new ArrayList<String>();
            for(int j=0;j<list.size();j++){
            	
                if(set.contains(list.get(j))){
                    curList.add(list.get(j));
                    set.remove(list.get(j));
                }
            	
            }
            res.add(curList);
            
        }
        
        return res;
        
    }
    
    public List<String> generatePermutations(String str){
        List<String> res = new ArrayList<String>();
        char[] carr = str.toCharArray();
        Arrays.sort(carr);
        backtrack(res,new char[carr.length],0,carr,new boolean[carr.length]);
        return res;
    }
    
    public void backtrack(List<String> res,char[] temp,int index,char[] carr,boolean[] used){
        
        if(index==carr.length){
            res.add(new String(temp));
            return;
        }
        for(int i=0;i<carr.length;i++){
            if(used[i] || (i>0 && carr[i]==carr[i-1] && used[i-1])) continue;
            used[i]=true;
            temp[index++]=carr[i];
            backtrack(res,temp,index,carr,used);
            used[i]=false;
            index--;
        }
        
        
    }
    //Better Method than 1st
    public List<List<String>> groupAnags(String[] strs){
    	
    	if(strs==null || strs.length==0)
    		return new ArrayList<List<String>>();
    	Map<String,List<String>> map = new HashMap<String,List<String>>();
    	
    	for(int i=0;i<strs.length;i++){
    		char[] carr= strs[i].toCharArray();
    		Arrays.sort(carr);
    		String s = new String(carr);
    		if(map.containsKey(s)){
    			map.get(s).add(strs[i]);
    		}else{
    			map.put(s, new ArrayList<String>(Arrays.asList(strs[i])));
    		}	
    	}
    	
    	for(Map.Entry<String, List<String>> entry : map.entrySet()){
    		Collections.sort(entry.getValue());
    	}
    	
    	return new ArrayList<List<String>>(map.values());
    	
    }
    
    public List<List<String>> groupingAnagrams(String[] strs){
    	
    	if(strs==null || strs.length==0)
    		return new ArrayList<List<String>>();
    	Map<Integer,List<String>> map = new HashMap<Integer,List<String>>();
    	int[] primes = new int[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
    	for(int i=0;i<strs.length;i++){
    		
    		char[] carr = strs[i].toCharArray();
    		int key=1;
    		for(int j=0;j<carr.length;j++){
    			key=key*primes[(carr[j]-'a')];
    		}
    		if(map.containsKey(key)){
    			map.get(key).add(strs[i]);
    		}else{
    			map.put(key,new ArrayList<String>(Arrays.asList(strs[i])));
    		}
    		
    	}
    	
    	return new ArrayList<List<String>>(map.values());
    	
    }
     
    

	public static void main(String[] args) {
		GroupAnagrams ga = new GroupAnagrams();
		//ga.groupAnagrams(new String[]{"accd","dcca","ccad","eat","fat","ate","ab","ba"});
		//List<List<String>> res = ga.groupAnags(new String[]{"accd","dcca","ccad","eat","fat","ate","ab","ba"});
		List<List<String>> res = ga.groupingAnagrams(new String[]{"accd","dcca","ccad","eat","fat","ate","ab","ba"});
		System.out.println();
	}

}
