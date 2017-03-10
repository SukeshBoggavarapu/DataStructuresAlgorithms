package leetCode2;

import java.util.ArrayList;
import java.util.List;

public class GetPermutation {
	
	int count =0;
	String res="";
    public String getPermutation(int n, int k) {
    	
        backtrack(n,new ArrayList<Integer>(),k);
        return res;
        
    }
    
    public void backtrack(int n,List<Integer> tempList,int k){
        
        if(tempList.size()==n){
            count++;
            if(count==k){
            	
            	for(int i=0;i<tempList.size();i++)
            		res=res+tempList.get(i);
            	
            }
        }
        
        for(int i=1;i<=n;i++){
            
            if(tempList.contains(i)) continue;
            tempList.add(i);
            backtrack(n,tempList,k);
            tempList.remove(tempList.size()-1);
            
        }
    }


	public static void main(String[] args) {
		GetPermutation gp = new GetPermutation();
		gp.getPermutation(2, 2);
	}

}
