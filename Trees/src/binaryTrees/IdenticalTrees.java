package binaryTrees;

public class IdenticalTrees {
	
	public static boolean isIdenticalTrees(BinaryTreeNode root1, BinaryTreeNode root2){
		
		if(root1==null && root2 == null)
			return true;
		else if(root1 ==null || root2 ==null)
			return false;
		else if(root1.getData()!=root2.getData())
			return false;
		
		return isIdenticalTrees(root1.getLeftNode(),root2.getLeftNode()) &&
				isIdenticalTrees(root1.getRightNode(),root2.getRightNode());
	}

	public static void main(String[] args) {
		
	}

}
