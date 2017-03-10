package strings;

public class WordDictionary {
		
		TrieNode root;
		
		public WordDictionary(){
			root = new TrieNode();
		}
		
		public void addWord(String word){
			
			TrieNode temp =root;
			
			for(int i=0;i<word.length();i++){
				
				int index = word.charAt(i)-'a';
				if(temp.neighbours[index]==null)
					temp.neighbours[index]=new TrieNode();
				temp=temp.neighbours[index];
			}
			
			temp.isEnd=true;
			
		}
		
		public boolean searchWord(TrieNode temp ,String word){
			
			
			for(int i=0;i<word.length();i++){
				
				if(word.charAt(i)=='.'){
					
					for(int j=0;j<26;j++){
						
						if(temp.neighbours[j]!=null){
							if(searchWord(temp.neighbours[j],word.substring(i+1))){
								return true;
							}
						}	
					}
					return false;
					
				}else {
					
					int index = word.charAt(i)-'a';
					if(temp.neighbours[index]==null)
						return false;
					temp=temp.neighbours[index];
				}
			}
			
			return temp.isEnd;
		}
		
	
	
	public static void main(String[] args){
		
		WordDictionary wd = new WordDictionary();
		wd.addWord("a");
		wd.addWord("a");
		TrieNode temp =wd.root;
		System.out.println(wd.searchWord(temp, "."));
		System.out.println(wd.searchWord(temp, "a"));
		System.out.println(wd.searchWord(temp, "aa"));
		System.out.println(wd.searchWord(temp, "a"));
		System.out.println(wd.searchWord(temp, ".a"));
		System.out.println(wd.searchWord(temp, "a."));
		
	}

}

class TrieNode{
	
	TrieNode[] neighbours; 
	boolean isEnd = false;
	
	public TrieNode(){
		neighbours = new TrieNode[26];
	}
}
