package binarySearchTrees;

import java.util.Stack;

public class BSTtoDLL {
		
	public static DLL convertBSTtoDLL(BinarySearchTreeNode root){
		
		Stack<BinarySearchTreeNode> stack = new Stack<BinarySearchTreeNode>();
		
		boolean isEnd = false;
		boolean isFirstNode = true;
		DLL rootNode = null;
		DLL tempNode = null;
		
		while(!isEnd){
			
			if(root!=null){
				stack.push(root);
				root=root.leftNode;
			}else {
				
				if(stack.isEmpty()){
					isEnd=true;
					tempNode.next=rootNode;
					rootNode.prev=tempNode;
				}else {
					
					root = stack.pop();
					if(isFirstNode){
						rootNode = new DLL(root.data);	
						 tempNode = rootNode;
						 isFirstNode = false;
					}else{
					    DLL nextNode = new DLL(root.data);
					    tempNode.next = nextNode;
					    nextNode.prev = tempNode;
					    tempNode = nextNode;
					}
					root=root.rightNode;
				}
				
			}
		}
		return rootNode;	
	}	
	
	
	public static void main(String[] args){
		
		DLL node = convertBSTtoDLL(BinarySearchTreeNode.createBinarySearchTree());
		System.out.println(node);
		
	}
}

 class DLL{
	 
	 DLL prev;
	 DLL next;
	 int data;
	 
	 public DLL(int data){
		this.data=data;
	 }
	 public DLL(){}
 }
