package dpCTC;

import java.util.ArrayList;
import java.util.List;

public class NPairsOfParantheses {
	
	public List<String> getParanthesis(int n){
		
		if(n==0)
			return null;
		List<String> list = new ArrayList<String>();
		list.add("()");
		if(n==1)
			return list;
		int size =0;
		for(int i=2;i<=n;i++){
			
			size = list.size();
			list.add(list.get(0)+"()");
			for(int j=0;j<size;j++){
				
				String cur = list.get(j);
				
				for(int k=0;k<cur.length();k++){
					
					if(cur.charAt(k)=='('){
						String start = cur.substring(0, k+1);
						String end = cur.substring(k+1);
						String insert = start + "()" +end;
						if(!list.contains(insert))
							list.add(insert);	
					}
					
				}
				
			}
				
			list= list.subList(size, list.size());	
		}
		return list;
	}

	public static void main(String[] args) {
		
		NPairsOfParantheses np = new NPairsOfParantheses();
		List<String> list = np.getParanthesis(4);
		System.out.println();
	}

}
