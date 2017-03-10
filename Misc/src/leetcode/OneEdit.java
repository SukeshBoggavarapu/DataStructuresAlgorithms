package leetcode;

public class OneEdit {
	
	//S has to be converted to t
	public boolean oneEdit(String s,String t){
		
		if(s==null && t==null)
			return true;
		else if(s==null || t==null)
			return false;
		if(Math.abs(s.length()-t.length())>=2)
			return false;
		int j=0;
		int i=0;
	    while(i<s.length() && j<t.length()){
			if(s.charAt(i)==t.charAt(j)){
				i++;
				j++;
			}
			else
			{
				break;
			}
			
		}
	    
		if(s.length()<t.length() && isPossible(i,j+1,s,t))
			return true;
		else if(s.length()>t.length() && isPossible(i+1,j,s,t))
			return true;
		else if(s.length()==t.length() && isPossible(i+1,j+1,s,t))
			return true;
		else 
			return false;
		
	}
	
	public boolean isPossible(int i,int j,String s,String t){
		
		while(i<s.length() && j<t.length()){
			
			if(s.charAt(i)!=t.charAt(j))
				return false;
			i++;j++;
		}
		return true;
		
	}


	public static void main(String[] args) {
		OneEdit oe = new OneEdit();
		System.out.println(oe.oneEdit("feek", "geek"));
	}

}
