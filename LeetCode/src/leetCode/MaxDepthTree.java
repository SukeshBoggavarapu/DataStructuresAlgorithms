package leetCode;

public class MaxDepthTree {
	
	
	 // Definition for a binary tree node.
	
	
	
	    public static int maxDepth(TreeNode root) {
	        if(root==null){
	            return 0;
	        }
	        else {return 1+ Math.max(maxDepth(root.left),maxDepth(root.right));}
	}

	public static void main(String[] args) {
		TreeNode node = null;
		System.out.println(maxDepth(node));

	}

}

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
   TreeNode(int x) { val = x; }}
