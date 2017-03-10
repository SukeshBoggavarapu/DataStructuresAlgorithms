package leetCode;

import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords {
	
	
	class TrieNode{
		
		TrieNode[] neigbours;
		boolean isEnd = false;
		
		public TrieNode(){
			neigbours = new TrieNode[26];
		}
		
	}
	
	
	class Trie{
		
		TrieNode root;
		
		public Trie(){
			root = new TrieNode();
		}
		
		
		public void insertString(String word){
			
			TrieNode temp =root;
			
			for(int i=0;i<word.length();i++){
				
				int index = word.charAt(i)-'a';
				
				if(temp.neigbours[index]==null)
					temp.neigbours[index]  = new TrieNode();
				temp=temp.neigbours[index];
					
			}		
			temp.isEnd=true;	
		}
		
		public boolean searchRange(String word,int startIndex,int endIndex){
			
			TrieNode temp = root;
			
			for(int i=startIndex;i<=endIndex;i++){
				
				int index = word.charAt(i)-'a';
				if(temp.neigbours[index]==null)
					return false;
				temp=temp.neigbours[index];
				
			}
			
			return temp.isEnd;
		}
	}	
		
		public List<String> findAllConcatenatedWordsInADict(String[] words) {
			
			if(words==null || words.length==0)
				return new ArrayList<String>();
			Trie trie = new Trie();
			
			for(int i=0;i<words.length;i++){
				
				trie.insertString(words[i]);
			}
			
			List<String> res = new ArrayList<String>();
			
			for(int i=0;i<words.length;i++){
				
				if(isValidConcatenate(trie,words[i],0,0)){
					res.add(words[i]);
				}
			}
			
			return res;
	        
	    }
		


	public boolean isValidConcatenate(Trie trie, String word, int count, int index) {
		
		if(index==word.length()){		
			if(count>=2)
				return true;
			return false;
		}
		
		for(int i=index;i<word.length();i++){
			
			if(trie.searchRange(word, index, i)){
				
				if(isValidConcatenate(trie,word,count+1,i+1))
					return true;
			}
			
		}
		
		return false;
	}
	
	
	public static void main(String[] args){
		
		ConcatenatedWords cw = new ConcatenatedWords();
		List<String> list = cw.findAllConcatenatedWordsInADict(new String[]{"dog","cat","dogcatdog","tiger","cattiger","dogcatlion"});
		System.out.println();
		
		
	}

}
