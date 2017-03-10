package binarySearchTrees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestBST2 {
	
	public List<Integer> closestVals(BinarySearchTreeNode root,int target,int k){
		
		int min=Integer.MAX_VALUE;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new ReverseComp());
		while(root!=null){
			
			if(root.data>target){
				int diff = target-root.data;
				if(pq.size()<k)
					pq.add(root.data);
				else if((pq.peek()>root.data)){
					pq.remove();
					pq.add(root.data);
				}
				root=root.leftNode;
			}else if(root.data<target){
				int diff = target-root.data;
				if(pq.size()<k)
					pq.add(root.data);
				else if((pq.peek()>root.data)){
					pq.remove();
					pq.add(root.data);
				}
				root=root.rightNode;		
			}else{
				if(pq.size()<k)
					pq.add(root.data);
				else if((pq.peek()>root.data)){
					pq.remove();
					pq.add(root.data);
				}	
							
			}
		}
		
		return new ArrayList<Integer>(pq);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class ReverseComp implements Comparator<Integer>{

	@Override
	public int compare(Integer arg0, Integer arg1) {
		// TODO Auto-generated method stub
		return arg1-arg0;
	}
	
}