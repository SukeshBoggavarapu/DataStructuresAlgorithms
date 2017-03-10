package binaryTrees;

import java.util.Stack;

public class InOrderTraversal {
	
	public static void inOrderRecursive(BinaryTreeNode node){
		
		if(node==null){
			return;
		}
		
		inOrderRecursive(node.getLeftNode());
		System.out.println(node.getData());
		inOrderRecursive(node.getRightNode());
		
	}
	
	public static void inOrderIterative(BinaryTreeNode currentNode){
		
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		boolean done = false;
			
			while(!done){
				
				if(currentNode!=null){					
					stack.push(currentNode);
					currentNode=currentNode.getLeftNode();
				}
				else{
					if(stack.isEmpty()){
						done=true;
					}
					else{
						currentNode = stack.pop();
						System.out.println(currentNode.getData());
						currentNode=currentNode.getRightNode();
					}
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
		inOrderRecursive(rootNode);
		
		System.out.println("Iterative is : ");
		inOrderIterative(rootNode);
		
	}

}
