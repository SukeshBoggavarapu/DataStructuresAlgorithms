package strings;

public class UniqueString {
	
	public boolean isCharsUnique(String s){
		
		int res=0;
		for(int i=0;i<s.length();i++){
			
			int val = s.charAt(i)-'a';
			if((res & (1<<val))!=0)
				return false;
			res=(res | (1<<val));
			
		}
		
		return true;
		
	}
	
	public static void main(String[] args){
		
		UniqueString us = new UniqueString();
		System.out.println(us.isCharsUnique("sukejh"));
	}

}

