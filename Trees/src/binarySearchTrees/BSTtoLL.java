package binarySearchTrees;

import java.util.Stack;

public class BSTtoLL {
	
	public DLL BSTtoLL(BinarySearchTreeNode root){
		DLL rootNode = new DLL();
		DLL tempNode = rootNode;
		
		Stack<BinarySearchTreeNode> stk = new Stack<BinarySearchTreeNode>();
		while(true){
			
			if(root!=null){
				stk.push(root);
				root=root.leftNode;
				
			}else{
				if(stk.isEmpty()){
					tempNode.next=rootNode.next;
					rootNode.next.prev=tempNode;
					break;
				}
					
				root = stk.pop();
				DLL cNode = new DLL(root.data);
				tempNode.next=cNode;
				cNode.prev=tempNode;
				tempNode=tempNode.next;
				System.out.println(root.data);
				root=root.rightNode;
			}
			
		}
		
		return rootNode.next;
	}

	public static void main(String[] args) {
		BSTtoLL bll = new BSTtoLL();
		DLL res = bll.BSTtoLL(BinarySearchTreeNode.createBinarySearchTree());
		System.out.println();
		
	}

}



