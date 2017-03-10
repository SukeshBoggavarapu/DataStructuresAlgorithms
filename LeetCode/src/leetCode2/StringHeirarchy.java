package leetCode2;

import java.util.ArrayList;
import java.util.List;

public class StringHeirarchy {
	
	public List<String> stringHeirarchy(int n){
		
		List<String> res = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		char caps = 'A';
		char small = 'a';
		for(int i=0;i<6;i++){
			
			if(i%2==0)
				sb.append(caps++);
			else
				sb.append(small++);
			
			
		}
		
		char[] order = sb.toString().toCharArray();
		sb.delete(0, sb.length());
		backtrack(res,sb,order,n,0);
		return res;
		
		
	}
	
	public void backtrack(List<String> res,StringBuilder sb,char[] order,int n,int start){
		
		if(sb.length()==n){
			
			res.add(new String(sb));
			
		}
		
		for(int i=start;i<order.length;i++){
			
			sb.append(order[i]);
			backtrack(res,sb,order,n,i+1);
			sb.deleteCharAt(sb.length()-1);
			
		}
		
	}
	
	public static void main(String[] args){
		
		StringHeirarchy sh = new StringHeirarchy();
		sh.stringHeirarchy(3);
		System.out.println("Hai");
		
	}
	

}
