package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumElement {
	
	public static int maximumElement(BinaryTreeNode node){
		int maxValue;
		
		if(node.getLeftNode()==null && node.getRightNode()==null){
			return node.getData();
		}
		int maxLeft;
		if(node.getLeftNode()!=null){
			maxLeft=maximumElement(node.getLeftNode());
		}else{
			maxLeft=0;
		}
		int maxRight;
		if(node.getRightNode()!=null){
			maxRight=maximumElement(node.getRightNode());
		}else{
			maxRight=0;
		}
		if(maxLeft<=maxRight){
			maxValue = maxRight;
		}else{
			maxValue= maxLeft;
		}
		
		if(node.getData()>maxValue){
			maxValue= node.getData();
		}
		
		return maxValue;
	}
	
	public static int getMaximumElementLevelOrderTraversal(BinaryTreeNode root){
		
		int maxValue = Integer.MIN_VALUE;
		BinaryTreeNode temp;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		queue.offer(null);
		//maxValue = root.getData();
		
		while(!queue.isEmpty()){
			
			temp = queue.poll();
			
			
		if(temp!=null){
			
			if(temp.getData()>maxValue){
				maxValue = temp.getData();
			}
			
			if(temp.getLeftNode()!=null){
				/*if(temp.getLeftNode().getData()>maxValue){
					maxValue = temp.getLeftNode().getData();
				}*/
				queue.offer(temp.getLeftNode());
			}
			if(temp.getRightNode()!=null){
				/*if(temp.getRightNode().getData()>maxValue){
					maxValue = temp.getRightNode().getData();
				}*/
				queue.offer(temp.getRightNode());
			}
		}else {
			if(!queue.isEmpty()){
				queue.offer(null);
			}
		}
			
			
			
		}
		return maxValue;
	}
	
	public static void main(String[] args){
		
		
		BinaryTreeNode rootNode = BinaryTreeNode.createTree();
		System.out.println(maximumElement(rootNode));
		System.out.println(getMaximumElementLevelOrderTraversal(rootNode));
	}

}
