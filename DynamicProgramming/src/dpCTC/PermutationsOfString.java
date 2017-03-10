package dpCTC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsOfString {
	
	public List<String> permutationsOfString(String s){
		
		if(s.length()==0){
			return null;
		}
		
		List<String> list = new ArrayList<String>();
		list.add(Character.toString(s.charAt(0)));
		if(s.length()==1){	
			return list;
		}
		int size =0;
		for(int i=1;i<s.length();i++){
			
			size = list.size();
			
			for(int j=0;j<size;j++){
				
				String cur = list.get(j);
				for(int k=0;k<=cur.length();k++){
					String start = cur.substring(0, k);
					String end = cur.substring(k,cur.length());
					String str = start + s.charAt(i)+end;
					list.add(str);				
				}
				
			}
			list = new ArrayList<String>(list.subList(size, list.size()));
			
		}
		
		return list;
		
	}
	
	//Using Backtracking
    public List<String> generatePermutations(String str){
        List<String> res = new ArrayList<String>();
        char[] carr = str.toCharArray();
        Arrays.sort(carr);
        backtrack(res,new char[carr.length],0,carr,new boolean[carr.length]);
        return res;
    }
    
    public void backtrack(List<String> res,char[] temp,int index,char[] carr,boolean[] used){
        
        if(index==carr.length){
            res.add(new String(temp));
            return;
        }
        for(int i=0;i<carr.length;i++){
            if(used[i] || (i>0 && carr[i]==carr[i-1] && used[i-1])) continue;
            used[i]=true;
            temp[index++]=carr[i];
            backtrack(res,temp,index,carr,used);
            used[i]=false;
            index--;
        }
        
        
    }

	public static void main(String[] args) {
		
		PermutationsOfString ps = new PermutationsOfString();
		List<String> strings = ps.permutationsOfString("San");
		System.out.println();
		
		
	}

}
