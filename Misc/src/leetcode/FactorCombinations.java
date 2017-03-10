package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
	
	
	public List<List<Integer>> factors(int n){
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		backtrack(res,new ArrayList<Integer>(),2,1,n);
		return res;
		
	}
	
	public void backtrack(List<List<Integer>> res, List<Integer> temp,int start,int product,int n){
		
		if(product==n){
			
			res.add(new ArrayList<Integer>(temp));
			
		}
		
		if(product>n || start >n)
			return;
		
		for(int i=start;i<n;i++){
			
			if(n%i==0){
				
				temp.add(i);
				backtrack(res,temp,i,product*i,n);
				temp.remove(temp.size()-1);
				
			}
			
			
		}
		
		
	}

}
