package leetcode;

import java.util.Stack;

import binarySearchTrees.BinarySearchTreeNode;

public class KthSmallest {
	
	public void kthsmallest(BinarySearchTreeNode root,int k){
		
		modifyTree(root);
		
		BinarySearchTreeNode node=  kthSmallestElement(root,k);
		System.out.println();
	}
	
	public BinarySearchTreeNode kthSmallestElement(BinarySearchTreeNode node,int k){
		
		if(k<=node.size){
			return kthSmallestElement(node.leftNode,k);
		}else if(k>node.size+1){
			return kthSmallestElement(node.rightNode, k-node.size-1);
		}
		
		return node;
		
	}
	
	public void modifyTree(BinarySearchTreeNode root){
		
		Stack<BinarySearchTreeNode> stk = new Stack<BinarySearchTreeNode>();
		stk.push(root);
		while(!stk.isEmpty()){
			
			BinarySearchTreeNode temp = stk.pop();
			if(temp.rightNode!=null){
				stk.push(temp.rightNode);
			}
		
			if(temp.leftNode!=null){
			temp.size=countNodes(temp.leftNode);
			stk.push(temp.leftNode);
			}
		}
		
	}
	
	public int countNodes(BinarySearchTreeNode temp){
		
		if(temp==null)
			return 0;
		return 1+countNodes(temp.leftNode)+countNodes(temp.rightNode);
		
	}
	
	public static void main(String[] args) {
		KthSmallest ks = new KthSmallest();
		ks.kthsmallest(BinarySearchTreeNode.createBinarySearchTree(), 4);
	}

}
