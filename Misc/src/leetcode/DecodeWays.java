package leetcode;

public class DecodeWays {
	
	public int decodeWays(String s){
		
		if(s==null || s.length()==0 || (s.length()>0 && s.charAt(0)=='0')){
			return 0;
		}
		if(s.length()==1)
			return 1;
		
		int[] ways = new int[s.length()+1];
		ways[0]=1;
		if(s.charAt(1)=='0'){
			if(s.charAt(0)>'2')
				return 0;
			else
				ways[1]=1;
		}else if(valid(1,s)){
			ways[1]=2;
		}else
			ways[1]=1;
		
		for(int i=2;i<s.length();i++){
			
			if(s.charAt(i)=='0'){
				
				if(s.charAt(i-1)=='1' || s.charAt(i-1)=='2')
					ways[i]=ways[i-2];
				else
					return 0;
			}else if(s.charAt(i-1)=='0'){
				ways[i]=ways[i-1];	
			}else if(valid(i,s)){
				ways[i]=ways[i-1]+ways[i-2];
			}else
				ways[i]=ways[i-1];
			
		}
		
		return ways[s.length()-1];
		
	}
	
	public boolean valid(int index,String s){
		
		if(s.charAt(index-1)>'2')
			return false;
		else if(s.charAt(index-1)=='2' && s.charAt(index)>'6')
			return false;
		return true;
		
	}


	public static void main(String[] args) {
		DecodeWays dw = new DecodeWays();
		System.out.println(dw.decodeWays("301"));
	}

}
