/*package leetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SubstringWithContatenation {

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res= new ArrayList<Integer>();
		Trie trie = new Trie();
		Map<String,Integer> map = new TreeMap<String,Integer>(new myComp());
		for(int i=0;i<words.length;i++){
			trie.addWord(words[i]);
			if(map.containsKey(words[i])){
				map.put(words[i], map.get(words[i])+1);
			}
			map.put(words[i], 1);
		}
		Map<String,Integer> cmap =map;
		int startIndex=0;
		TrieNode cur = trie.root;
		Set<String> set = new HashSet<String>();
		for(int i=0;i<s.length();){
			int val = s.charAt(i)-'a';
			if(cur.neighbours[val]!=null && cur.word==null){
				cur=cur.neighbours[val];
				i++;
			}else if(cur.word!=null){
				cmap.put(cur.word, map.get(cur.word)-1);
				if(cmap.get(cur.word)<0){
					i=startIndex+1;
					startIndex=i;
					cmap=map;
				}
				
				if(!set.add(cur.word)){	
					i=startIndex+1;
					startIndex=i;
					set.clear();
				}
				if()
				if(set.size()==words.length){
					res.add(startIndex);
					set.clear();
					i=startIndex+1;
				}
				
				cur=trie.root;
				
				
			}else {
				startIndex=++i;
				cur=trie.root;
				set.clear();
			}
		}
		return res;
	}

	public static void main(String[] args) {
		SubstringWithContatenation swc = new SubstringWithContatenation();
		List<Integer> list = swc.findSubstring("barfoothefoobarman", new String[]{"foo","bar"});
		System.out.println("--");
	}

}

class myComp implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}

class TrieNode {

	TrieNode[] neighbours;
	String word;

	public TrieNode() {
		neighbours = new TrieNode[26];
		word = null;
	}
}

class Trie {

	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void addWord(String s) {

		TrieNode temp = root;

		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 'a';
			if (temp.neighbours[index] == null)
				temp.neighbours[index] = new TrieNode();
			temp = temp.neighbours[index];
		}
		temp.word=s;
		//return temp;

	}
	
	public void addWords(String[] words,int index) {

		TrieNode temp = root;
		
		temp =addWord(words[index],temp);

		for (int i = 0; i < words.length; i++) {
			if(i!=index)
				temp = addWord(words[i],temp);
		}

		temp.isEnd = true;

	}
}
*/