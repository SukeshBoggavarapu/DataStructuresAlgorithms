package binarySearchTrees;

public class ClosestBinarySearchTreeValue {
	
	
	public int closestBinVal(BinarySearchTreeNode root,int target){
		
		return closestVal(root,target,Integer.MAX_VALUE);
	
	}
	
	public int closestVal(BinarySearchTreeNode root,int target ,int min){
		
		if(root==null)
			return Integer.MAX_VALUE;
		
		int diff = Math.abs(root.data-target);
	
		
			int val1 = closestVal(root.leftNode,target,diff);
			 int val2 = closestVal(root.rightNode,target,diff);	

		
		return Math.min(diff, Math.min(val1, val2));
		
		
	}

	public static void main(String[] args) {
		ClosestBinarySearchTreeValue cbst = new ClosestBinarySearchTreeValue();
		System.out.println(cbst.closestBinVal(BinarySearchTreeNode.createBinarySearchTree(), 9));
	}

}
