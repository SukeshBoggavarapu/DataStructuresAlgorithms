package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteNode {
	
	public static void deleteNode(BinaryTreeNode root , int data){
		
		//BinaryTreeNode leftFirstLeafNode = LeftfirstLeaf(root);
		BinaryTreeNode deepestNode = deepestNode(root);
		findAndReplace(root, data , deepestNode);
		
		System.out.println("ENd");
		
		
	}
	
	private static void findAndReplace(BinaryTreeNode root, int data, BinaryTreeNode deepestNode) {
		
		if(root!=null){			
			if(root.getData()!=data){
				findAndReplace(root.getLeftNode(), data,deepestNode);
				findAndReplace(root.getRightNode(),data,deepestNode);
			}else {
				root.setData(deepestNode.getData());
			}
			
		}
		
	}

	private static BinaryTreeNode deepestNode(BinaryTreeNode root) {
		
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		BinaryTreeNode temp =null;
		while (!queue.isEmpty()){
			temp = queue.poll();
			if(temp.getRightNode()!=null){
				queue.offer(temp.getRightNode());
			}
			
			if(temp.getLeftNode()!=null){
				queue.offer(temp.getLeftNode());
			}
		}
		return temp;
	}

	public static BinaryTreeNode LeftfirstLeaf(BinaryTreeNode node){
		
		if(node.getLeftNode()!=null && node.getRightNode()!=null){
			LeftfirstLeaf(node.getLeftNode());
		}
		
		return node;
	}
	
	
	public static void main(String[] args) {
		
		deleteNode(BinaryTreeNode.createTree(),3);
		
	}

}
