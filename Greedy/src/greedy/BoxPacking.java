package greedy;

import java.util.HashMap;
import java.util.Map;

import sorts.MergeSort;


public class BoxPacking {
	
	public static Map<Integer,Integer> boxPack(int[] capacity,int[] itemsSize){
		
		MergeSort.mergeSort(capacity);
		MergeSort.mergeSort(itemsSize);
		
		Map<Integer,Integer> boxMap = new HashMap<Integer,Integer>();
		
		int k=0;
		for(int i=0;i<capacity.length;i++){
			
			if(itemsSize[k]<=capacity[i]){
				
				boxMap.put(capacity[i],itemsSize[k]);
				k++;
			}
			
		}
		
		return boxMap;	
	}
	
	public static void main(String[] args){
		
		int[] capacities =new int[]{25,40,60,12,15};
		int[] sizes =new int[]{42,45,16,20,19,17};
		
		Map<Integer,Integer> boxVal =boxPack(capacities,sizes);
		
	for (Integer val : boxVal.keySet()) {
			
			System.out.println("Box is "+ val + " -- Item :" + boxVal.get(val));
			
		}
		
		
	}

}
