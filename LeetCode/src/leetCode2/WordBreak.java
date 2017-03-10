package leetCode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
	

    public boolean wordBreak(String s, List<String> wordDict) {
    	
    	boolean[] dp = new boolean[s.length()+1];
    	dp[0]=true;
    	
    	for(int i=0;i<s.length()+1;i++){
    		
    		for(int j=0;j<i;j++){
    			
    			if(dp[j] && wordDict.contains(s.substring(j,i)))
    				dp[i]=true;
    			
    		}
    		
    	}
    	
    	return dp[s.length()];
    	
    }


	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		System.out.println(wb.wordBreak("aaaaaaa", new ArrayList<String>(Arrays.asList("aaaa","aaa"))));
		
	}

}
