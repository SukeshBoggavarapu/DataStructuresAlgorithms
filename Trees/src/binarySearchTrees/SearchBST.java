package binarySearchTrees;

public class SearchBST {

	public static boolean searchBST(BinarySearchTreeNode root , int data){
		
		if(root==null)
			return false;
		if(data<root.getData())
			return searchBST(root.getLeftNode(),data);
		else if(data>root.getData())
			return searchBST(root.getRightNode(), data);
		return true;	
	}
	
	public static boolean searchBSTIterative(BinarySearchTreeNode root,int data){
		
		if(root==null)
			return false;
		
		while(root!=null){
			
			if(data<root.getData())
				root=root.getLeftNode();
			else if(data>root.getData())
				root=root.getRightNode();
			else {
				return true;
			}
			
		}
		
		return false;
		
	}
	public static void main(String[] args) {
		
		System.out.println(searchBST(BinarySearchTreeNode.createBinarySearchTree() , 29));
		System.out.println(searchBSTIterative(BinarySearchTreeNode.createBinarySearchTree() , 29));

	}

}
