package leetCode;

import java.util.Stack;

import binaryTrees.BinaryTreeNode;

public class LargestBST {
	
	public static int largestBST(BinaryTreeNode root){
		
		if(isBST(root))
			return size(root);
		
		return Math.max(largestBST(root.leftNode), largestBST(root.rightNode));
		
	}
	
	public static boolean isBST(BinaryTreeNode root){
		
		return isBSTTree(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
		
	}
	
	public static boolean isBSTTree(BinaryTreeNode node,int min,int max){
		
		if(node==null)
			return true;
		
		if(node.data<min || node.data>max)
			return false;
		
		return (isBSTTree(node.leftNode,min,node.data) && isBSTTree(node.rightNode,node.data,max));
		
	}
	
	public static int size(BinaryTreeNode root){
		
		int size =0;
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		
		stack.push(root);
		while(!stack.isEmpty()){
			
			BinaryTreeNode node = stack.pop();
			size++;
			
			if(node.rightNode!=null)
				stack.push(node.rightNode);
			if(node.leftNode!=null)
				stack.push(node.leftNode);
			
			
		}
		
		return size;
		
	}
	
	
	public static void main(String[] args){
		
		System.out.println(largestBST(BinaryTreeNode.createTree4()));
	}

}
