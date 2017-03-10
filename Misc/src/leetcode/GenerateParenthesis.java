package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	
	
	public List<String> generateParan(int n){
	List<String> res = new ArrayList<String>();
		
	 generate(res,new StringBuilder(),0,0,n);
	 return res;
	 
	}
	
	public void generate(List<String> res, StringBuilder temp,int open,int close,int n){
		
		if(temp.length()==2*n){
			res.add(temp.toString());
			return;
		}
		
		if(open<n){
			generate(res,temp.append("("),open+1,close,n);
			temp.deleteCharAt(temp.length()-1);
		}
		if(close<open){
			generate(res,temp.append(")"),open,close+1,n);
			temp.deleteCharAt(temp.length()-1);
		}
		
	}
	
	public static void main(String[] args){
		
		GenerateParenthesis gp = new GenerateParenthesis();
		gp.generateParan(3);
		
	}

}