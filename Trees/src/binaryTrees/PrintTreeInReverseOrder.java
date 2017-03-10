package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintTreeInReverseOrder {
	
	public static void printTree(BinaryTreeNode node){
		
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		Stack<Integer>stack = new Stack<Integer>();
		queue.offer(node);
		
		BinaryTreeNode temp;
		
		while(!queue.isEmpty()){
			temp= queue.poll();
			stack.push(temp.getData());
			
			if(temp.getRightNode()!=null){
				queue.offer(temp.getRightNode());
			}
			
			if(temp.getLeftNode()!=null){
				queue.offer(temp.getLeftNode());
			}
		}
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}

	public static void main(String[] args) {
		
		printTree(BinaryTreeNode.createTree());

	}

}
