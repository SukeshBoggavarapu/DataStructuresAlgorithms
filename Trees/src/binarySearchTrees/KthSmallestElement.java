package binarySearchTrees;

public class KthSmallestElement {
	
	static int count =0;
	static int val =0;
	
	public static int kthSmallestElement(BinarySearchTreeNode root,int k){
		
		if(root==null)
			return 0;
		

			
			kthSmallestElement(root.leftNode,k);
			count++;
			if(count==k){
			val= root.data;
			}
			kthSmallestElement(root.rightNode,k);
		
		
		return val;
		
	}
	
	
	public static void main(String[] args){
		
		System.out.println(kthSmallestElement(BinarySearchTreeNode.createBinarySearchTree(), 1));
		
	}

}
