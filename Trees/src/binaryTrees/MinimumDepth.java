package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepth {
	
	public static int minDepth(BinaryTreeNode node){
		
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(node);
		queue.offer(null);
		
		if(node==null || node.getLeftNode() == null || node.getRightNode() ==null){
			return 0;
		}
		int depth =0;
		
		BinaryTreeNode temp;
		
		while(!queue.isEmpty()){
			temp = queue.poll();
			
			if(temp!=null){
				
				if(temp.getLeftNode()==null && temp.getRightNode() == null){
					break;
				}
				
				if(temp.getRightNode()!=null)
				queue.offer(temp.getRightNode());
				if(temp.getLeftNode()!=null)
				queue.offer(temp.getLeftNode());
			}else {
				if(!queue.isEmpty()){
					queue.offer(null);
					depth++;
				}
			}
		}
		
		return depth;
	}

	public static void main(String[] args) {
		
		System.out.println(minDepth(BinaryTreeNode.createTree()));
		
		BinaryTreeNode rootNode = new BinaryTreeNode(10,null,null);
		
		//LeftSubTree
		
		BinaryTreeNode leftSubTreeRoot1= new BinaryTreeNode(2,null,null);
	
		
		//RightSubTree
		
		BinaryTreeNode rightSubTreeRoot1= new BinaryTreeNode(3,null,null);
		BinaryTreeNode leftLeafRight = new BinaryTreeNode(6,null,null);
		rightSubTreeRoot1.setLeftNode(leftLeafRight);
		BinaryTreeNode rightLeafRight = new BinaryTreeNode(7,null,null);
		rightSubTreeRoot1.setRightNode(rightLeafRight);
		
		rootNode.setLeftNode(leftSubTreeRoot1);
		rootNode.setRightNode(rightSubTreeRoot1);
		
		System.out.println(minDepth(rootNode));
	}

}
