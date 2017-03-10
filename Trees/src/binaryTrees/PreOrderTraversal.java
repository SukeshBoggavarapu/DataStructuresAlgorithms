package binaryTrees;

import java.util.Stack;

public class PreOrderTraversal {

	public static void preOrderRecursive(BinaryTreeNode node){
		
		if(node==null){
			return;
		}
		
		System.out.println(node.getData());
		preOrderRecursive(node.getLeftNode());
		preOrderRecursive(node.getRightNode());

	}
	
	public static void preOrderIterative(BinaryTreeNode node){
		
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		stack.push(node);
		
		while(!stack.isEmpty()){
			BinaryTreeNode given = stack.pop();			
			System.out.println(given.getData());
			
			if(given.getRightNode()!=null){
				stack.push(given.getRightNode());
			}
			
			if(given.getLeftNode()!=null){
				stack.push(given.getLeftNode());
			}
		}
		
		
	}
	
	
	public static void main(String[] args){
		
		BinaryTreeNode rootNode = new BinaryTreeNode(1,null,null);
		
		//LeftSubTree
		
		BinaryTreeNode leftSubTreeRoot1= new BinaryTreeNode(2,null,null);
		BinaryTreeNode leftLeafLeft = new BinaryTreeNode(4,null,null);
		leftSubTreeRoot1.setLeftNode(leftLeafLeft);
		BinaryTreeNode rightLeafLeft = new BinaryTreeNode(5,null,null);
		leftSubTreeRoot1.setRightNode(rightLeafLeft);
		
		//RightSubTree
		
		BinaryTreeNode rightSubTreeRoot1= new BinaryTreeNode(3,null,null);
		BinaryTreeNode leftLeafRight = new BinaryTreeNode(6,null,null);
		rightSubTreeRoot1.setLeftNode(leftLeafRight);
		BinaryTreeNode rightLeafRight = new BinaryTreeNode(7,null,null);
		rightSubTreeRoot1.setRightNode(rightLeafRight);
		
		rootNode.setLeftNode(leftSubTreeRoot1);
		rootNode.setRightNode(rightSubTreeRoot1);
		
		System.out.println("Recursive is : ");
		preOrderRecursive(rootNode);
		
		System.out.println("Iterative is : ");
		preOrderIterative(rootNode);
		
	}
	
	
	
}
