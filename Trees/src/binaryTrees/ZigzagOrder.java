package binaryTrees;

import java.util.Stack;	

public class ZigzagOrder {
	
	public static void printTreeInZigzagOrder(BinaryTreeNode node){
		
		
		BinaryTreeNode temp;
		Stack<BinaryTreeNode> stack1 = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> stack2 = new Stack<BinaryTreeNode>();
		stack1.push(node);
		while(!stack1.isEmpty() || !stack2.isEmpty()){
			
			while(!stack1.isEmpty()){
				
				temp = stack1.peek();
				System.out.println(stack1.pop().getData());
				
				if(temp.getLeftNode()!=null)
					stack2.push(temp.getLeftNode());
				if(temp.getRightNode()!=null)
					stack2.push(temp.getRightNode());
				
			}
			
			while(!stack2.isEmpty()){
				
				temp=stack2.peek();
				System.out.println(stack2.pop().getData());
				
				if(temp.getRightNode()!=null)
					stack1.push(temp.getRightNode());
				if(temp.getLeftNode()!=null)
					stack1.push(temp.getLeftNode());
			}
		}
		
		
		
	}

	public static void main(String[] args) {
		
		printTreeInZigzagOrder(BinaryTreeNode.createTree2());
	}

}
