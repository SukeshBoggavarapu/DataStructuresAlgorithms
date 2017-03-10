package binaryTrees;

public class TreeMirror {
	
	public static BinaryTreeNode treeMirror(BinaryTreeNode root){
		if(root==null)
			return null;
		BinaryTreeNode temp = root.getLeftNode();
		root.setLeftNode(root.getRightNode());
		root.setRightNode(temp);
		
		treeMirror(root.getLeftNode());
		treeMirror(root.getRightNode());
		
		return root;
		
	}

	public static void main(String[] args) {
		
		BinaryTreeNode mirrorTree = treeMirror(BinaryTreeNode.createTree2());
		System.out.println(mirrorTree);

	}

}
