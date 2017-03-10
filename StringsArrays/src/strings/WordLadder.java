package strings;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WordLadder {
	
	public static int length(String beginWord,String endWord,Set<String> dict){
		
		WordNode startNode = new WordNode(beginWord);
		startNode.setSteps(1);
		
		dict.add(endWord);
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
		queue.add(startNode);
		while(!queue.isEmpty()){
			WordNode current =queue.remove();
			String top = current.getWord();
			if(top.equalsIgnoreCase(endWord)){
				return current.getSteps();
			}
		char[] topA = top.toCharArray();
		
		for(int i=0;i<topA.length;i++){
			char temp = topA[i];
			for(char c ='a';c<='z';c++){
				
				topA[i] =c;
				
				String newWord = new String(topA);
				
				if(dict.contains(newWord)){
					WordNode newWordNode = new WordNode(newWord);
					newWordNode.setSteps(current.getSteps()+1);
					queue.add(newWordNode);
					dict.remove(newWord);					
				}
				
				
			}
			topA[i]=temp;
			
		}
		}
		
		return 0;
	}
	
	public static void main(String[] args){
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		dict.add("pot");
		System.out.print(length("hit","cog",dict));
		
		
		
		
	}

}