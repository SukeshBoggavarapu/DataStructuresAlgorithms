package leetCode;

import java.util.Stack;

import binaryTrees.BinaryTreeNode;

public class SumOfLeftLeaves {
	
	/* public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	     TreeNode(int x) { val = x; }}*/
	
	
	 public static int sumOfLeftLeaves(BinaryTreeNode root) {
	        
	        if(root==null){return 0;}
	        
	        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
	        stack.push(root);
	        BinaryTreeNode temp;
	        int sum =0;
	        while(!stack.isEmpty()){
	            temp = stack.pop();
	            if(temp.getRightNode()!=null){
	                
	                stack.push(temp.getRightNode());
	            }
	            
	            if(temp.getLeftNode()!=null){
	                
	                stack.push(temp.getLeftNode());
	                if(temp.getLeftNode().getLeftNode()==null && temp.getLeftNode().getRightNode()==null){
	                    sum=sum+temp.getLeftNode().getData();
	                }
	            }
	        }
	        
	        return sum;
	        
	    }

	public static void main(String[] args) {
		System.out.println(sumOfLeftLeaves(BinaryTreeNode.createTree3()));
	}

}
