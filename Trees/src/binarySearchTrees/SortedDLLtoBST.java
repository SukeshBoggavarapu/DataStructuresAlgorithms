package binarySearchTrees;


public class SortedDLLtoBST {
	
	
	public static BinarySearchTreeNode dllToBST(DLL rootNode) {
		
		if(rootNode == null)
			return null;
		
		DLL sp = rootNode.next;
		int length =1;
		
		while(sp!=rootNode){
			sp =sp.next;
			length++;
		}
		
		return constructBST(rootNode,0,length);
		
		
	}
	
	public static BinarySearchTreeNode constructBST(DLL node, int start , int end) {
		
			if(start>end)
				return null;
			
			int mid = start + (end-start)/2 ;
			
			BinarySearchTreeNode left = constructBST(node,start,mid-1);
			BinarySearchTreeNode root = new BinarySearchTreeNode(node.data);
			root.leftNode=left;
		
			if(node.next!=null){
				node.data = node.next.data;
				node.next = node.next.next;
			}
			
			root.rightNode= constructBST(node,mid+1,end);
			
			return root;
	}

	public static void main(String[] args){
		
		
		DLL node = BSTtoDLL.convertBSTtoDLL(BinarySearchTreeNode.createBinarySearchTree());
		
		BinarySearchTreeNode root = dllToBST(node);
		System.out.println(root);
		
		
	}
	
}
