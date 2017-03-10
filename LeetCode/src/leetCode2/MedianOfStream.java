package leetCode2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfStream {
	
class MyComp implements Comparator<Integer>{
		
		@Override
		public int compare(Integer i1 , Integer i2){
			
			return i2-i1;
			
		}
		
	}
	
	public int medianOfStream(int[] nums){
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new MyComp());		
		for (int i=0;i<nums.length;i++){
			
			System.out.println(median(nums[i],minHeap,maxHeap));
			
			
		}
		
		return 0;
		
	}
	
	
	public int median(int val,PriorityQueue<Integer> min,PriorityQueue<Integer> max){
		
		if(min.isEmpty() || val<min.peek()){
			max.add(val);	
		}else{
			min.add(val);
		}
		
		if(min.size()>max.size()+1){
			max.add(min.poll());	
		}else if(max.size()>min.size()+1){
			min.add(max.poll());
		}
		
		return min.size()==max.size() ? (min.peek()+max.peek())/2 : (min.size()>max.size() ? min.peek() : max.peek());
		
		
	}
	
	public static void main(String[] args){
		
		MedianOfStream mos = new MedianOfStream();
		mos.medianOfStream(new int[]{2,4,1,8,5,0,6});
		
	}
	
}


