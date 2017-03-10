package strings;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
    
    class TrieNode{
        
        TrieNode[] neighbours;
        String word;
        
        public TrieNode(){
            
            neighbours = new TrieNode[26];
        }
    } 
    
    
    class Trie{
        
        TrieNode root;
        
        public Trie(){
            root = new TrieNode();
        }
        
        public void insert(String word){
            
            TrieNode temp = root;
            for(int i=0;i<word.length();i++){
                
                int index = word.charAt(i)-'a';
                if(temp.neighbours[index]==null)
                    temp.neighbours[index] = new TrieNode();
                temp = temp.neighbours[index];
                
            }
            temp.word=word;
            
        }   
    }
    
    public List<String> findWords(char[][] board, String[] words) {
    	
    	Trie root = new Trie();
    	
    	for(int i=0;i<words.length;i++){
    		root.insert(words[i]);
    	}
    	TrieNode rootNode = root.root;
    	
    	List<String> res = new ArrayList<String>();
    	
    	for(int i=0;i<board.length;i++){
    		
    		for(int j=0;j<board[0].length;j++){
    			
    			dfs(board,i,j,rootNode,res);
    			
    		}
    		
    	}
        
        return res; 
    }

	public void dfs(char[][] board, int i, int j, TrieNode rootNode, List<String> res) {
		
		char c = board[i][j];
		
		if(c=='#' || rootNode.neighbours[c-'a']==null)
			return;
		
		rootNode = rootNode.neighbours[c-'a'];
		
		if(rootNode.word!=null){
			res.add(rootNode.word);
			rootNode.word=null;
		}
		
		board[i][j]='#';
		if(i>0) dfs(board,i-1,j,rootNode,res);
		if(j>0) dfs(board,i,j-1,rootNode,res);
		if(i<board.length-1) dfs(board,i+1,j,rootNode,res);
		if(j<board[0].length-1) dfs(board,i,j+1,rootNode,res);
		board[i][j]=c;
		
	}
	
	public static void main(String[] args){
		
		WordSearch2 ws2 = new WordSearch2();
		List<String> list = ws2.findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}}, new String[]{"oath","pea","eat","rain"});
		System.out.println();
	}
}
