package leetCode;

import java.util.HashMap;

public class RansomNote {
	
public boolean canConstruct(String ransomNote, String magazine) {
        
        if(ransomNote.length()==0){
            return true;
        }
        
        if(magazine.length()==0){
            return false;
        }
        
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        
        for(int i=0;i<magazine.length();i++){
            char key = magazine.charAt(i);
            if(!map.containsKey(key)){
                map.put(key,1);
            }else {
                map.put(key,map.get(key)+1);
            }
        }
        
        for(int j=0;j<ransomNote.length();j++){
            char keyNote = ransomNote.charAt(j);
            if(map.containsKey(keyNote) && map.get(keyNote)>0){
                map.put(keyNote,map.get(keyNote)-1);
            }else{
                return false;
            }
        }
        
        return true;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
