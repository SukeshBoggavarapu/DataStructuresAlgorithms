package binarySearchTrees;

public class SortedArrayToBST {
	
	
	
	public BinarySearchTreeNode sortedArrayToBST(int[] nums ,int start , int end){
		
		BinarySearchTreeNode root = null;
		if(start>end)
			return null;
		
		//Leafs or FinalNode to be created
		if(start == end){
			BinarySearchTreeNode node = new BinarySearchTreeNode(nums[start]);
			return node;
		}else {
			
			int mid = start + (end-start)/2;
			root = new BinarySearchTreeNode(nums[mid]);
			root.leftNode = sortedArrayToBST(nums,start,mid-1);
			root.rightNode=sortedArrayToBST(nums,mid+1, end);			
		}
		return root;
	}
	
	
	public static void main(String[] args){
		
		SortedArrayToBST sbst = new SortedArrayToBST();
		int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
		BinarySearchTreeNode root = sbst.sortedArrayToBST(nums, 0, nums.length-1);
		System.out.println();
		
		
	}
	

}
