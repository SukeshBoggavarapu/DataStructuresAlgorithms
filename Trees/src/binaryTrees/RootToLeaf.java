package binaryTrees;

import java.util.Stack;

public class RootToLeaf {
	
	public void rootToLeaf(BinaryTreeNode root,int target){
		
		if(root==null)
			return ;
		Stack<BinaryTreeNode> stk = new Stack<BinaryTreeNode>();
		stk.push(root);
		root.parent=null;
		
		while(!stk.isEmpty()){
			BinaryTreeNode node = stk.pop();
			if(node.data==target)
				printPath(node);
			if(node.rightNode!=null){
				node.rightNode.data=node.data+node.rightNode.data;
				stk.push(node.rightNode);
				node.rightNode.parent=node;
			}
			
			if(node.leftNode!=null){
				node.leftNode.data=node.leftNode.data+node.data;
				stk.push(node.leftNode);
				node.leftNode.parent=node;
			}
			
		}
		
	}
	
	public void recursive(BinaryTreeNode root,int target ,int sum){
		
		if(root==null)
			return;
		if(root.leftNode==null && root.rightNode ==null && target== sum+root.data)
			printPath(root);
		if(root.leftNode!=null)
			root.leftNode.parent=root;
		recursive(root.leftNode,target, root.data+sum);
		if(root.rightNode!=null)
			root.rightNode.parent=root;
		recursive(root.rightNode,target, root.data+sum);
		
	}

	public void printPath(BinaryTreeNode node) {
		int sum =0;
		while(node!=null){
			sum+=node.data;
			System.out.println(node.data+" -- sum is --" + sum);
			node=node.parent;
		}
	}

	public static void main(String[] args) {
	RootToLeaf rl = new RootToLeaf();
	//System.out.println(rl);
	//rl.rootToLeaf(BinaryTreeNode.createTree(), 20);
	rl.recursive(BinaryTreeNode.createTree2(), 41, 0);
	}

	
}
