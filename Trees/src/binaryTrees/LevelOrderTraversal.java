package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	
	public static void levelOrderTraversal(BinaryTreeNode root){
		
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		queue.offer(null);
		
		while(!queue.isEmpty()){
			
			BinaryTreeNode node = queue.poll();
			if(node!=null){
				System.out.println(node.getData());
				
				if(node.getLeftNode()!=null){
					queue.offer(node.getLeftNode());
				}
				if(node.getRightNode()!=null){
					queue.offer(node.getRightNode());
				}
			}else{
				
				if(!queue.isEmpty()){
					queue.offer(null);
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
		levelOrderTraversal(rootNode);
	}

}
