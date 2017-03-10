package leetcode;

import binaryTrees.BinaryTreeNode;

public class HouseRobber3 {
	
	public int houseRobber3(BinaryTreeNode root){
		
		int[] res = rob(root);
		return Math.max(res[0], res[1]);
		
	}
	
	public int[] rob(BinaryTreeNode root){
		
		if(root ==null) return new int[2];
		
		int[] left = rob(root.leftNode);
		int[] right = rob(root.rightNode);
		int[] vals = new int[2];
		
		vals[0]=Math.max(left[0], left[1])+Math.max(right[0], right[1]);
		vals[1]=root.data+left[0]+right[0];
		
		return vals;
		
		
	}

}
