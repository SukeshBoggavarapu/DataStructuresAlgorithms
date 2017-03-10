package strings;

public class Trie {
	
	
	Trie[] links;
	final int ALPHABETS =26;
	boolean isEndOfString ;
	
	public Trie(){
		
		this.links = new Trie[ALPHABETS];
		isEndOfString = false;
	}
	
	public void addString(String s){
		
		Trie t = this;
		int k;
		for (k=0;k<s.length();k++){
			
			int index = s.charAt(k)-'a';
			if(t.links[index] == null){
				t.links[index] = new Trie();
			}
			t= t.links[index];
			
		}
		
		t.isEndOfString=true;
		
	}
	
	public boolean search(String t){
		
		Trie trie = this;
		
		
		for(int k=0;k<t.length();k++){
			
			int index = t.charAt(k)-'a';
			
			if(trie.links[index]==null)
				return false;
			trie=trie.links[index];
			
		}
		return true;
	}
	
	public static void main(String[] args){
		
		Trie trie = new Trie();
		trie.addString("sukesh");
		trie.addString("jack");
		trie.addString("subash");
		System.out.println(trie.search("rose"));
		System.out.println(trie.search("sukesh"));
		System.out.println(trie.search("subash"));
	}
	

}
