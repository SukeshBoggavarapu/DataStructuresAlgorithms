package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {
	
	
	public List<String> letterCombinations(String s){
		
		 Map<Integer,List<String>> map = constructMap();
		
		List<String> temp = new ArrayList<String>(map.get(Character.getNumericValue(s.charAt(0))));
		
		
		for(int i=1;i<s.length();i++){
			
			int size = temp.size();
			List<String> curList = new ArrayList<String>(map.get(Character.getNumericValue(s.charAt(i))));
			for(int j=0;j<size;j++){
				
				for(int k=0;k<curList.size();k++){
					
					temp.add(temp.get(j)+curList.get(k));
					
				}
			}
			
			temp = temp.subList(size, temp.size());
			
		}
		return temp;
		
		
	}
	
	   public Map<Integer,List<String>> constructMap(){
	        
	        Map<Integer,List<String>> map = new HashMap<Integer,List<String>>(); 
	        char alphabet ='a';
	        int count =1;
	        for (int i=2;i<=9;i++){
	        	List<String> list = new ArrayList<String>();
	            while(count<=3){
	            	list.add(Character.toString(alphabet));
	            	alphabet++;
	            	count++;
	            }
	            if(i==7 || i==9){
	            	list.add(Character.toString(alphabet));
	            	alphabet++;
	            }
	            count=1;
	            map.put(i, list);
	            
	        }
	        
	        return map;
	        
	    }
	   
	   
	  public static void main(String[] args){
		  
		  LetterCombinationsOfPhoneNumber lcp = new LetterCombinationsOfPhoneNumber();
		  lcp.letterCombinations("22");
		  
	  }

}
