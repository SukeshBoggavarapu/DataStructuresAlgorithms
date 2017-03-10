package arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {
	
	public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
       list.add(1);
       if(rowIndex==0){
           return list;
       }
   
    int sum =0;
    for(int i=1;i<=rowIndex;i++){
        
        for(int j=i-1;j>0;j--){
           
           sum= list.get(j-1)+list.get(j);
           list.set(j,sum);
            
        }
        
        list.add(1);
    }
    
    return list;
       
   }

}
