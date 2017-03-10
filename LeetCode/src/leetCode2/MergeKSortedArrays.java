package leetCode2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
	
	class Value{
		int arrayIndex;
		int data;
		int valIndex;
		
		public Value(int arrayIndex,int data,int valIndex){
			
			this.arrayIndex=arrayIndex;
			this.data = data;
			this.valIndex=valIndex;
		}
	}
	
	class MyComp implements Comparator<Value>{

		@Override
		public int compare(Value v1 , Value v2){
			return v1.data-v2.data;
			
		}
		
		
	}
	
	public int[] mergeSortedArrays(int[][] nums){
		
		PriorityQueue<Value> pq = new PriorityQueue<Value>(new MyComp());
		for(int i=0;i<nums.length;i++){
			pq.add(new Value(i,nums[i][0],0));		
		}
		
		int[] res = new int[nums.length*nums[0].length];
		int index=0;
		while(!pq.isEmpty()){
			
			Value val = pq.poll();
			res[index++]=val.data;
			if(val.valIndex<nums[0].length-1){
			Value newVal = new Value(val.arrayIndex,nums[val.arrayIndex][val.valIndex+1],val.valIndex+1);
			pq.add(newVal);
			}	
		}
		
		return res;
	}

	public static void main(String[] args) {
		MergeKSortedArrays msa = new MergeKSortedArrays();
		int[] res = msa.mergeSortedArrays(new int[][]{{6,7,8},{5,9,16},{1,10,12}});
		System.out.println();
	}

}
