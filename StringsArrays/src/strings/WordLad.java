package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLad {
	

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        
        wordList.add(endWord);
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put(beginWord,1);
        
        while(!queue.isEmpty()){
            
        String curStr = queue.poll();
        if(curStr.equalsIgnoreCase(endWord))
            return map.get(endWord);
            
        char[] begin = curStr.toCharArray();    
        
        for(int i=0;i<begin.length;i++){
            
            char cur = begin[i];
            char temp='a';
            while(temp<='z'){
               if(temp!=cur){ 
                begin[i]=temp;
                String cstr = new String(begin);
                if(wordList.remove(cstr)){
                	map.put(cstr,map.get(curStr)+1);
                    queue.add(cstr);
                }
            }
               temp++;
            }
            begin[i]=cur;
            
        }
        
    }
    
    return 0;
        
    }


	public static void main(String[] args) {
		WordLad wl = new WordLad();
		System.out.println(wl.ladderLength("a", "c", new HashSet<String>(Arrays.asList("a","b","c"))));
	}

}
