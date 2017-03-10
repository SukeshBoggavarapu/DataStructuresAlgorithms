package binaryTrees;

public class TreeSize {
	
	public static int size =0;
	
	public static int treeSize(BinaryTreeNode root){
		
		if(root!=null){	
			size=size+1;
			treeSize(root.getLeftNode());
			treeSize(root.getRightNode());
		}
		return size;
	}

	public static void main(String[] args) {
		
		BinaryTreeNode rootNode = BinaryTreeNode.createTree();
		System.out.println(treeSize(rootNode));
	}

}
