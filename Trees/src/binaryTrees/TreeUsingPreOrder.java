 package binaryTrees;

public class TreeUsingPreOrder {
	
	static int i=0;
	
	public static BinaryTreeNode treeUsingPreOrder(char[] nodes){
		
		char nodeVal = nodes[i];
		BinaryTreeNode node = new BinaryTreeNode(nodeVal*i,null,null);
		if(nodeVal=='L')
			return node;
		i++;
		node.setLeftNode(treeUsingPreOrder(nodes));
		i++;
		node.setRightNode(treeUsingPreOrder(nodes));	
		return node;
		
	}
	
	public static void main(String[] args){
		char[] nodes = new char[]{'I','L','I','L','L'};
		BinaryTreeNode root =treeUsingPreOrder(nodes);
		System.out.println(root);
	}

}
