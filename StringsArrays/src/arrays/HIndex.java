package arrays;

import java.util.HashMap;
import java.util.Map;

public class HIndex {
	
	
    public int hIndex(int[] citations) {
        Map<Integer,String> map = new HashMap<Integer,String>();
        int length = citations.length;
     int[] valCount = new int[length+1];
     
     for(int i=0;i<length;i++){
    	 
    	 if(citations[i]>length)
    		 valCount[length]+=1;
    	 else
    		 valCount[citations[i]]+=1;
    	 
     }
     int count =0;
     for(int i=length;i>=0;i--){
    	 count+=valCount[i];
    	 if(count>=i)
    		 return i;
    	
     }
     
     return 0;
        
    }

	public static void main(String[] args) {
		HIndex hi = new HIndex();
		System.out.println(hi.hIndex(new int[]{3, 0, 6, 1, 5}));
	}

}
