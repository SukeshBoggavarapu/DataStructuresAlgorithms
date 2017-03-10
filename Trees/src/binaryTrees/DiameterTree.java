package binaryTrees;

public class DiameterTree {
	
	static int diameter;
	
	public static int diameter(BinaryTreeNode node){
		
		if(node==null)
			return 0;
		
		int left;
		int right;
		left = diameter(node.getLeftNode());
		right=diameter(node.getRightNode());
		if(left+right>diameter)
			diameter = left+right+1;
		return Math.max(left, right)+1;
		
	}

	public static void main(String[] args) {
		diameter(BinaryTreeNode.createTree2());
		System.out.println(diameter);
		
	}

}
