package binaryTrees;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {
	
	static List<List<Integer>> fList = new ArrayList<List<Integer>>();
	static List<Integer> list = new ArrayList<Integer>();
	
	public static int findLeavesOfBinaryTree(BinaryTreeNode root){
		
		if(root == null)
			return -1;
		

		int left =findLeavesOfBinaryTree(root.getLeftNode());
		int right = findLeavesOfBinaryTree(root.getRightNode());
		
		int cur = Math.max(left, right) +1;
		
		if(fList.size()<=cur){
			fList.add(new ArrayList<>());
		}
		
		fList.get(cur).add(root.getData());
		return cur;
		
	}
	
	
	public static void main(String[] args){
		
		findLeavesOfBinaryTree(BinaryTreeNode.createTree2());
		System.out.println();
		
	}

}
