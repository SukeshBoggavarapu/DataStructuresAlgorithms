package binarySearchTrees;

import java.util.Stack;

import binaryTrees.BinaryTreeNode;

public class IsBTaBST {
	
	public static boolean isBinaryTreeBST(BinaryTreeNode root){
		
		return isBTaBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
		
	}
	
	public static boolean isBTaBST(BinaryTreeNode root , int minValue, int maxValue){
		
		if(root == null)
			return true;
		
		if(root.data<minValue || root.data>maxValue){
			return false;
		}
		
		return isBTaBST(root.getLeftNode(),minValue,root.data) && 
				isBTaBST(root.getRightNode(), root.data, maxValue);
	}
	
	public static boolean isBinaryTreeBSTInOrder(BinaryTreeNode root){
		
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		
		boolean isEnd = false;
		BinaryTreeNode temp = root;
		int val = 0;
		while(!isEnd){
			
			if(temp!=null){
				stack.push(temp);
				temp=temp.leftNode;
			}else {
				
				if(stack.isEmpty())
					isEnd=true;
				else{
					
					temp = stack.pop();
					if(val>temp.data){
						return false;
					}
					System.out.println(temp.data);
					val = temp.data;
					temp=temp.rightNode;
				}
				
			}	
			
			
			
		}
		
		return true;
		
	}
	
	
	public static void main(String[] args){
		
		System.out.println(isBinaryTreeBSTInOrder(BinaryTreeNode.createTree()));
		
	}
}
