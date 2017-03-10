package binaryTrees;

public class LeastCommonAncestor {
	
	
	public static BinaryTreeNode leastCommonAncestor(BinaryTreeNode node,int a , int b){
		
		if(node==null)
			return null;
		if(node.getData() ==a || node.getData() ==b)
			return node;
		
		BinaryTreeNode left = leastCommonAncestor(node.getLeftNode(),a,b);
		BinaryTreeNode right = leastCommonAncestor(node.getRightNode(),a,b);
		
		if(left!=null && right!=null)
			return node;
		else 
			return left!=null ? left :right;	
	}

	public static void main(String[] args) {
		
		System.out.println(leastCommonAncestor(BinaryTreeNode.createTree(),8,15).getData());
	}

}
