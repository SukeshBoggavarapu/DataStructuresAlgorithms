package binaryTrees;

import java.util.Stack;

public class PostOrderTraversal {

	public static void postOrderRecursive(BinaryTreeNode node){
		
		if(node==null){
			
			return ;
		}
		
		postOrderRecursive(node.getLeftNode());
		postOrderRecursive(node.getRightNode());
		System.out.println(node.getData());
	}
	
	public static void postOrderIterative(BinaryTreeNode node){
		
		if(node==null){
			return;
		}
		
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		stack.push(node);
		
		BinaryTreeNode prev = null;
		BinaryTreeNode currentNode = null;
		
		while(!stack.isEmpty()){
			currentNode=stack.peek();
			
			//IF you are coming from root -- root is prev and child is current
			if(prev==null || prev.getLeftNode()==currentNode || prev.getRightNode()==currentNode){
				
				if(currentNode.getLeftNode()!=null){
					stack.push(currentNode.getLeftNode());		
				}else if(currentNode.getRightNode()!=null){
					stack.push(currentNode.getRightNode());	
				}		
			}
			//if you are done with left subtree -- prev is left child and current is root -- implies left is done and 
			//proceed with right
			else  if(currentNode.getLeftNode()==prev){
				
				if(currentNode.getRightNode()!=null){			
					stack.push(currentNode.getRightNode());
				}
			}
		// Left and right are done and hence print the data	
			else {			
				System.out.println(stack.pop().getData());
			}
			
			prev = currentNode;	
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
		postOrderRecursive(rootNode);
		
		System.out.println("Iterative is : ");
		postOrderIterative(rootNode);
		
	}
	}
