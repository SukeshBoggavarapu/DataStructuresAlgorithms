package binaryTrees;

import java.util.Stack;

public class ElementSearch {
	
	static 	boolean isExists = false;
	
	public static boolean elementSearch(BinaryTreeNode node,int data)
	{	
		if(node!=null && !isExists){
			
			if(node.getData()==data){
				isExists = true;
			}
			 elementSearch(node.getLeftNode(),data);
			 elementSearch(node.getRightNode(),data);
		}
		
		return isExists;
	}
	
	public static boolean elementSearchIterative(BinaryTreeNode node,int data){
		
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		stack.push(node);
		BinaryTreeNode temp;
		while(!stack.isEmpty()){
			temp = stack.pop();
			if(temp.getData()==data){
				return true;
			}
			
			if(temp.getRightNode()!=null){
				stack.push(temp.getRightNode());
			}		
			if(temp.getLeftNode()!=null){
				stack.push(temp.getLeftNode());
			}
		}
		
		return false;
	}
	
	public static void main(String[] args){
		
		BinaryTreeNode rootNode = BinaryTreeNode.createTree();
		System.out.println(elementSearch(rootNode,10));
		System.out.println(elementSearchIterative(rootNode,15));
	}
}
