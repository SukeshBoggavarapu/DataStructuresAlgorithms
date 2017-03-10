package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfLeaves {
	
	public static int numberOfLeaves(BinaryTreeNode node){
		
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(node);
		BinaryTreeNode temp =null;
		int count =0;
		while (!queue.isEmpty()){
			temp = queue.poll();
			
			if(temp.getLeftNode()==null && temp.getRightNode()==null){
				System.out.println(temp.getData());
				count++;
			}
			if(temp.getRightNode()!=null){
				queue.offer(temp.getRightNode());
			}
			
			if(temp.getLeftNode()!=null){
				queue.offer(temp.getLeftNode());
			}
		}
		
		return count;
		
	} 

	public static void main(String[] args) {
		
		System.out.println(numberOfLeaves(BinaryTreeNode.createTree()));

	}

}
