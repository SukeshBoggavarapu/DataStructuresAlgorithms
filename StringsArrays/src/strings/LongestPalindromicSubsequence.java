package strings;

import java.util.Collections;
import java.util.TreeMap;

public class LongestPalindromicSubsequence {
	
	
	public void longestPalindromicSubstring(String s){
		
		if(s==null || s.length()==0)
			return;
		
		StringBuffer sb = new StringBuffer(s);
		String srev = sb.reverse().toString();
		
		Sequence[][] carr = new Sequence[s.length()+1][s.length()+1];
		
		for (int i=0;i<s.length()+1;i++){
			carr[i][0] = new Sequence('E',0);
		}
		for (int j=0;j<s.length()+1;j++){
			carr[0][j] = new Sequence('E',0);
		}
		int i=1;int j=1;
		for (;i<s.length()+1;i++){
			
			for(;j<srev.length()+1;j++){
				
				if(s.charAt(i-1)==srev.charAt(j-1)){
					carr[i][j]= new Sequence('I',carr[i-1][j-1].count+1);
				}else if(carr[i-1][j].count>=carr[i][j-1].count){
					carr[i][j]= new Sequence('U',carr[i-1][j].count);
				}else if(carr[i-1][j].count<carr[i][j-1].count){
					carr[i][j]= new Sequence('L',carr[i][j-1].count);
				}
				
			}
			j=1;
		}
		
		i=s.length();
		j=s.length();
		while(carr[i][j].c!='E'){
			
			if(carr[i][j].c=='I'){
				System.out.print(s.charAt(i-1));
				i--;j--;
			}else if(carr[i][j].c=='U'){
				i--;
			}else if(carr[i][j].c=='L'){
				j--;
			}
			
		}
		
	}
	
	class Sequence{
		
		char c;
		int count;
		
		public Sequence(Character c,int count){
			this.c=c;
			this.count=count;
		}
	}

	public static void main(String[] args) {
		
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		lps.longestPalindromicSubstring("aaabaaaa");
	}

}
