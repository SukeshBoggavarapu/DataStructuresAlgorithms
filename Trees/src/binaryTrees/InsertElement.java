package binaryTrees;

import java.util.Stack;

public class InsertElement {
	
	public static BinaryTreeNode insertElement(BinaryTreeNode root,int data){
		
		BinaryTreeNode newNode = new BinaryTreeNode(data,null,null);
		
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		boolean isEnded = false;
		BinaryTreeNode node =root;
		while(!isEnded){
			
			if(node!=null){			
				stack.push(node);
				node = node.getLeftNode();
			}else {
				if(stack.isEmpty()){
					isEnded = true;
				}else {
					stack.pop().setLeftNode(newNode);
					break;
				}
			}
			
		}
		return root;
	}

	public static void main(String[] args) {
		
		BinaryTreeNode rootNode = BinaryTreeNode.createTree();
		
		insertElement(rootNode,5);
		System.out.println("Done");
	}

}
